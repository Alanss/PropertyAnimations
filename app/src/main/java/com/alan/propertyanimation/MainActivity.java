package com.alan.propertyanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "AlanDebug";
    private Button valueAnimator;
    private Button objectAnimator;
    private Button mCombinationAnimation;
    private Button mPropertyXml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueAnimator = (Button) findViewById(R.id.valueAnimator);
        objectAnimator = (Button) findViewById(R.id.objectAnimator);
        mCombinationAnimation = (Button) findViewById(R.id.combinationAnimation);
        mPropertyXml = (Button) findViewById(R.id.animatorXml);

        valueAnimator.setOnClickListener(this);
        objectAnimator.setOnClickListener(this);
        mCombinationAnimation.setOnClickListener(this);
        mPropertyXml.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.valueAnimator:
                startActivity(new Intent(MainActivity.this , ValueAnimatorActivity.class));
                break;
            case R.id.objectAnimator:
                startActivity(new Intent(MainActivity.this , ObjectAnimatorActivity.class));
                break;
            case R.id.combinationAnimation:
                startActivity(new Intent(MainActivity.this , CombinationAnimationActivity.class));
                break;
            case R.id.animatorXml:
                startActivity(new Intent(MainActivity.this , PropertyXmlActivity.class));
                break;
        }
    }
}
