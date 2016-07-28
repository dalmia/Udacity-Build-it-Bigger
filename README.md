# Gradle for Android and Java Final Project

Build it Bigger contains multiple flavors that uses multiple libraries and Google Could Endpoints. The app consists
of four modules. A Java library that provides jokes, a Google Could Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

![Project Overview](https://lh3.googleusercontent.com/cJQtO_A08shKWZ1NEJxpvdYcfXxoHH87HYldIx_gOoGcoqnnZDTP3ycVqAnZSUMYzHygxhb-nEE_Yv_QmZY=s0#w=1920&h=1080)

##Things I learned

* Adding free and paid flavors to an app, and setting up my own build to share code between them
* Factoring reusable functionality into a Java library
* Factoring reusable Android functionality into an Android library
* Configuring a multi project build to compile your libraries and app
* Using the Gradle App Engine plugin to deploy a backend
* Configuring an integration test suite that runs against the local App Engine development server

## Getting Started

* Clone the project typing the following command in the git-bash/terminal
    ```
    git clone https://github.com/dalmia/Udacity-Build-it-Bigger.git
    ```

* Run the project using the `/gradlew` command from the terminal in Android Studio or click on the `Import a new Project` option from the File menu.

* You can [Fork](https://help.github.com/articles/fork-a-repo/) the project, issue any bugs that you may find and create a [Pull Request](https://help.github.com/articles/creating-a-pull-request/) for the changes to be merged.

## Libraries

* [Android Support Annotations](http://tools.android.com/tech-docs/support-annotations)
* [Expresso](https://google.github.io/android-testing-support-library/docs/espresso/)
* [Google Play Services](https://developers.google.com/android/guides/setup)

## Android Developer Nanodegree
[![udacity][1]][2]

[1]: ../master/screens/nanodegree.png
[2]: https://www.udacity.com/course/android-developer-nanodegree--nd801

## License

    Copyright 2016 Aman Dalmia

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
