package btas.firebase;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.inject.Inject;

import btas.firebase.model.BtasModel;

public abstract class FirestoreDAO<T extends BtasModel> {
    
    private static final ObjectMapper objectMapper = new ObjectMapper();

    CollectionReference colRef;
    
    @Inject
    FirestoreDAO(@Nonnull String collection, Firestore firestore) {
        this.colRef = firestore.collection(collection);
    }

    public T addOrUpdate(@Nonnull T item, String id) throws InterruptedException, ExecutionException {
        if (id == null) {
            throw new IllegalArgumentException("Item ID couldn't be null.");
        }
        Map<String, Object> data = objectMapper.convertValue(item, new TypeReference<Map<String, Object>>(){});

        DocumentReference docRef = colRef.document(id);
        ApiFuture<WriteResult> future = docRef.set(data);
        WriteResult res = future.get();

        System.out.println("Firestore finished adding in time: " + res.getUpdateTime());

        return item;
    }

    public String addWithoutId(Map<String, T> data) throws InterruptedException, ExecutionException {
        ApiFuture<DocumentReference> addedDocRef = colRef.add(data);
        String newId = addedDocRef.get().getId();
        return newId;
    }

    public T delete(@Nonnull T item, String id) throws InterruptedException, ExecutionException {
        if (id == null) {
            throw new IllegalArgumentException("Item ID couldn't be null.");
        }
        ApiFuture<WriteResult> deletedDocRef = colRef.document(id).delete();
        WriteResult res = deletedDocRef.get();

        System.out.println("Firestore finished deleting in time: " + res.getUpdateTime());

        return item;
    }

    @SuppressWarnings("unchecked")
    public T getDocById(@Nonnull T object, String id) throws InterruptedException, ExecutionException {
        if (id == null) {
            return null;
        }
        DocumentReference docRef = colRef.document(id);
        DocumentSnapshot document = docRef.get().get();
        
        if (document.exists()) 
            return (T) document.toObject(object.getClass());
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll(Class<? extends BtasModel> type) throws InterruptedException, ExecutionException {
        ApiFuture<QuerySnapshot> future = colRef.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        
        List<T> items = new ArrayList<>();
        documents.forEach(doc -> {
            items.add((T) doc.toObject(type));
        });
        return items;
    }
}
