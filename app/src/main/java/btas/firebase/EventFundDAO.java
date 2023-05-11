package btas.firebase;

import java.util.concurrent.ExecutionException;

import javax.annotation.Nonnull;
import javax.inject.Named;

import com.google.cloud.firestore.Firestore;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import btas.firebase.model.Event;
import btas.firebase.model.EventFund;

@Named
@Singleton
public class EventFundDAO extends FirestoreDAO<EventFund> {
    
    @Inject
    private EventsDAO eventsDAO;

    @Inject
    public EventFundDAO(@Nonnull @Named("fund_collection") String collection, Firestore firestore) {
        super(collection, firestore);
    }

    @Override
    public EventFund addOrUpdate(@Nonnull EventFund eventFund, String id) throws InterruptedException, ExecutionException {
        Event event = eventsDAO.getDocById(new Event(), eventFund.getId());
        if (event == null) {
            throw new IllegalArgumentException("Event with the event id doesn't exist: " + id);
        }
        return super.addOrUpdate(eventFund, id);
    }
}
