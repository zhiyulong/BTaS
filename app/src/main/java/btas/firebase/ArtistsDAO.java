package btas.firebase;

import javax.annotation.Nonnull;
import javax.inject.Named;

import com.google.cloud.firestore.Firestore;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import btas.firebase.model.Artist;

@Named
@Singleton
public class ArtistsDAO extends FirestoreDAO<Artist> {

    @Inject
    public ArtistsDAO(@Nonnull @Named("artist_collection") String collection, Firestore firestore) {
        super(collection, firestore);
    }
}
