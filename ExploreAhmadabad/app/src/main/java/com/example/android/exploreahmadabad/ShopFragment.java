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


public class ShopFragment extends Fragment {

    public ShopFragment() {
        // Required Constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.item_list, container, false);

        final ArrayList<Node> shops = new ArrayList<Node>();

        shops.add(new Node(getString(R.string.shop_laldarwaja_name),
                R.drawable.shop_lal_darwaja,
                getString(R.string.shop_laldarwaja_description),
                getString(R.string.shop_laldarwaja_address)));

        shops.add(new Node(getString(R.string.shop_alphaone_name),
                R.drawable.shop_alpha_one_mall,
                getString(R.string.shop_alphaone_description),
                getString(R.string.shop_alphaone_address)));

        shops.add(new Node(getString(R.string.shop_sindhi_name),
                R.drawable.shop_sindhi_market,
                getString(R.string.shop_sindhi_description),
                getString(R.string.shop_sindhi_address)));

        shops.add(new Node(getString(R.string.shop_himalaya_name),
                R.drawable.shop_himalaya_mall,
                getString(R.string.shop_himalaya_description),
                getString(R.string.shop_himalaya_address)));

        NodeAdapter adapter = new NodeAdapter(getActivity(), shops);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}
