package com.architectpack.imageslider;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by codebased on 14/06/15.
 */
public class GlideImageLoader implements ImageLoader {

    @Override
    public void load(Activity activity, ImageView imageView, String url, int width, int height) {
        if (width == height && height == 0) {
            Glide.with(activity).load(AppConstant.BASE_URL + "/documents/view/" + url).into(imageView);
        } else {
            Glide.with(activity).load(AppConstant.BASE_URL + "/documents/view/" + url).override(width, height).into(imageView);
        }
    }
}
