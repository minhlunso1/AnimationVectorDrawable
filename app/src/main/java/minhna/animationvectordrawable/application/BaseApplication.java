package minhna.animationvectordrawable.application;

import android.app.Application;
import android.graphics.Point;

/**
 * Created by Administrator on 31-Jul-17.
 */

public class BaseApplication extends Application {
    public static Point screenSize = new Point();

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
