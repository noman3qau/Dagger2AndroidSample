package com.noman.dagger2sample;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.noman.dagger2sample.adapters.HeroListAdapter;
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

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getNetComponent().inject(this);

        listView = (ListView) findViewById(R.id.listViewHeroes);

        getHeroesList();

    }

    private void getHeroesList() {

        RertofitApis retrofitApi = retrofit.create(RertofitApis.class);

        Call<List<Hero>> call = retrofitApi.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                ArrayList<Hero> heroList = (ArrayList<Hero>) response.body();

                //displaying the string array into listview
                listView.setAdapter(new HeroListAdapter(getApplicationContext(), heroList));

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });

    }


}
