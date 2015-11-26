package com.alan.propertyanimation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ObjectAnimatorActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button mAlpha;
    private Button mRotation;
    private Button mRotationX;
    private Button mRotationY;
    private Button mScale;
    private Button mScaleX;
    private Button mScaleY;
    private Button mTranslationX;
    private Button mTranslationY;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);

        mAlpha = (Button) findViewById(R.id.alpha);
        mRotation = (Button) findViewById(R.id.rotation);
        mRotationX = (Button) findViewById(R.id.rotationX);
        mRotationY = (Button) findViewById(R.id.rotationY);
        textView = (TextView) findViewById(R.id.objectTest);
        mScale = (Button) findViewById(R.id.scale);
        mScaleX = (Button) findViewById(R.id.scaleX);
        mScaleY = (Button) findViewById(R.id.scaleY);
        mTranslationX = (Button) findViewById(R.id.translationX);
        mTranslationY = (Button) findViewById(R.id.translationY);

        mAlpha.setOnClickListener(this);
        mRotation.setOnClickListener(this);
        mRotationX.setOnClickListener(this);
        mRotationY.setOnClickListener(this);
        mScaleX.setOnClickListener(this);
        mScale.setOnClickListener(this);
        mScaleY.setOnClickListener(this);
        mTranslationX.setOnClickListener(this);
        mTranslationY.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.alpha:
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView , "alpha" , 1f , 0f , 1f);
                objectAnimator.setDuration(5000);
                objectAnimator.start();
                break;
            case R.id.rotation:
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(textView , "rotation" , 0f , 360f);
                objectAnimator1.setDuration(3000);
                objectAnimator1.setStartDelay(2000);
                objectAnimator1.start();
                break;
            case R.id.rotationX:
                ObjectAnimator.ofFloat(textView , "rotationX" , 0f , 180f).setDuration(2000).start();
                break;
            case R.id.rotationY:
                ObjectAnimator.ofFloat(textView , "rotationY" , 0f , 180f).setDuration(2000).start();
                break;
            case R.id.scale:
                ObjectAnimator.ofFloat(textView, "scaleX", 1.0f, 2.0f).setDuration(3000).start();
                ObjectAnimator.ofFloat(textView , "scaleY" , 1.0f , 2.0f).setDuration(3000).start();
                break;
            case R.id.scaleX:
                ObjectAnimator.ofFloat(textView , "scaleX" , 1.0f , 0.5f).setDuration(3000).start();
                break;
            case R.id.scaleY:
                ObjectAnimator.ofFloat(textView , "scaleY" , 2.0f , 1.0f).setDuration(3000).start();
                break;
            case R.id.translationX:
                ObjectAnimator.ofFloat(textView , "translationX" , textView.getTranslationX() , -500f, textView.getTranslationX()).setDuration(3000).start();
                break;
            case R.id.translationY:
                ObjectAnimator.ofFloat(textView , "translationY" , textView.getTranslationY() , 200f , textView.getTranslationY()).setDuration(3000).start();
                break;
        }
    }
}
