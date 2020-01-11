package com.example.cat_facts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress1);
        results = findViewById(R.id.text1);
        progressBar.setVisibility(View.GONE);
    }

    public void submit(View view) {
        progressBar.setVisibility(View.VISIBLE);
        new FetchCatFacts().execute();
    }

    /*The following code is to load data from internet.Parse the data and
    * display the results*/
    class FetchCatFacts extends AsyncTask<Void,Void,String>
    {
        public static final String LINK = "https://cat-fact.herokuapp.com/facts";

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(LINK);
                HttpsURLConnection connection =
                        (HttpsURLConnection) url.openConnection();
                InputStream is = connection.getInputStream();
                if(is!=null){
                    BufferedReader br =
                            new BufferedReader(new InputStreamReader(is));
                    String line;
                    String result="";
                    while((line = br.readLine())!=null){
                        result += line;
                    }
                    return result;
                }
                else
                {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);
            try {
                JSONObject root = new JSONObject(s);
                JSONArray all = root.getJSONArray("all");
                for(int i = 0; i<all.length();i++){
                    JSONObject item = all.getJSONObject(i);
                    String fact = item.getString("text");
                    results.append(fact+"\n\n");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
