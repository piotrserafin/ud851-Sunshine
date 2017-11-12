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
package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // COMPLETED (1) Create a field to store the weather display TextView
    private TextView mWeatherDisplayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        // COMPLETED (2) Use findViewById to get a reference to the weather display TextView
        mWeatherDisplayTextView = (TextView) findViewById(R.id.tv_weather_data);

        // COMPLETED (3) Create an array of Strings that contain fake weather data
        String[] mFakeWeatherData = {
                "Pn, Lis 12, Slonecznie, 15C / 6C",
                "Wt, Sty 12, Deszczowo, 16C / 7C",
                "Sr, Lut 12, Slonecznie, 17C / 8C",
                "Cw, Mar 12, Wietrznie, 18C / 9C",
                "Pi, Kwi 12, Mgliscie, 19C / 10C",
                "So, Maj 12, Slonecznie, 20C / 11C",
                "Nd, Cze 12, Zachmurzenie, 21C / 12C",
                "Pn, Lip 12, Slonecznie, 22C / 13C" };


        // COMPLETED (4) Append each String from the fake weather data array to the TextView
        for(String wData : mFakeWeatherData) {
            mWeatherDisplayTextView.append(wData + "\n\n\n");
        }

    }
}