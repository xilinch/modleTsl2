package cn.leancloud.llls;

import android.app.Application;
import android.os.Build;

import com.bumptech.glide.Glide;

/**
 * describe 该类主要完成以下功能
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (Build.VERSION.SDK_INT >= 19) {
            Glide.get(this).clearMemory();
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (Build.VERSION.SDK_INT >= 19) {
            Glide.get(this).trimMemory(level);
        }
    }
}
