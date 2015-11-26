package com.alan.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CombinationAnimationActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mAnimatorSetOne;
    private TextView mTestText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combination_animation);

        mAnimatorSetOne = (Button) findViewById(R.id.animatorSetOne);
        mTestText = (TextView) findViewById(R.id.animatorTest);

        mAnimatorSetOne.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.animatorSetOne:
                ObjectAnimator moveAnimator = ObjectAnimator.ofFloat(mTestText , "translationX" , -500f , 0f);
                ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(mTestText , "rotation" , 0f , 360f);
                ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(mTestText , "alpha" , 1f , 0f , 1f);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(rotationAnimator).with(alphaAnimator).after(moveAnimator);
                animatorSet.setDuration(5000);
                animatorSet.start();

                animatorSet.addListener(new Animator.AnimatorListener() {
                    // 动画开始的时候调用
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }
                    // 动画结束时调用
                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }
                    // 取消动画时调用
                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }
                    // 动画重复执行时调用
                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });


                // 如果不想监听那么多的方法，可以使用AnimatorListenerAdapter
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    // 可以重写你自己希望监听的方法
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }

                });
                break;
       }
    }
}
