/*
 * Copyright (c) 2014, sunny.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sunny.aframe.ui.activity;

import org.sunny.aframe.ui.fragment.BaseFragment;
import org.sunny.aframe.ui.widget.ResideMenu;
import org.sunny.aframe.ui.widget.ResideMenuItem.OnMenuClickListener;

import android.view.MotionEvent;
import android.view.View;

/**
 * 具有侧滑缩放效果侧滑界面模板
 * 
 * @warn 在changeFragment()中必须调用super.changeFragment(targetFragment);
 * @author sunny
 */
public abstract class SlidTemplet extends KJFragmentActivity implements
        OnMenuClickListener {
    protected ResideMenu resideMenu;

    /** 设置Activity布局 */
    protected abstract int setRootViewID();

    /** 初始化侧滑菜单界面控件 */
    protected abstract void initSlidMenu();

    @Override
    public void setRootView() {
        View root = View.inflate(this, setRootViewID(), null);
        setContentView(root);
        resideMenu = new ResideMenu(this);
        resideMenu.attachToActivity(this);
        resideMenu.addIgnoredView(root);
    }

    @Override
    protected void initWidget() {
        initSlidMenu();
        super.initWidget();
    }

    /**
     * 改变Menu状态
     */
    public void changeSlidMenu() {
        if (resideMenu.isOpened()) {
            resideMenu.closeMenu();
        } else {
            resideMenu.openMenu();
        }
    }

    @Override
    protected void changeFragment(BaseFragment targetFragment) {
        // 清空不拦截触摸事件的控件（界面已经被替换）
        resideMenu.clearIgnoredViewList();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.onInterceptTouchEvent(ev)
                || super.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        onSlidMenuClick(v);
    }
}
