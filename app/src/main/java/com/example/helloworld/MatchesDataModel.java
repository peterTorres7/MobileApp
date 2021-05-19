package com.example.helloworld;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MatchesDataModel {
    private FirebaseFirestore db;
    private List<ListenerRegistration> listeners;

    public MatchesDataModel() {
        db = FirebaseFirestore.getInstance();
        listeners = new ArrayList<>();
    }

    public void getMatches(Consumer<QuerySnapshot> dataChangedCallback, Consumer<FirebaseFirestoreException> dataErrorCallback) {
        ListenerRegistration registration = db.collection("matches").addSnapshotListener((queryDocumentSnapshots, e) -> {
            if (e != null) {
                dataErrorCallback.accept(e);
            }
            dataChangedCallback.accept(queryDocumentSnapshots);
        });
        listeners.add(registration);
    }

    public void addMatches(MatchesModel matchesModel) {
        CollectionReference toDoMatchesRef = db.collection("matches");
        toDoMatchesRef.add(matchesModel);
    }

    public void updateMatches(MatchesModel matchesModel) {
        DocumentReference matchesModelRef = db.collection("matches").document(matchesModel.uid);

        Map<String, Object> info = new HashMap<>();
        info.put("imageUrl", matchesModel.imageUrl);
        info.put("name", matchesModel.name);
        info.put("liked", matchesModel.liked);
        matchesModelRef.update(info);
    }

    public void clear() {
        listeners.forEach(ListenerRegistration::remove);
    }
}
