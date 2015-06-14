package com.architectpack.imageslider;

import android.app.Activity;
import android.widget.ImageView;

/**
 * Created by codebased on 14/06/15.
 */
public interface ImageLoader {
     void load(Activity activity, ImageView imageView, String url, int width, int height);
}
