package com.anhtam.tikihome.custom;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.anhtam.tikihome.R;

public class RatingBarCustom extends ConstraintLayout {
    private Context mContext;
    private Resources res;
    public RatingBarCustom(Context context) {
        super(context);
        addView(context);
    }

    public RatingBarCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        addView(context);
    }

    public RatingBarCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addView(context);
    }

    private void addView(Context context) {
        this.mContext = context;
        View view = inflate(getContext(), R.layout.layout_rating_bar, null);
        res = context.getResources();
        initView(view);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        addView(view);
    }

    private void initView (View view){

    }
}
