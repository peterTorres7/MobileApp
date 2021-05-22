package com.example.helloworld;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.function.Consumer;

public class MatchesViewModel {
    private MatchesDataModel matchesDataModel;

    public MatchesViewModel() {
        matchesDataModel = new MatchesDataModel();
    }

    public void getMatches(Consumer<ArrayList<MatchesModel>> activityCallback) {
    }

    public void clear() {
        matchesDataModel.clear();
    }
}
