package com.example.android.exploreahmadabad;

/**
 * Created by tarun on 24/6/17.
 */

public class Node {
    private String nodeTitle;
    private int nodeImageId;
    private String nodeDescription;
    private String nodeLocation;

    public Node(String title, int imageId, String description, String location)  {
        nodeTitle = title;
        nodeImageId = imageId;
        nodeDescription = description;
        nodeLocation = location;
    }

    public String getTitle() { return nodeTitle; }

    public int getImageId() { return nodeImageId; }

    public String getDescription() { return nodeDescription; }

    public String getLocation() { return nodeLocation; }
}
