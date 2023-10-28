package com.server.inteliGmy;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@SpringBootApplication
public class InteliGmyApplication {

    public static void main(String[] args) throws IOException {

        InputStream serviceAccountStream = InteliGmyApplication.class.getResourceAsStream("/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(Objects.requireNonNull(serviceAccountStream)))
                .build();

        // Verifica se o FirebaseApp já foi inicializado com o nome "DEFAULT"
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }

        SpringApplication.run(InteliGmyApplication.class, args);
    }


}
