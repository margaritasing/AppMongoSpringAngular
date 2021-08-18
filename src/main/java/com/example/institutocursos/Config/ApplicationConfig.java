package com.example.institutocursos.Config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.EnvironmentAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages="com.example.institutocursos.Repository")
public class ApplicationConfig extends AbstractMongoClientConfiguration {
    @Autowired
    private Environment env;

    @Override
    protected String getDatabaseName() {
        return env.getProperty("mongodb.database");
    }

    @Override
    public MongoClient mongoClient() {

        ConnectionString connectionString = new ConnectionString(env.getProperty("mongodb+srv://margarita_sing:ange09lina08.@cluster0.m307z.mongodb.net/instituto"));

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                //.applyToSslSettings(builder -> builder.enabled(false))
                .applyConnectionString(connectionString)
                .build();

        MongoClient mongoClient = MongoClients.create(mongoClientSettings);
        MongoDatabase database = mongoClient.getDatabase("instituto");

        return MongoClients.create((ConnectionString) database);

    }




        @Override
        protected Collection<String> getMappingBasePackages() {
            return Collections.singleton("com.example.institutocursos");
        }

}
