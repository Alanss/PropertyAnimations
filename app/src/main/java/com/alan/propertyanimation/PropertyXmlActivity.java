package com.alan.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PropertyXmlActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mXmlOne;
    private Button mXmlTwo;
    private Button mXmlThree;
    private TextView mTestText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_xml);

        mXmlOne = (Button) findViewById(R.id.xmlOne);
        mXmlTwo = (Button) findViewById(R.id.xmlTwo);
        mXmlThree = (Button) findViewById(R.id.xmlThree);
        mTestText = (TextView) findViewById(R.id.xmlTestText);

        mXmlOne.setOnClickListener(this);
        mXmlTwo.setOnClickListener(this);
        mXmlThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.xmlOne:
                Animator animator = AnimatorInflater.loadAnimator(PropertyXmlActivity.this , R.animator.value_animator);
                animator.setTarget(mTestText);
                animator.start();
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.e("AlanDebug" ,"startAnimator");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                break;
            case R.id.xmlTwo:
                Animator objectAnimator = AnimatorInflater.loadAnimator(PropertyXmlActivity.this , R.animator.object_animator);
                objectAnimator.setTarget(mTestText);
                objectAnimator.start();
                break;
            case R.id.xmlThree:
                Animator setAnimator = AnimatorInflater.loadAnimator(PropertyXmlActivity.this , R.animator.set_animator);
                setAnimator.setTarget(mTestText);
                setAnimator.start();
                break;
        }
    }
}
