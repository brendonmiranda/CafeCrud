package com.brendon.crudcafe.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.brendon.crudcafe.repository")
public class MongodbConfiguration extends AbstractMongoClientConfiguration {

    @Value("${mongodb.conn}")
    public String conn;

    @Override
    public MongoClientSettings mongoClientSettings() {

        final MongoClientSettings.Builder builder = MongoClientSettings.builder();
        builder.uuidRepresentation(UuidRepresentation.JAVA_LEGACY);
        final var connectionString =
                new ConnectionString(conn);
        builder.applyConnectionString(connectionString);

        configureClientSettings(builder);

        return builder.build();
    }

    @Override
    protected String getDatabaseName() {
        return "cafedb";
    }
}
