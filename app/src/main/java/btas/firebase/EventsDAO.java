package btas.firebase;

import javax.annotation.Nonnull;
import javax.inject.Named;

import com.google.cloud.firestore.Firestore;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import btas.firebase.model.Event;

@Named
@Singleton
public class EventsDAO extends FirestoreDAO<Event> {
    
    @Inject
    public EventsDAO(@Nonnull @Named("event_collection") String collection, Firestore firestore) {
        super(collection, firestore);
    }

}
