package com.rumbleworks.sneaktwip;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.android.AndroidTwitterLogin;


public class MainActivity extends ActionBarActivity {


    final String MY_TWITTER_KEY = "Test";
    final String MY_TWITTER_SECRET = "Test";
    final String MY_TWITTER_CALLBACK = "Test";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidTwitterLogin atl = new AndroidTwitterLogin(this,
                MY_TWITTER_KEY,MY_TWITTER_SECRET,MY_TWITTER_CALLBACK) {

            protected void onSuccess(Twitter jtwitter, String[] tokens) {
                jtwitter.setStatus("I can now post to Twitter!");
                // Recommended: store tokens in your app for future use
                // with the constructor OAuthSignpostClient(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret)
            }
        };
        atl.run();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
