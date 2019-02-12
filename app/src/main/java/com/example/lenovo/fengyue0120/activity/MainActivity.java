package com.example.lenovo.fengyue0120.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.example.lenovo.fengyue0120.R;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private int height;
    private DisplayMetrics displayMetrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img =findViewById(R.id.img);
        displayMetrics = getResources().getDisplayMetrics();
        height = displayMetrics.heightPixels;
        final ObjectAnimator rotation1 = ObjectAnimator.ofFloat(img, "scaleX", 2, 1);
        final ObjectAnimator rotation2 = ObjectAnimator.ofFloat(img, "alpha", 0, 1);
        final ObjectAnimator rotation3 = ObjectAnimator.ofFloat(img, "translationY", 0, height/2-img.getHeight()/2);
        final ObjectAnimator rotation= ObjectAnimator.ofFloat(img, "rotation", 0, 360);
        AnimatorSet set=new AnimatorSet();
        set.play(rotation).with(rotation1).with(rotation2).with(rotation3);
        set.setDuration(5000);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
}
