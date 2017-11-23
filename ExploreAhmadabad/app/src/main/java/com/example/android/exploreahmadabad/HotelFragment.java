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


public class HotelFragment extends Fragment {

    public HotelFragment() {
        // Required constructor
    }
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.item_list, container, false);

            final ArrayList<Node> hotels = new ArrayList<Node>();

            hotels.add(new Node(getString(R.string.hotel_hyatt_name),
                    R.drawable.hotel_hyatt_regency,
                    getString(R.string.hotel_hyatt_description),
                    getString(R.string.hotel_hyatt_address)));

            hotels.add(new Node(getString(R.string.hotel_courtyard_name),
                    R.drawable.hotel_courtyard,
                    getString(R.string.hotel_courtyard_description),
                    getString(R.string.hotel_hyatt_address)));

            hotels.add(new Node(getString(R.string.hotel_narayani_name),
                    R.drawable.hotel_narayani_height,
                    getString(R.string.hotel_narayani_description),
                    getString(R.string.hotel_narayani_address)));

            hotels.add(new Node(getString(R.string.hotel_ummed_name),
                    R.drawable.hotel_ummed,
                    getString(R.string.hotel_ummed_description),
                    getString(R.string.hotel_ummed_address)));

            NodeAdapter adapter = new NodeAdapter(getActivity(), hotels);

            ListView listView = (ListView) rootView.findViewById(R.id.list);
            listView.setAdapter(adapter);

            return rootView;
    }
}
