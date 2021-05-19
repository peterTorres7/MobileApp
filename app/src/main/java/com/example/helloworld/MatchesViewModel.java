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

    public void getMatches(Consumer<ArrayList<MatchesModel>> resultCallback) {
        matchesDataModel.getMatches(
                (QuerySnapshot querySnapShot) -> {
                    if (querySnapShot != null) {
                        ArrayList<MatchesModel> matches = new ArrayList<>();
                        for (DocumentSnapshot matchSnapshot : querySnapShot.getDocuments()) {
                            MatchesModel matchesModel = matchSnapshot.toObject(MatchesModel.class);
                            assert matchesModel != null;
                            matchesModel.uid = matchSnapshot.getId();
                            matches.add(matchesModel);
                        }
                        resultCallback.accept(matches);
                    }
                },
                (databaseError -> System.out.println("Looks like something went wrong!" + databaseError))
        );
    }

    public void clear() {
        matchesDataModel.clear();
    }
}
