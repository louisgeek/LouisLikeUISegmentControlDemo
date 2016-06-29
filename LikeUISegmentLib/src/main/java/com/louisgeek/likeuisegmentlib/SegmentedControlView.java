package com.louisgeek.likeuisegmentlib;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by louisgeek on 2016/6/29.
 */
public class SegmentedControlView extends LinearLayout{
    private static final String TAG = "SegmentedControlView";
    private Context mContext;
    private RadioGroup mRadioGroup;
    private int mNowIndex=0;
    public SegmentedControlView(Context context) {
        this(context,null);
    }

    public SegmentedControlView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SegmentedControlView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        //View view=View.inflate(context, R.layout.layout_segmented_control_view, this);
        final View view = LayoutInflater.from(mContext).inflate(R.layout.layout_segmented_control_view, this);
        mRadioGroup= (RadioGroup) view.findViewById(R.id.id_rg);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.id_rb_left){
                    mNowIndex=0;
                }else if(checkedId==R.id.id_rb_right){
                    mNowIndex=1;
                }
            }
        });
    }

    public int getSelectIndex(){
        return  mNowIndex;
    }
    public String getSelectName(){
        String  selectName="";
        RadioButton rb = (RadioButton) mRadioGroup.getChildAt(mNowIndex);
        if (rb!=null){
            selectName=String.valueOf(rb.getText());
        }
        return  selectName;
    }
    public void setSelectIndex(int pos){
        if (mRadioGroup!=null) {
            mNowIndex=pos;
            RadioButton rb = (RadioButton) mRadioGroup.getChildAt(mNowIndex);
            rb.setChecked(true);
        }else {
            Log.d(TAG, "setSelectIndex: setSelectIndex:"+pos);
        }
    }
}
