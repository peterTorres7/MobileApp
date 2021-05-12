package com.example.helloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment {

    MatchesData matchesData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matches, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));

        List<MatchesData> matchesDataList = new ArrayList<>();
        matchesData = new MatchesData(R.drawable.coco, getString(R.string.coco));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.cookie, getString(R.string.cookie));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.evie, getString(R.string.evie));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.honey, getString(R.string.honey));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.lola, getString(R.string.lola));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.luna, getString(R.string.luna));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.nala, getString(R.string.nala));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.sky, getString(R.string.sky));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.star, getString(R.string.star));
        matchesDataList.add(matchesData);

        MatchesCardRecyclerViewAdapter adapter = new MatchesCardRecyclerViewAdapter(matchesDataList, getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

}
