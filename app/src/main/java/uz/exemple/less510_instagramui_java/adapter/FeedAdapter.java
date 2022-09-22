package uz.exemple.less510_instagramui_java.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;

import uz.exemple.less510_instagramui_java.R;
import uz.exemple.less510_instagramui_java.model.FeedModel;
import uz.exemple.less510_instagramui_java.model.PostModel;
import uz.exemple.less510_instagramui_java.model.StoryModel;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<FeedModel> items;

    int ITEM_STORY = 0;
    int ITEM_POST = 1;
    int ITEM_POST_2X = 2;
    int ITEM_POST_3X = 3;

    public FeedAdapter(Context context, ArrayList<FeedModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        FeedModel item = items.get(position);
        if (item.getStories().size()>0){
            return ITEM_STORY;
        }else if(item.getPost().getPhotos() !=null){
            return ITEM_POST_2X;
        }
        return ITEM_POST;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_STORY){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_story,parent,false);
            return new StoryViewHolder(view);
        }else if (viewType == ITEM_POST_2X){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_2x_photo,parent,false);
            return new Post2XViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_post,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FeedModel item = items.get(position);

        if (holder instanceof StoryViewHolder) {
            RecyclerView recyclerView = ((StoryViewHolder) holder).recyclerView;
            refreshAdapter(item.getStories(), recyclerView);
        }
        if (holder instanceof Post2XViewHolder) {
            ImageView iv_profile = ((Post2XViewHolder) holder).iv_profile;
            RecyclerView rv_photos = ((Post2XViewHolder) holder).rv_photos;
            TextView tv_fullname = ((Post2XViewHolder) holder).tv_fullname;
            LinearLayout ll_2x_photo = ((Post2XViewHolder) holder).ll_2x_photo;
            Context context = ((Post2XViewHolder) holder).itemView.getContext();

            iv_profile.setImageResource(item.getPost().getProfile());
            tv_fullname.setText(item.getPost().getFullname());

            SlideAdapter adapter = new SlideAdapter(context,item.getPost().getPhotos());
            rv_photos.setAdapter(adapter);

            Log.d("###","PHOTOS = "+ item.getPost().getPhotos().length);
            //setLinearHeight(context,ll_2x_photo,2);
        }

        if (holder instanceof PostViewHolder) {
            ImageView iv_profile = ((PostViewHolder) holder).iv_profile;
            ImageView iv_photo = ((PostViewHolder) holder).iv_photo;
            TextView tv_fullname = ((PostViewHolder) holder).tv_fullname;

            iv_profile.setImageResource(item.getPost().getProfile());
            iv_photo.setImageResource(item.getPost().getPhoto());
            tv_fullname.setText(item.getPost().getFullname());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    void refreshAdapter(ArrayList<StoryModel>stories,RecyclerView recyclerView ) {
        StoryAdapter adapter = new StoryAdapter(context, stories);
        recyclerView.setAdapter(adapter);
    }
    public class StoryViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerView);
            LinearLayoutManager manager = new  LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(manager);
        }
    }
    public class PostViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_profile;
        ImageView iv_photo;
        ImageView iv_like;
        ImageView iv_comment;
        ImageView iv_send;
        ImageView iv_save;
        TextView tv_fullname;
        TextView tv_caption;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
            iv_photo = itemView.findViewById(R.id.iv_photo);
            iv_like = itemView.findViewById(R.id.iv_like);
            iv_comment = itemView.findViewById(R.id.iv_comment);
            iv_send = itemView.findViewById(R.id.iv_send);
            iv_save = itemView.findViewById(R.id.iv_save);
            tv_caption = itemView.findViewById(R.id.tv_caption);
        }
    }
    public class Post2XViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_profile;
        LinearLayout ll_2x_photo;
        RecyclerView rv_photos;
        TextView tv_fullname;
        public Post2XViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
            ll_2x_photo = itemView.findViewById(R.id.ll_2x_photo);
            rv_photos = itemView.findViewById(R.id.rv_photos);

            LinearLayoutManager photos_manager = new  LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            rv_photos.setLayoutManager(photos_manager);
            SnapHelper snapHelper = new PagerSnapHelper();
            snapHelper.attachToRecyclerView(rv_photos);
        }
    }

    void setLinearHeight(Context context, LinearLayout layout, int parts ){
        // Get screen width programmatically
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int pxWidth = displayMetrics.widthPixels;
        float dpWidth = pxWidth / displayMetrics.density;
        int pxHeight = displayMetrics.heightPixels;
        float dpHeight = pxHeight / displayMetrics.density;

        // Set layout width programmatically
        ViewGroup.LayoutParams params = layout.getLayoutParams();
        params.height = (pxWidth-(5*(parts-1))) / parts;
        layout.setLayoutParams(params);
    }


}
