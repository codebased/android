package com.architectpack.donut;

import android.app.Application;

/**
 * Created by codebased on 16/06/15.
 */
public class MainApplication extends Application {

   private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    public static Application getInstance(){
        return MainApplication.instance;
    }
}
