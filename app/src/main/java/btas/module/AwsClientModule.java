package btas.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class AwsClientModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    private DynamoDbClient providesDynamoDbClient() {
        return DynamoDbClient.builder()
        .credentialsProvider(ProfileCredentialsProvider.create())
        .region(Region.US_EAST_2).build();
    }

}
