package uz.exemple.less510_instagramui_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import uz.exemple.less510_instagramui_java.R;

public class SlideAdapter extends RecyclerView.Adapter<SlideAdapter.ViewHolder> {
    private Context context;
    private int[] items;

    public SlideAdapter(Context context, int[] items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_3x_photo,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int photo = items[position];
        holder.image.setImageResource(photo);
        String item_position = (position+1) +"/"+items.length;
        holder.position.setText(item_position);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView position;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_photo3_2x);
            position = itemView.findViewById(R.id.tv_count_photos);
        }
    }
}
