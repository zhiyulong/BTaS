package btas.module;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class FirebaseClientModule extends AbstractModule {
    
    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("event_collection")).to("events");
        bindConstant().annotatedWith(Names.named("artist_collection")).to("artists");
        bindConstant().annotatedWith(Names.named("fund_collection")).to("event_funds");
        bindConstant().annotatedWith(Names.named("merch_collection")).to("merch");
    }

    @Provides
    @Singleton
    private Firestore providesFirestore() {
        try {
            // FileInputStream refreshToken = new FileInputStream("app/src/main/resources/firebaseToken.json");
            FileInputStream refreshToken = new FileInputStream("firebaseToken.json");
            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(refreshToken))
                .setProjectId("btas-2a987")
                .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FirestoreClient.getFirestore();
    }

}
