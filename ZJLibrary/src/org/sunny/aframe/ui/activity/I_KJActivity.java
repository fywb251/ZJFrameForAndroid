/*
 * Copyright (c) 2014-2015, sunny.
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

import android.view.View;

/**
 * KJFrameActivity接口协议，实现此接口可使用KJActivityManager堆栈
 * 
 * @author sunny
 * @version 1.0
 * @created 2014-3-1
 * @lastChange 2014-5-30
 */
public interface I_KJActivity {
    /** 初始化方法 */
    void initialize();

    void setRootView();

    void widgetClick(View v);
}
