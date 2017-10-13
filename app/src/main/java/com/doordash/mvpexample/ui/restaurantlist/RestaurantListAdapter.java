package com.doordash.mvpexample.ui.restaurantlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doordash.mvpexample.R;
import com.doordash.mvpexample.models.Restaurant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {

    private List<Restaurant> restaurantList;

    public RestaurantListAdapter() {
        restaurantList = new ArrayList<>();
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_restaurant, parent, false);
        return new RestaurantViewHolder(row);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {
        holder.bindData(restaurantList.get(position));
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    static class RestaurantViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.restaurant_logo_imageview)
        ImageView restaurantLogoImageView;
        @BindView(R.id.restaurant_name_textview)
        TextView restaurantNameTextView;
        @BindView(R.id.eta_textview)
        TextView etaTextView;
        @BindView(R.id.cuisine_name_textview)
        TextView cuisineNameTextView;

        RestaurantViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindData(@NonNull Restaurant restaurant) {
            Picasso.with(itemView.getContext())
                    .load(restaurant.getCoverImageUrl())
                    .into(restaurantLogoImageView);
            restaurantNameTextView.setText(restaurant.getName());
            cuisineNameTextView.setText(parseTagsToReadableString(restaurant.getTags()));
            etaTextView.setText(restaurant.getStatus());
        }

        private String parseTagsToReadableString(String[] tags) {
            if (tags.length == 1) {
                return tags[0];
            } else if (tags.length > 1) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < tags.length; i++) {
                    stringBuilder.append(tags[i]);
                    if (i < tags.length - 1) {
                        stringBuilder.append(", ");
                    }
                }
                return stringBuilder.toString();
            } else {
                return "";
            }
        }
    }
}
