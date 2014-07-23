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

import org.sunny.zjlibrary.R;

import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/**
 * 应用启动的欢迎界面模板
 * 
 * @author sunny
 */
public abstract class BaseSplash extends BaseActivity {

    protected ImageView mImageView;

    protected abstract void setRootBackground(ImageView view);

    public BaseSplash() {
        setAllowFullScreen(true);
        setHiddenActionBar(true);
        setScreenOrientation(ScreenOrientation.VERTICAL);
    }

    @Override
    public void setRootView() {
        mImageView = new ImageView(this);
        mImageView.setScaleType(ScaleType.FIT_XY);
        setContentView(mImageView);
        setRootBackground(mImageView);
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        // 监听动画过程
        animation.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                checkVersion();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                redirectTo();
                finish();
            }
        });
        mImageView.setAnimation(animation);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }

    /**
     * 跳转到...
     */
    protected void redirectTo() {
        if (firstsInstall()) {
        }
    }

    /**
     * 判断首次使用
     */
    protected boolean firstsInstall() {
        return true;
    }

    /**
     * 检查更新
     */
    protected void checkVersion() {}
}
