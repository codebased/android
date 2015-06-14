package com.architectpack.imageslider;

import java.util.Arrays;
import java.util.List;

public class AppConstant {

    // Number of columns of Grid View
    public static final int NUM_OF_COLUMNS = 3;

    // Gridview image padding
    public static final int GRID_PADDING = 8; // in dp

    // SD card image directory
    public static final String PHOTO_ALBUM = "papu";
    public static final String BASE_URL = "http://192.168.43.243:3002";
//    public static final String BASE_URL = "http://192.168.56.1:3002";

    // supported file formats
    public static final List<String> FILE_EXTN = Arrays.asList("jpg", "jpeg",
            "png", "gif");
}