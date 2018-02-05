package com.zxz.robusttest;

import android.app.Application;

import com.meituan.robust.PatchExecutor;
import com.zxz.robusttest.robust.PatchManipulateImp;
import com.zxz.robusttest.robust.RobustCallBackSample;

/**
 * ${DESC}
 *
 * @author zxz
 * @time 2018/2/5 11:02
 */

public class MApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new PatchExecutor(getApplicationContext(), new PatchManipulateImp(), new RobustCallBackSample()).start();
    }
}
