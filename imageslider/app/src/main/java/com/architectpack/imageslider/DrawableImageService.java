package com.architectpack.imageslider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codebased on 10/06/15.
 */
public class DrawableImageService implements ImageService {
    @Override
    public ArrayList<String> get() {

        ArrayList<String> data;

        data = new ArrayList<>();

        // need to get drawable absolute file paths.

        data.add("drawable://" + R.drawable.a);
        data.add("drawable://" + R.drawable.b);
        data.add("drawable://" + R.drawable.c);

        return data;
    }
}
