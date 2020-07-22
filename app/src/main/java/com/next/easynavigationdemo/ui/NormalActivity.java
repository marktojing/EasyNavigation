package com.next.easynavigationdemo.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.next.easynavigation.view.EasyNavigationBar;
import com.next.easynavigationdemo.R;
import com.next.easynavigationdemo.ui.normal.AFragment;
import com.next.easynavigationdemo.ui.normal.BFragment;
import com.next.easynavigationdemo.ui.normal.CFragment;
import com.next.easynavigationdemo.ui.normal.DFragment;

import java.util.ArrayList;
import java.util.List;

public class NormalActivity extends AppCompatActivity {

    private EasyNavigationBar navigationBar;

    private String[] tabText = {"首页1", "发现", "消息", "我的"};
    //未选中icon
    private Integer[] normalIcon = {R.mipmap.index, R.mipmap.find, R.mipmap.message, R.mipmap.me};
    //选中时icon
    private Integer[] selectIcon = {R.mipmap.index1, R.mipmap.find1, R.mipmap.message1, R.mipmap.me1};

    private List<android.support.v4.app.Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noadd);

        navigationBar = findViewById(R.id.navigationBar);

        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());

        navigationBar.titleItems(tabText)
                .setIconItems(selectIcon)
                .fragmentList(fragments)
                .normalTextColor(Color.GRAY)
                .selectTextColor(Color.BLUE)
                .fragmentManager(getSupportFragmentManager())
                .canScroll(true)
                .build();


    }

    public EasyNavigationBar getNavigationBar() {
        return navigationBar;
    }

}
