package uz.exemple.less510_instagramui_java.model;

public class PostModel {
    private int profile;
    private String fullname;
    private int photo = 0;
    private int[] photos = null;

    public PostModel(int profile, String fullname, int photo) {
        this.profile = profile;
        this.fullname = fullname;
        this.photo = photo;
    }
    public PostModel(int profile, String fullname, int[] photos) {
        this.profile = profile;
        this.fullname = fullname;
        this.photos = photos;
    }

    public int getProfile() {
        return profile;
    }

    public String getFullname() {
        return fullname;
    }

    public int getPhoto() {
        return photo;
    }

    public int[] getPhotos() {
        return photos;
    }
}
