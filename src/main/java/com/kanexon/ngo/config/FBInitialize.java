package com.kanexon.ngo.config;

import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FBInitialize {

	@PostConstruct
	public void initialize() {
		try {
			/*
			 * FileInputStream serviceAccount = new
			 * FileInputStream("classpath:kenexon-2020-firebase-serviceaccount.json");
			 */
			InputStream serviceAccount = getClass().getResourceAsStream("/kenexon-2020-firebase-serviceaccount.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://chatapp-e6e15.firebaseio.com").build();

			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}