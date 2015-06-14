package com.architectpack.imageslider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GridViewImageAdapter extends BaseAdapter {

    private Activity _activity;
    private ImageLoader _imageLoader;
    private ArrayList<String> _filePaths = new ArrayList<>();
    private int imageWidth;

    public GridViewImageAdapter(Activity activity, ImageLoader imageLoader, ArrayList<String> filePaths,
                                int imageWidth) {
        this._activity = activity;
        this._filePaths = filePaths;
        this.imageWidth = imageWidth;
        this._imageLoader = imageLoader;
    }

    @Override
    public int getCount() {
        return this._filePaths.size();
    }

    @Override
    public Object getItem(int position) {
        return this._filePaths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(_activity);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(imageWidth, imageWidth));
        _imageLoader.load(_activity, imageView, _filePaths.get(position), imageWidth, imageWidth);
        imageView.setOnClickListener(new OnImageClickListener(position));

        return imageView;
    }


    class OnImageClickListener implements OnClickListener {

        private int _position;

        // constructor
        public OnImageClickListener(int position) {
            this._position = position;
        }

        @Override
        public void onClick(View v) {

            // on selecting grid view image
            // launch full screen activity
            Intent i = new Intent(_activity, FullScreenViewActivity.class);
            i.putExtra("position", _position);
            _activity.startActivity(i);
        }

    }
}