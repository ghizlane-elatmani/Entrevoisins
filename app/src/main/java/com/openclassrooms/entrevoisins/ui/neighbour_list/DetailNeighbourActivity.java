package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;
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

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    Neighbour neighbour;
    boolean isFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);
        ButterKnife.bind(this);

        //Intent
        Intent intent = getIntent();
        neighbour = intent.getParcelableExtra("neighbour");

        nameTextView.setText(neighbour.getName());
        headerNameTextView.setText(neighbour.getName());
        addressTextView.setText(neighbour.getAddress());
        phoneNumberTextView.setText(neighbour.getPhoneNumber());
        aboutMeTextView.setText(neighbour.getAboutMe());

        String avatarUrl = neighbour.getAvatarUrl();
        Glide.with(this)
                .asBitmap()
                .load(avatarUrl)
                .into(avatarUrlImageView);

        //FavoriteButton
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isFavorite = !isFavorite;

                if(isFavorite == true) {
                    favoriteButton.setImageResource(R.drawable.ic_star_yellow_24dp);
                    //intent
                } else {
                    favoriteButton.setImageResource(R.drawable.ic_star_border_black_24dp);
                }
            }
        });

        //ToolBar
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
