package com.rumbleworks.sneaktwip.app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.apache.commons.logging.Log;

import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.android.AndroidTwitterLogin;


public class MainActivity extends ActionBarActivity {

    final String MY_TWITTER_KEY = "test";
    final String MY_TWITTER_SECRET = "test";
    final String MY_TWITTER_CALLBACK = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int a = 7;


//        AndroidTwitterLogin atl = new AndroidTwitterLogin(this,
//                MY_TWITTER_KEY,MY_TWITTER_SECRET,MY_TWITTER_CALLBACK) {
//
//            protected void onSuccess(Twitter jtwitter, String[] tokens) {
//                jtwitter.setStatus("I can now post to Twitter!");
//                // Recommended: store tokens in your app for future use
//                // with the constructor OAuthSignpostClient(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret)
//            }
//        };
//        atl.run();

        OAuthSignpostClient authClient = new OAuthSignpostClient('apiKey','apiSecret','callbackUrl');

        java.net.URI jUrl = authClient.authorizeUrl();
        Uri.Builder uriBuilder = new Uri.Builder();
        uriBuilder.encodedPath(jUrl.toString());

        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(jUrl.toString()));
        startActivity(myIntent);


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
