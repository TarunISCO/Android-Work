package com.example.android.exploreahmadabad;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class FoodFragment extends Fragment {

    public FoodFragment(){
        // Required public constructor.
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);
        final ArrayList<Node> restaurants = new ArrayList<Node>();

        restaurants.add(new Node(getString(R.string.food_barbeque_name),
                R.drawable.food_barbque,
                getString(R.string.food_barbeque_description),
                getString(R.string.food_barbeque_address)));

        restaurants.add(new Node(getString(R.string.food_rajwadu_name),
                R.drawable.food_rajwadu,
                getString(R.string.food_rajwadu_description),
                getString(R.string.food_rajwadu_address)));

        restaurants.add(new Node(getString(R.string.food_agashiye_name),
                R.drawable.food_agashiye,
                getString(R.string.food_agashiye_description),
                getString(R.string.food_agashiye_address)));

        restaurants.add(new Node(getString(R.string.food_vishala_name),
                R.drawable.food_vishala,
                getString(R.string.food_vishala_description),
                getString(R.string.food_vishala_address)));

        NodeAdapter adapter = new NodeAdapter(getActivity(), restaurants);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}
