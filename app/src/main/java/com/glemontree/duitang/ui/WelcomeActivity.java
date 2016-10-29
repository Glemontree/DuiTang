package com.glemontree.duitang.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.glemontree.duitang.R;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/10/28.
 */

public class WelcomeActivity extends Activity {
    @InjectView(R.id.welcome_image)
    ImageView welomeImg;

    @InjectView(R.id.count_down)
    TextView countDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        Picasso.with(this).load(R.drawable.welcome_img).into(welomeImg);
        final Typeface font = Typeface.createFromAsset(getAssets(), "splash.ttf");
        countDown.setTypeface(font);

        CountDownTimer timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDown.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Intent i = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        };
        timer.start();
    }
}
