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
public class SDCardImageService implements ImageService {

    private Context _context;

    public SDCardImageService(Context context) {
        _context = context;
    }

    @Override
    public ArrayList<String> get() {
        return getFilePaths();
    }

    public ArrayList<String> getFilePaths() {

        ArrayList<String> filePaths = new ArrayList<String>();

        File directory = new File(String.valueOf(android.os.Environment.getExternalStorageDirectory())
                + File.separator + AppConstant.PHOTO_ALBUM);

        // check for directory
        if (directory.isDirectory()) {

            File[] listFiles1 = directory.listFiles();

            // getting list of file paths
            File[] listFiles = directory.listFiles(new ImageFileFilter());

            // Check for count
            if (listFiles != null) {
                for (File file : listFiles) {
                    filePaths.add(file.getAbsolutePath());
                }
            } else {
                // image directory is empty
                Toast.makeText(
                        _context,
                        AppConstant.PHOTO_ALBUM
                                + " is empty. Please load some images in it !",
                        Toast.LENGTH_LONG).show();
            }
        } else {
            AlertDialog.Builder alert = new AlertDialog.Builder(_context);
            alert.setTitle("Error!");
            alert.setMessage(android.os.Environment.getExternalStorageDirectory()
                    + " directory path is not valid! Please set the image directory name AppConstant.java class");
            alert.setPositiveButton("OK", null);
            alert.show();
        }

        return filePaths;
    }

    private class ImageFileFilter implements FileFilter {

        @Override
        public boolean accept(File file) {

            String filePath = file.getAbsolutePath();

            String ext = filePath.substring((filePath.lastIndexOf(".") + 1),
                    filePath.length());

            return AppConstant.FILE_EXTN
                    .contains(ext.toLowerCase(Locale.getDefault()));
        }
    }
}
