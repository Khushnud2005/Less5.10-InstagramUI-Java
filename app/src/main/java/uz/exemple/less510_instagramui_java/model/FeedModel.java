package uz.exemple.less510_instagramui_java.model;

import java.util.ArrayList;

public class FeedModel {
   private PostModel post= null;
    private ArrayList<StoryModel> stories = new  ArrayList<StoryModel>();

    public FeedModel(PostModel post ) {
        this.post = post;
    }

    public FeedModel(ArrayList<StoryModel> stories ) {
        this.stories = stories;
    }

    public PostModel getPost() {
        return post;
    }

    public ArrayList<StoryModel> getStories() {
        return stories;
    }
}
