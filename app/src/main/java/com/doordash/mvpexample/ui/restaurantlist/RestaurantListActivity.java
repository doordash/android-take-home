package com.doordash.mvpexample.ui.restaurantlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.doordash.mvpexample.R;
import com.doordash.mvpexample.application.MvpApplication;
import com.doordash.mvpexample.models.Restaurant;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantListActivity
        extends AppCompatActivity implements RestaurantListContract.View {

    @Inject
    RestaurantListContract.Presenter presenter;

    @BindView(R.id.restaurant_recyclerview)
    RecyclerView recyclerView;

    private RestaurantListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        MvpApplication.getAppComponent().inject(this);
        ButterKnife.bind(this);
        setupRecyclerView();
        presenter.setView(this);
        presenter.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        presenter.onPause();
        super.onPause();
    }

    private void setupRecyclerView() {
        adapter = new RestaurantListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void showRestaurantList(@NonNull List<Restaurant> restaurantList) {
        adapter.setRestaurantList(restaurantList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(@NonNull String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
