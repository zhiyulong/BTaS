package btas.module;

import javax.inject.Named;

import com.google.inject.AbstractModule;
import com.talanlabs.guicetools.scan.ComponentScanModule;


public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new FirebaseClientModule());
        install(new AwsClientModule());
        install(new ComponentScanModule("btas", Named.class));
    }
    
}
