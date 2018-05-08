package com.noman.dagger2sample;

import android.app.Application;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.google.gson.Gson;
import com.noman.dagger2sample.adapters.HeroListAdapter;
import com.noman.dagger2sample.model.Data;
import com.noman.dagger2sample.model.Hero;
import com.noman.dagger2sample.network.RertofitApis;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    //injecting retrofit
    @Inject
    Retrofit retrofit;

    // injecting gson
    @Inject
    Gson gson;

    // injecting shared prefernces
    @Inject
    SharedPreferences sharedPreferences;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inject sigalton component
        ((MyApplication) getApplication()).getNetComponent().inject(this);

        listView = (ListView) findViewById(R.id.listViewHeroes);

        // Listview lisntener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Remove list data from shared prefernces on item click
                sharedPreferences.edit().putString("data", null).apply();
            }
        });

        // Get data from shared prefernces
        String dataStr = sharedPreferences.getString("data", null);

        // Check if there is data in shared prefernces
        if (dataStr == null) {
            getHeroesList();
        } else {
            Data data = gson.fromJson(dataStr, Data.class);
            showListUI(data.getHeroArrayList());
        }

    }

    private void getHeroesList() {

        RertofitApis retrofitApi = retrofit.create(RertofitApis.class);

        Call<List<Hero>> call = retrofitApi.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                ArrayList<Hero> heroList = (ArrayList<Hero>) response.body();

                showListUI(heroList);

                Data data = new Data(heroList);
                // Adding service response to shared prefernces
                sharedPreferences.edit().putString("data", gson.toJson(data)).apply();

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "API Failure", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showListUI(ArrayList<Hero> heroList) {

        //displaying the string array into listview
        listView.setAdapter(new HeroListAdapter(getApplicationContext(), heroList));
    }


}
