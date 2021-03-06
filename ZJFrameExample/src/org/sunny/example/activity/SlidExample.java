package org.sunny.example.activity;

import org.sunny.aframe.ui.KJActivityManager;
import org.sunny.aframe.ui.activity.SlidTemplet;
import org.sunny.aframe.ui.fragment.BaseFragment;
import org.sunny.aframe.ui.widget.ResideMenuItem;
import org.sunny.example.R;
import org.sunny.example.fragment.BitmapDisplay;
import org.sunny.example.fragment.BitmapMistyExample;
import org.sunny.example.fragment.ChoiceImageExample;
import org.sunny.example.fragment.ScaleImageExample;

import android.app.ActionBar;
import android.view.View;

/**
 * 侧滑缩放效果的布局
 * 
 * @author kymjs(kymjs123@gmail.com)
 */
public class SlidExample extends SlidTemplet {
    private ResideMenuItem item1;
    private ResideMenuItem item2;
    private ResideMenuItem item3;
    private ResideMenuItem item4;
    private ResideMenuItem item5;

    public ActionBar actionBar;

    private BaseFragment fragContent;

    public SlidExample() {
        setHiddenActionBar(false);
    }

    @Override
    protected int setRootViewID() {
        actionBar = getActionBar();
        return R.layout.aty_slid_example;
    }

    @Override
    protected void initSlidMenu() {
        item1 = new ResideMenuItem(this, R.drawable.ic_launcher, "第一项");
        item2 = new ResideMenuItem(this, R.drawable.ic_launcher, "第二项");
        item3 = new ResideMenuItem(this, R.drawable.ic_launcher, "图片缩放");
        item4 = new ResideMenuItem(this, R.drawable.ic_launcher, "多图选择");
        item5 = new ResideMenuItem(this, R.drawable.ic_launcher, "立即退出");
        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        item4.setOnClickListener(this);
        item5.setOnClickListener(this);
        resideMenu.addMenuItem(item1);
        resideMenu.addMenuItem(item2);
        resideMenu.addMenuItem(item3);
        resideMenu.addMenuItem(item4);
        resideMenu.addMenuItem(item5);
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        actionBar.setTitle("侧滑效果演示");
        fragContent = new BitmapDisplay();
        changeFragment(fragContent);
    }

    /**
     * 必须调用super()，否则界面触摸将被屏蔽
     */
    @Override
    protected void changeFragment(BaseFragment targetFragment) {
        super.changeFragment(targetFragment);
        changeFragment(R.id.content, targetFragment);
    }

    @Override
    public void onSlidMenuClick(View v) {
        if (v == item1) {
            actionBar.setTitle("网络图片加载");
            changeFragment(new BitmapDisplay());
        } else if (v == item2) {
            actionBar.setTitle("图片模糊效果");
            changeFragment(new BitmapMistyExample());
        } else if (v == item3) {
            actionBar.setTitle("图片缩放效果");
            changeFragment(new ScaleImageExample());
        } else if (v == item4) {
            actionBar.setTitle("多图选择效果");
            changeFragment(new ChoiceImageExample());
        } else if (v == item5) {
            KJActivityManager.create().AppExit(SlidExample.this);
        }
        resideMenu.closeMenu();
    }
}
