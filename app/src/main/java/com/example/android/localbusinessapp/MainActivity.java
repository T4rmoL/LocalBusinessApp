package com.example.android.localbusinessapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Drawable background = ContextCompat.getDrawable(this, R.drawable.background);
      background.setAlpha(150);
        setContentView(R.layout.activity_main);

        TextView fbTxt =  findViewById(R.id.fb_icon);
        fbTxt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent facebookIntent = getOpenFacebookIntent(MainActivity.this);
                startActivity(facebookIntent);
            }
        });
    }
    /**
     * This method is called when the Facebook icon is clicked
     */

    public static Intent getOpenFacebookIntent(Context context) {
        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/159337714127234")); //Trys to make intent with FB's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/HeaMajaPood")); //catches and opens a url to the desired page
        }
    }

    /**
     * This method is called when the Phone icon is clicked
     */

    public void dialNumber(View view) {
        String phoneNumber = getResources().getString(R.string.phone);
        Intent intentPhone = new Intent(Intent.ACTION_DIAL);
        intentPhone.setData(Uri.parse("tel:" + phoneNumber));
        if (intentPhone.resolveActivity(getPackageManager()) != null) {
            startActivity(intentPhone);
        }
    }

    /**
     * This method is called when the Mail icon is clicked
     */

    public void openMail(View view) {
        Intent intentMail = new Intent(Intent.ACTION_SENDTO);
        intentMail.setData(Uri.parse("mailto:info@heamajapood.ee"));
        if (intentMail.resolveActivity(getPackageManager()) != null) {
            startActivity(intentMail);
        }
    }

    public void openMap(View view) {
        Uri mapsUri = Uri.parse("geo:58.3737852,26.7199416,17z?q=58.3737852,26.7199416(Hea+Maja+Pood)");
        Intent intentMap = new Intent(Intent.ACTION_VIEW, mapsUri);
        intentMap.setPackage("com.google.android.apps.maps");
        if (intentMap.resolveActivity(getPackageManager()) != null) {
            startActivity(intentMap);
        }
    }
}
