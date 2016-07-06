package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    Button mButton;
    InterstitialAd mInterstitialAd;
    DisplayJoke mDisplayJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mButton = (Button) root.findViewById(R.id.tellJoke);
        mButton.setOnClickListener(this);

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                setInterstitialAdRequest();
                showJokeActivity();
            }
        });
        setInterstitialAdRequest();
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = new Activity();
        if (getActivity() instanceof DisplayJoke)
            mDisplayJoke = (DisplayJoke) activity;
    }

    public void setInterstitialAdRequest() {
        AdRequest request = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(request);
    }


    @Override
    public void onClick(View v) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            showJokeActivity();
        }
    }

    public void showJokeActivity() {
        if(mDisplayJoke!=null)
            mDisplayJoke.showJokeActivity();
    }
}
