package com.zxz.robusttest.robust;

import android.util.Log;

import com.meituan.robust.Patch;
import com.meituan.robust.RobustCallBack;

import java.util.List;

/**
 * ${DESC}
 *
 * @author zxz
 * @time 2018/2/2 14:36
 */

public class RobustCallBackSample implements RobustCallBack {
    @Override
    public void onPatchListFetched(boolean result, boolean isNet, List<Patch> patches) {
        Log.d("RobustCallBack", "onPatchListFetched result: " + result);
        Log.d("RobustCallBack", "onPatchListFetched isNet: " + isNet);
        for (Patch patch : patches) {
            Log.d("RobustCallBack", "onPatchListFetched patch: " + patch.getName());
        }
    }

    @Override
    public void onPatchFetched(boolean result, boolean isNet, Patch patch) {
        Log.d("RobustCallBack", "onPatchFetched result: " + result);
        Log.d("RobustCallBack", "onPatchFetched isNet: " + isNet);
        Log.d("RobustCallBack", "onPatchFetched patch: " + patch.getName());
    }

    @Override
    public void onPatchApplied(boolean result, Patch patch) {
        Log.d("RobustCallBack", "onPatchApplied result: " + result);
        Log.d("RobustCallBack", "onPatchApplied patch: " + patch.getName());
        patch.delete(patch.getLocalPath());

    }

    @Override
    public void logNotify(String log, String where) {
        Log.d("RobustCallBack", "logNotify log: " + log);
        Log.d("RobustCallBack", "logNotify where: " + where);
    }

    @Override
    public void exceptionNotify(Throwable throwable, String where) {
        Log.e("RobustCallBack", "exceptionNotify where: " + where, throwable);
    }
}
