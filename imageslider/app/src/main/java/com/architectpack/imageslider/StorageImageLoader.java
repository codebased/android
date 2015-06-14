package com.architectpack.imageslider;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by codebased on 14/06/15.
 */
public class StorageImageLoader implements ImageLoader {
    @Override
    public void load(Activity activity, ImageView imageView, String path, int width, int height) {


        // get screen dimensions
        Bitmap image = Utils.decodeFile(path, width,
                height);

        imageView.setImageBitmap(image);

    }


}
