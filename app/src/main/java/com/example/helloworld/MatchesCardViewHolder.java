package com.example.helloworld;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MatchesCardViewHolder extends RecyclerView.ViewHolder {

    ImageView matchesImage;
    TextView matchesName;

    public MatchesCardViewHolder(@NonNull View itemView) {
        super(itemView);
        matchesImage = itemView.findViewById(R.id.matchesImageView);
        matchesName = itemView.findViewById(R.id.matchesNameTextView);
    }
}
