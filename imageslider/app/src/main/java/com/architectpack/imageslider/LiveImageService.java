package com.architectpack.imageslider;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by codebased on 10/06/15.
 */
public class LiveImageService implements ImageService {

    private Context _context;

    public LiveImageService(Context context) {
        _context = context;
    }

    @Override
    public ArrayList<String> get() {
        return getFilePaths();
    }

    public ArrayList<String> getFilePaths() {

        ArrayList<String> filePaths = new ArrayList<String>();
        filePaths.add("140");
        filePaths.add("141");
        filePaths.add("142");
        filePaths.add("143");
        filePaths.add("144");
        filePaths.add("145");


        return filePaths;
    }
}