package com.example.android.booklistingapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by tarun on 5/7/17.
 */

public class BookAdapter extends ArrayAdapter {

    public BookAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Book book = (Book) getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.booklist_item, parent, false);
        }

        TextView title = (TextView) view.findViewById(R.id.title);
        TextView author = (TextView) view.findViewById(R.id.author);
        title.setText(book.getTitle());
        author.setText(book.getAuthor());

        return view;
    }
}
