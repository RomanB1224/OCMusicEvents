package edu.orangecoastcollege.cs273.rbarron11.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;




public class EventListActivity extends ListActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //set the adapter (which bonds the ListView with the data in the MusicEvent
        //since the data is an array , we use an ArrayAdapter:

        setListAdapter (new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,MusicEvent.titles));
       // setContentView(R.layout.activity_event_list);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int pos, long id)
    {
        //get the position, get the title , get the details
        //make a new intent
        // put the strings into intent
        // start activity
        String title = MusicEvent.titles[pos];
        String details = MusicEvent.details[pos];

        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("Title", title);
        detailsIntent.putExtra("Details", details);
        startActivity(detailsIntent);
    }

}
