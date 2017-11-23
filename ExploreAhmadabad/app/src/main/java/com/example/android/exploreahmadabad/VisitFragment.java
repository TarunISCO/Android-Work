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


public class VisitFragment extends Fragment {

    public  VisitFragment(){
        // Required empty basic constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.item_list, container, false);

        final ArrayList<Node> visitingPlaces = new ArrayList<Node>();
        visitingPlaces.add(new Node(getString(R.string.visit_riverfront_name),
                R.drawable.visit_sabrmati_riverfront,
                getString(R.string.visit_riverfront_description),
                getString(R.string.visit_riverfront_address)));

        visitingPlaces.add(new Node(getString(R.string.visit_akshardham_name),
                R.drawable.visit_akshardham_mandir,
                getString(R.string.visit_akshardham_description),
                getString(R.string.visit_akshardham_address)));

        visitingPlaces.add(new Node(getString(R.string.visit_ashram_name),
                R.drawable.visit_sabarmati_ashram,
                getString(R.string.visit_ashram_description),
                getString(R.string.visit_ashram_address)));

        visitingPlaces.add(new Node(getString(R.string.visit_kankaria_name),
                R.drawable.visit_kankaria_lake,
                getString(R.string.visit_kankaria_description),
                getString(R.string.visit_kankaria_address)));

        NodeAdapter adapter = new NodeAdapter(getActivity(), visitingPlaces);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}
