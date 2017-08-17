/*
 * Copyright 2016 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 2016-10-02 00:22:33
 *
 */

package com.lixiaodaoaaa.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gcssloop.graphics.R;
import com.lixiaodaoaaa.uitls.ToastUtil;
import com.lixiaodaoaaa.view.pieview.flower.FlowerLayout;

public class MainActivity extends AppCompatActivity {


    private FlowerLayout flowerLayout;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower);
        initAllViews();
        initDatas();
    }

    private void initDatas() {
    }

    private void initAllViews() {
        flowerLayout = (FlowerLayout) findViewById(R.id.myFlower);
    }

    public void addImageView(View view) {
        flowerLayout.addFlower();
    }

    public void toastTest(View view) {
        ToastUtil.toast(MainActivity.this, "hello Word", true);
    }

    public void switchToSecondActivity(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        ToastUtil.hiddeToast();
    }
}
