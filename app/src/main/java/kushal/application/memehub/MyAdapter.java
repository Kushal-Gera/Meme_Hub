package kushal.application.memehub;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {

    private Memes memes;
    private Context context;
    private List<MemesItem> memesItem;


    MyAdapter(Memes memes, Context context) {
        this.memes = memes;
        this.context = context;
        memesItem = memes.getData().getMemes();
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.each_list, parent, false);

        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, final int position) {

        holder.meme_text.setText(memesItem.get(position).getName().toString());
        Glide.with(context).load(memesItem.get(position).getUrl())
                .placeholder(R.drawable.placeholder)
                .centerCrop()
                .into(holder.meme_img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, BigMemeAct.class);
                i.putExtra("image_url", memesItem.get(position).getUrl());
                i.putExtra("title", memesItem.get(position).getName());
                context.startActivity(i);
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, memesItem.get(position).getUrl().toString());
                i.setType("text/plain");
                context.startActivity(Intent.createChooser(i, "share with:"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return memes.getData().getMemes().size();
    }


    class MyViewholder extends RecyclerView.ViewHolder {

        ImageView meme_img, share;
        TextView meme_text;

        MyViewholder(@NonNull final View itemView) {

            super(itemView);

            share = itemView.findViewById(R.id.share);
            meme_img = itemView.findViewById(R.id.meme_img);
            meme_text = itemView.findViewById(R.id.meme_text);

        }
    }
}
