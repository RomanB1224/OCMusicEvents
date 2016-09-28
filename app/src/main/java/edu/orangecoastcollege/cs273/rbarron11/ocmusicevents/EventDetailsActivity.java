package edu.orangecoastcollege.cs273.rbarron11.ocmusicevents;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {

    public ImageView eventImageView;
    public TextView eventTitleTextView;
    public TextView eventDetailsTextView;

    private String title;
    private String details;
    private String imageFileName;

    private Context context = (Context) this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        eventImageView = (ImageView) findViewById(R.id.eventImageView);
        eventTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        eventDetailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);

        Intent IntentFromList = getIntent();

        title = IntentFromList.getStringExtra("Title");
        details = IntentFromList.getStringExtra("Details");

        eventTitleTextView.setText(title);
        eventDetailsTextView.setText(details);
        imageFileName = title.replace(" ", "") + ".jpeg";

        //load the image from the assets folder using the AssetsManager class
        AssetManager am = context.getAssets();
        //try to load image
        try
        {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);
        }
        catch(IOException ex)
        {
            Log.e("OC Music Events", "Connot load image" + imageFileName + ex);
        }




    }
}
