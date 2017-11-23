package com.example.android.exploreahmadabad;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tarun on 24/6/17.
 */

public class NodeAdapter extends ArrayAdapter {

    public NodeAdapter(Activity context, ArrayList<Node> nodes) {
        super(context, 0, nodes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_node, parent, false);
        }

        Node currentNode = (Node) getItem(position);

        TextView titleView = (TextView) listItemView.findViewById(R.id.node_title);
        titleView.setText(currentNode.getTitle());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.node_imageholder);
        imageView.setImageResource(currentNode.getImageId());

        TextView descriptionView = (TextView) listItemView.findViewById(R.id.node_description);
        descriptionView.setText(currentNode.getDescription());

        TextView locationView = (TextView) listItemView.findViewById(R.id.node_location);
        locationView.setText(currentNode.getLocation());

        return listItemView;

    }
}
