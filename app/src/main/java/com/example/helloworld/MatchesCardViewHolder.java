package com.example.helloworld;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MatchesCardViewHolder extends RecyclerView.ViewHolder {

    ImageView matchesImage;
    TextView matchesName;
    Button likeButton;

    public MatchesCardViewHolder(@NonNull View itemView) {
        super(itemView);
        matchesImage = itemView.findViewById(R.id.matchesImageView);
        matchesName = itemView.findViewById(R.id.matchesNameTextView);
        likeButton = itemView.findViewById(R.id.likeButton);

        likeButton.setOnClickListener(view -> {
            String likeMsg = "You liked " + matchesName.getText().toString() + "!";
            Toast toast = Toast.makeText(view.getContext(), likeMsg, Toast.LENGTH_LONG);
            View toastView = toast.getView();
            toastView.setBackgroundResource(R.drawable.like_icon);
            toast.show();
        });
    }
}
