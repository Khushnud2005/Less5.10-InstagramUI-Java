package uz.exemple.less510_instagramui_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import uz.exemple.less510_instagramui_java.adapter.FeedAdapter;
import uz.exemple.less510_instagramui_java.model.FeedModel;
import uz.exemple.less510_instagramui_java.model.PostModel;
import uz.exemple.less510_instagramui_java.model.StoryModel;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        refreshAdapter(getAllFeeds());
    }

    void refreshAdapter(ArrayList<FeedModel> feeds) {
        FeedAdapter adapter = new FeedAdapter(this, feeds);
        recyclerView.setAdapter(adapter);
    }

    ArrayList<FeedModel> getAllFeeds() {

        ArrayList<StoryModel> stories = new ArrayList<StoryModel>();
        stories.add(new StoryModel(R.drawable.profile1, "Anvar"));
        stories.add(new StoryModel(R.drawable.profile2, "Qambar"));
        stories.add(new StoryModel(R.drawable.profile3, "Sarvar"));
        stories.add(new StoryModel(R.drawable.profile4, "Yamach"));
        stories.add(new StoryModel(R.drawable.profile1, "Anvar"));
        stories.add(new StoryModel(R.drawable.profile2, "Qambar"));
        stories.add(new StoryModel(R.drawable.profile3, "Sarvar"));
        stories.add(new StoryModel(R.drawable.profile4, "Yamach"));

        ArrayList<FeedModel> feeds  = new  ArrayList<FeedModel>();
        feeds.add(new FeedModel(stories));
        feeds.add(new FeedModel(new PostModel(R.drawable.profile1, "Anvar", getTwoPhotos())));
        feeds.add(new FeedModel(new PostModel(R.drawable.profile3, "Sarvar", getThreePhotos())));
        feeds.add(new FeedModel(new PostModel(R.drawable.profile1, "Anvar", R.drawable.photo1)));
        feeds.add(new FeedModel(new PostModel(R.drawable.profile2, "Qambar", R.drawable.photo2)));
        feeds.add(new FeedModel(new PostModel(R.drawable.profile3, "Sarvar", R.drawable.photo3)));
        feeds.add(new FeedModel(new PostModel(R.drawable.profile4, "Yamach", R.drawable.photo4)));

        return feeds;
    }
    int[] getTwoPhotos(){
        int[] photos = new int[2];
        photos[0] = R.drawable.photo5;
        photos[1] = R.drawable.photo6;
        return photos;
    }
    int[] getThreePhotos(){
        int[] photos = new int[3];
        photos[0] = R.drawable.photo9;
        photos[1] = R.drawable.photo8;
        photos[2] = R.drawable.photo7;
        return photos;
    }
}