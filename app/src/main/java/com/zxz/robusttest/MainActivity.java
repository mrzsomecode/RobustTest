package com.zxz.robusttest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.meituan.robust.patch.RobustModify;
import com.meituan.robust.patch.annotaion.Add;

public class MainActivity extends Activity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        findViewById(R.id.bugBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "bug代码", Toast.LENGTH_SHORT).show();
                RobustModify.modify();
                click((TextView) v);
            }
        });
    }

    @Add
    private void click(TextView v) {
        v.setText(addString() + "--");
        Toast.makeText(mContext, "修复代码", Toast.LENGTH_SHORT).show();
    }

    @Add
    private String addString() {
        return "无bug";
    }
}
