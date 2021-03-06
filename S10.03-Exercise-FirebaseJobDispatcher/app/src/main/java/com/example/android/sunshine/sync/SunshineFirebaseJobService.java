package com.example.android.sunshine.sync;

/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// COMPLETED (2) Make sure you've imported the jobdispatcher.JobService, not job.JobService
import android.content.Context;
import android.os.AsyncTask;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;


// COMPLETED (3) Add a class called SunshineFirebaseJobService that extends jobdispatcher.
public class SunshineFirebaseJobService extends JobService {

//  COMPLETED (4) Declare an ASyncTask field called mFetchWeatherTask
    private AsyncTask mFetchWeatherTask;

//  COMPLETED (5) Override onStartJob and within it, spawn off a separate ASyncTask to sync weather data
    @Override
    public boolean onStartJob(final JobParameters job) {

        mFetchWeatherTask = new AsyncTask() {

            @Override
            protected Object doInBackground(Object[] params) {
                Context context = SunshineFirebaseJobService.this;
                SunshineSyncTask.syncWeather(context);
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                /*
                 * Once the AsyncTask is finished, the job is finished. To inform JobManager that
                 * you're done, you call jobFinished with the jobParamters that were passed to your
                 * job and a boolean representing whether the job needs to be rescheduled. This is
                 * usually if something didn't work and you want the job to try running again.
                 */

                // COMPLETED (6) Once the weather data is sync'd, call jobFinished with the
                // appropriate
                // arguments
                jobFinished(job, false);
            }
        };

        mFetchWeatherTask.execute();
        return true;
    }

//  COMPLETED (7) Override onStopJob, cancel the ASyncTask if it's not null and return true
    @Override
    public boolean onStopJob(JobParameters job) {
        if (mFetchWeatherTask != null) mFetchWeatherTask.cancel(true);
        return true;
    }
}