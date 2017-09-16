package com.olusayo.app.githulagos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by OLUSAYO on 13-Sep-17.
 */


public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //setting the views for the developer for a detail information
        ImageView profileImageView = (ImageView) findViewById(R.id.profileImageView);
        TextView userNameTextView = (TextView) findViewById(R.id.usernameTextView);
        ImageButton shareProfile = (ImageButton) findViewById(R.id.shareProfile);
        TextView developerUrl = (TextView) findViewById(R.id.developerUrl);

        //setting the intent to open the profile image and to make the profile url visible
        Intent intent = getIntent();
        final String userName = intent.getStringExtra(DevelopersAdapter.KEY_NAME);
        String image = intent.getStringExtra(DevelopersAdapter.KEY_IMAGE);
        final String profileUrl = intent.getStringExtra(DevelopersAdapter.KEY_URL);

        //loading images from the GITHUB API for each developer
        Picasso.with(this)
                .load(image)
                .into(profileImageView);

        userNameTextView.setText(userName);
        developerUrl.setText(profileUrl);

        //to open the profile URL on Clicking it
        developerUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = profileUrl;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        //to share the developers URL with any available application
        shareProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome developer " + userName +
                        ", " + profileUrl);
                Intent chooser = Intent.createChooser(shareIntent, "Share via");
                if (shareIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });


    }
}