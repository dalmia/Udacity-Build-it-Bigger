package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity implements DisplayJoke {

    Button mButton;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.tellJoke);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // resume the button and progressBar states when the activity closes
        mButton.setClickable(true);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Invoked by the DisplayJoke instance in the MainActivityFragment
     * in the free flavour
     */
    @Override
    public void showJokeActivity() {
        showJokeActivity(null);
    }

    /** Handling the button click for the MainActivityFragment
     * @param view - button that is clicked
     */
    public void showJokeActivity(View view) {

        // Showing the progressBar while the joke is being fetched
        mButton.setClickable(false);
        mProgressBar.setVisibility(View.VISIBLE);
        // Starting the AsyncTask
        new EndpointsAsyncTask().execute(this);
    }

}
