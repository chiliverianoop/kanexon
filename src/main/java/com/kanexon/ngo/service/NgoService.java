package com.kanexon.ngo.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.kanexon.ngo.model.NgoBaseModel;

@Service
public class NgoService {

	private static final String COLLECTION_NAME = "OrgProfile";

	public String saveNgoDetails(NgoBaseModel ngo) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(ngo.getNgoUniqueId())
				.set(ngo);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public NgoBaseModel getNgoDetails(String ngoUniqueId) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(ngoUniqueId);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		return document.exists() ? document.toObject(NgoBaseModel.class) : null;

	}

	public String updateNgoDetails(NgoBaseModel ngo) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME)
				.document(ngo.getNgoUniqueId()).set(ngo, SetOptions.merge());
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public String deleteNgoDetails(String ngoUniqueId) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection(COLLECTION_NAME).document(ngoUniqueId).delete();
		return writeResult.get().getUpdateTime().toString();
	}

}
