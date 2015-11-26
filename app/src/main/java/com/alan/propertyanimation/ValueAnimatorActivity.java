package com.alan.propertyanimation;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ValueAnimatorActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "AlanDebug";
    private Button valueAnimatorOfInt;
    private Button valueAnimatorOfFlaoat;
    private TextView mTestText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);

        valueAnimatorOfInt = (Button) findViewById(R.id.valueAnimator_ofInt);
        valueAnimatorOfFlaoat = (Button) findViewById(R.id.valueAnimator_ofFloat);
        mTestText = (TextView) findViewById(R.id.justText);

        valueAnimatorOfInt.setOnClickListener(this);
        valueAnimatorOfFlaoat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.valueAnimator_ofInt:
                ValueAnimator valueAnimator = ValueAnimator.ofInt(0 , 500);
                //ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f , 500f);
                valueAnimator.setDuration(3000);
                valueAnimator.setTarget(mTestText);
                valueAnimator.start();
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int currentValue = (int) animation.getAnimatedValue();
                       // float currentValue = (float) animation.getAnimatedValue();
                        Log.e(TAG, "current value is ; " + currentValue);
                        mTestText.setTranslationY(currentValue);
                    }
                });
                break;
            case R.id.valueAnimator_ofFloat:
                break;
        }
    }
}
