package uz.exemple.less510_instagramui_java.model;

public class PostModel {
    private int profile;
    private String fullname;
    private int photo = 0;
    private int[] photos = null;
    private boolean isAdd = false;

    public PostModel(int profile, String fullname, int photo,boolean isAdd) {
        this.profile = profile;
        this.fullname = fullname;
        this.photo = photo;
        this.isAdd = isAdd;
    }
    public PostModel(int profile, String fullname, int[] photos,boolean isAdd) {
        this.profile = profile;
        this.fullname = fullname;
        this.photos = photos;
        this.isAdd = isAdd;
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

    public boolean isAdd() {
        return isAdd;
    }
}
