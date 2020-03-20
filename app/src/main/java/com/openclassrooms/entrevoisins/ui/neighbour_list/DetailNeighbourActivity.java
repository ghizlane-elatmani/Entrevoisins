package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailNeighbourActivity extends AppCompatActivity {

    @BindView(R.id.favoriteButton)
    FloatingActionButton favoriteButton;

    @BindView(R.id.nameTextView)
    TextView nameTextView;

    @BindView(R.id.headerNameTextView)
    TextView headerNameTextView;

    @BindView(R.id.avatarUrlImageView)
    ImageView avatarUrlImageView;

    @BindView(R.id.addressTextView)
    TextView addressTextView;

    @BindView(R.id.phoneNumberTextView)
    TextView phoneNumberTextView;

    @BindView(R.id.aboutMeTextView)
    TextView aboutMeTextView;

    Neighbour neighbour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        neighbour = intent.getParcelableExtra("neighbour");

        String name = neighbour != null ? neighbour.getName() : "";
        String avatarUrl = neighbour != null ? neighbour.getAvatarUrl() : "";
        String address = neighbour != null ? neighbour.getAddress() : "";
        String phoneNumber = neighbour != null ? neighbour.getPhoneNumber() : "";
        String aboutMe = neighbour != null ? neighbour.getAboutMe() : "";


        nameTextView.setText(name);
        headerNameTextView.setText(name);
        addressTextView.setText(address);
        phoneNumberTextView.setText(phoneNumber);
        aboutMeTextView.setText(aboutMe);

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("DetailNeighbour", "onClick");
            }
        });
    }
}
