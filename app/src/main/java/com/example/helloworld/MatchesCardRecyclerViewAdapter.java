package com.example.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MatchesCardRecyclerViewAdapter extends RecyclerView.Adapter<MatchesCardViewHolder> {
    private List<MatchesData> matchesDataList;
    private Context matchesContext;

    MatchesCardRecyclerViewAdapter(List<MatchesData> matchesDataList, Context matchesContext) {
        this.matchesDataList = matchesDataList;
        this.matchesContext = matchesContext;
    }

    @NonNull
    @Override
    public MatchesCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View matchesView = LayoutInflater.from(parent.getContext()).inflate(R.layout.matches_card, parent, false);
        return new MatchesCardViewHolder(matchesView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchesCardViewHolder holder, int position) {
        MatchesData matchesData = matchesDataList.get(position);
        holder.matchesImage.setImageResource(matchesData.getMatchesImage());
        holder.matchesName.setText(matchesData.getMatchesName());
    }

    @Override
    public int getItemCount() {
        return matchesDataList.size();
    }

}
