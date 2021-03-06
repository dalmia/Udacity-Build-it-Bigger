/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.aman.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.aman.example.com",
    ownerName = "backend.myapplication.aman.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that returns the joke from our
     *  Java Library to the Google Cloud Endpoint */

    @ApiMethod(name = "sendJoke")
    public MyJoke sendJoke() {
        MyJoke response = new MyJoke();
        return response;
    }

}
