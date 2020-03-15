package com.example.wallpaperapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wallpaperapp.R;
import com.example.wallpaperapp.models.Collection;
import com.example.wallpaperapp.utils.GlideApp;
import com.example.wallpaperapp.utils.SquareImage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionsAdapter extends BaseAdapter {

    private Context context;
    private List<Collection> collections;

    public CollectionsAdapter(Context context, List<Collection> collections) {
        this.context = context;
        this.collections = collections;
    }

    @Override
    public int getCount() {
        return collections.size();
    }

    @Override
    public Object getItem(int position) {
        return collections.get(position);
    }

    @Override
    public long getItemId(int position) {
        return collections.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        final ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_collection, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        ButterKnife.bind(this, view);
        Collection collection = collections.get(position);

        if (collection.getTitle() != null) {
            viewHolder.title.setText(collection.getTitle());
        }

        viewHolder.totalPhotos.setText(String.valueOf(collection.getTotalPhotos() ) + " photos");

        GlideApp
                .with(context)
                .load(collection.getCoverPhoto().getUrl().getRegular())
                .into(viewHolder.collectionPhoto);

        return view;
    }

    static class ViewHolder {

        @BindView(R.id.item_collection_title)
        TextView title;
        @BindView(R.id.item_collection_total_photos)
        TextView totalPhotos;
        @BindView(R.id.item_collection_image)
        SquareImage collectionPhoto;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
