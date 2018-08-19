package com.apitechnosoft.ipad.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apitechnosoft.ipad.R;
import com.apitechnosoft.ipad.model.Audioist;
import com.apitechnosoft.ipad.model.Data;
import com.apitechnosoft.ipad.model.Folderdata;
import com.apitechnosoft.ipad.model.MediaData;
import com.apitechnosoft.ipad.model.Photolist;
import com.apitechnosoft.ipad.model.Videolist;

import java.util.ArrayList;

public class RecentFileAdapter extends RecyclerView.Adapter<RecentFileAdapter.MyViewHolder> {

    private ArrayList<MediaData> mediaList;
    Context mContext;
    int type;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView recenttext;
        ImageView recentImg;

        public MyViewHolder(View view) {
            super(view);
            recenttext = (TextView) view.findViewById(R.id.recenttext);
            recentImg = view.findViewById(R.id.recentImg);
        }
    }


    public RecentFileAdapter(Context mContext, ArrayList<MediaData> List, int type) {
        this.mediaList = List;
        this.mContext = mContext;
        this.type = type;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recent_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.recenttext.setText(mediaList.get(position).getFileName());

        if (mediaList.get(position).getFullFilePath() != null && !mediaList.get(position).getFullFilePath().equals("")) {
            holder.recentImg.setImageResource(R.drawable.folder);
        } else {
            if (type == 1) {
                if (mediaList.get(position).getType() != null && mediaList.get(position).getType().contains("image")) {
                   // holder.recentImg.setImageResource(R.drawable.image_placeholder);
                }
            } else if (type == 2) {
                if (mediaList.get(position).getType() != null && mediaList.get(position).getType().contains("video")) {
                    holder.recentImg.setImageResource(R.drawable.video);
                }
            } else if (type == 3) {
                if (mediaList.get(position).getType() != null && mediaList.get(position).getType().contains("audio")) {
                    holder.recentImg.setImageResource(R.drawable.audio_icon);
                }
            } else if (type == 4) {
                if (mediaList.get(position).getType() != null && mediaList.get(position).getType().contains("doc")) {
                    holder.recentImg.setImageResource(R.drawable.doc);
                }
            }
        }
        /*if (mediaList.get(position).getType().contains("image")) {
            holder.recentImg.setImageResource(R.drawable.image_placeholder);
        } else if (mediaList.get(position).getType().contains("video")) {
            holder.recentImg.setImageResource(R.drawable.video);
        } else if (mediaList.get(position).getType().contains("audio")) {
            holder.recentImg.setImageResource(R.drawable.audio_icon);
        } else if (mediaList.get(position).getType().contains("doc")) {
            holder.recentImg.setImageResource(R.drawable.doc);
        }*/
    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }


}

