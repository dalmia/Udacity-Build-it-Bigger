package com.example.aman.myapplication.backend;

import com.example.JokeFetcher;

/** The object model for the data we are sending through endpoints */
public class MyJoke {

    public String getData() {
        return new JokeFetcher().getJokes();
    }
}