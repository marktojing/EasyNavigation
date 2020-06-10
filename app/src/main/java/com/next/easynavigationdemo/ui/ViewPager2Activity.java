package com.next.easynavigationdemo.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.next.easynavigation.adapter.ViewPager2Adapter;
import com.next.easynavigation.adapter.ViewPagerAdapter;
import com.next.easynavigation.view.EasyNavigationBar;
import com.next.easynavigationdemo.R;
import com.next.easynavigationdemo.ui.normal.AFragment;
import com.next.easynavigationdemo.ui.normal.BFragment;
import com.next.easynavigationdemo.ui.normal.CFragment;
import com.next.easynavigationdemo.ui.normal.DFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPager2Activity extends AppCompatActivity {

    private EasyNavigationBar navigationBar;

    private String[] tabText = {"首页", "发现", "消息", "我的"};
    //未选中icon
    private int[] normalIcon = {R.mipmap.index, R.mipmap.find, R.mipmap.message, R.mipmap.me};
    //选中时icon
    private int[] selectIcon = {R.mipmap.index1, R.mipmap.find1, R.mipmap.message1, R.mipmap.me1};

    private List<Fragment> fragments = new ArrayList<>();

    private ViewPager2 vp_setup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager2);

        navigationBar = findViewById(R.id.navigationBar);
        vp_setup = findViewById(R.id.vp_setup);

        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());

        vp_setup.setAdapter(new ViewPager2Adapter(ViewPager2Activity.this, fragments));

        vp_setup.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(ViewPager2Activity.this,"来自ViewPager2第"+position+"个",Toast.LENGTH_SHORT).show();
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        navigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .setupWithViewPager(vp_setup)
                .build();

    }


}
