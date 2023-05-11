package btas.firebase;

import javax.annotation.Nonnull;
import javax.inject.Named;

import com.google.cloud.firestore.Firestore;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import btas.firebase.model.Merch;

@Named
@Singleton
public class MerchDAO extends FirestoreDAO<Merch> {

    @Inject
    public MerchDAO(@Nonnull @Named("merch_collection") String collection, Firestore firestore) {
        super(collection, firestore);
    }
    
}
