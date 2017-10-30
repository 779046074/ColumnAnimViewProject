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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gcssloop.graphics.R;
import com.lixiaodaoaaa.view.pieview.flower.FlowerLayout;

public class MainActivity extends AppCompatActivity {


    private FlowerLayout flowerLayout;
    private SimpleDraweeView draweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        initAllViews();
        initData();
    }

    private void initData() {
        Uri uri1 = Uri.parse("res://com.want.vendor/" + R.raw.vendor_home_shopping_icon_gif);
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(uri1)
                .setAutoPlayAnimations(true)
                .build();
        draweeView.setController(draweeController);

    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        }, 500);
    }

    private void initAllViews() {
        flowerLayout = (FlowerLayout) findViewById(R.id.myFlower);
        draweeView = (SimpleDraweeView) findViewById(R.id.shop_img);
    }

    public void addImageView(View view) {
        flowerLayout.addFlower();
    }

    public void skipNextActivity(View view) {
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        return;
    }

}
