package uz.exemple.less510_instagramui_java.model;

public class StoryModel {
   private int profile;
   private String fullname;

    public StoryModel(int profile, String fullname) {
        this.profile = profile;
        this.fullname = fullname;
    }

    public int getProfile() {
        return profile;
    }

    public String getFullname() {
        return fullname;
    }
}
