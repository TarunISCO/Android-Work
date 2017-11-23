package com.example.android.booklistingapp;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tarun on 5/7/17.
 */

public class QueryUtils {

    private QueryUtils() {
    }

    public static String formatListOfAuthors(JSONArray authorsList) throws JSONException {

        String authorsListInString = null;

        if (authorsList.length() == 0) {
            return null;
        }

        for (int i = 0; i < authorsList.length(); i++){
            if (i == 0) {
                authorsListInString = authorsList.getString(0);
            }
            else {
                authorsListInString += ", " + authorsList.getString(i);
            }
        }

        return authorsListInString;
    }


    public static List<Book> extractBooks(String json) {

        List<Book> books = new ArrayList<>();

        try {
            JSONObject jsonResponse = new JSONObject(json);

            if (jsonResponse.getInt("totalItems") == 0) {
                return books;
            }
            JSONArray jsonArray = jsonResponse.getJSONArray("items");

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject bookObject = jsonArray.getJSONObject(i);

                JSONObject bookInfo = bookObject.getJSONObject("volumeInfo");

                String title = bookInfo.getString("title");
                Book book;
                if(bookInfo.has("authors")) {
                    JSONArray authorsArray = bookInfo.optJSONArray("authors");
                    String authors = formatListOfAuthors(authorsArray);
                    book = new Book(authors, title);
                }
                else {
                    book = new Book(null, title);
                }
                books.add(book);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return books;
    }

}
