package org.sunny.example.activity;

import org.sunny.aframe.ui.BindView;
import org.sunny.aframe.ui.ViewInject;
import org.sunny.aframe.ui.activity.KJFragmentActivity;
import org.sunny.aframe.ui.fragment.BaseFragment;
import org.sunny.example.R;
import org.sunny.example.fragment.BitmapDisplay;
import org.sunny.example.fragment.BitmapMistyExample;
import org.sunny.example.fragment.ChoiceImageExample;
import org.sunny.example.fragment.ListBitmapExample;

import android.app.ActionBar;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;

/**
 * 底部Tab导航效果的布局，使用RadioButton和Fragment组合
 * 
 * @author kymjs(kymjs123@gmail.com)
 */
public class TabExample extends KJFragmentActivity {

    @BindView(id = R.id.bottombar_content1, click = true)
    public RadioButton mRbtn1;
    @BindView(id = R.id.bottombar_content2, click = true)
    private RadioButton mRbtn2;
    @BindView(id = R.id.bottombar_content3, click = true)
    private RadioButton mRbtn3;
    @BindView(id = R.id.bottombar_content4, click = true)
    private RadioButton mRbtn4;

    BaseFragment content1 = new ChoiceImageExample(); // 第一个界面
    BaseFragment content2 = new BitmapDisplay(); // 第二个界面
    BaseFragment content3 = new ListBitmapExample(); // 第三个界面
    BaseFragment content4 = new BitmapMistyExample(); // 第四个界面

    public ActionBar actionBar;

    public TabExample() {
        setHiddenActionBar(false);
    }

    @Override
    public void setRootView() {
        setContentView(R.layout.aty_tab_example);
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        actionBar = getActionBar();
    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()) {
        case R.id.bottombar_content1:
            startActivity(new Intent(this, SlidExample.class));
            ViewInject.toast("侧滑试试");
            break;
        case R.id.bottombar_content2:
            actionBar.setTitle("网络图片加载");
            changeFragment(content2);
            break;
        case R.id.bottombar_content3:
            actionBar.setTitle("listview网络图片加载");
            changeFragment(content3);
            break;
        case R.id.bottombar_content4:
            actionBar.setTitle("图片模糊效果");
            changeFragment(content4);
            break;
        }
    }

    @Override
    protected void changeFragment(BaseFragment targetFragment) {
        changeFragment(R.id.content, targetFragment);
    }
}
