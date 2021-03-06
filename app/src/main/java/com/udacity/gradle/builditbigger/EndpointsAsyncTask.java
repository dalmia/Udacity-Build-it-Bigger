package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.aman.myapplication.backend.myApi.MyApi;
import com.example.displayjoke.DisplayJokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Async Task to connect to the Google Cloud Backend and fetch the Joke from our Java library
 */
public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {  // Only do this once

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        // receiving the context passed to the task
        context = params[0];

        try {
            return myApiService.sendJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        // Opening the DisplayJokeActivity once the background task is finished
        Intent intent = new Intent(context, DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.JOKE_INTENT_KEY, result);
        context.startActivity(intent);
    }
}