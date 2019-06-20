package com.anhtam.tikihome.custom;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.anhtam.tikihome.R;

public class RatingBarCustom extends ConstraintLayout {
    private Context mContext;
    private Resources res;
    private double ratingAverage;
    private ImageView imgStart1, imgStart2, imgStart3, imgStart4, imgStart5;

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

    private void initView(View view) {
        res = mContext.getResources();
        imgStart1 = view.findViewById(R.id.imgStar1);
        imgStart2 = view.findViewById(R.id.imgStar2);
        imgStart3 = view.findViewById(R.id.imgStar3);
        imgStart4 = view.findViewById(R.id.imgStar4);
        imgStart5 = view.findViewById(R.id.imgStar5);
    }

    public void init(double ratingAverage) {
        this.ratingAverage = ratingAverage;
        setRating();
    }

    private void setRating() {
        switch ((int) ratingAverage) {
            case 1:
                imgStart1.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart2.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                imgStart3.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                imgStart4.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                imgStart5.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                break;
            case 2:
                imgStart1.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart2.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart3.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                imgStart4.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                imgStart5.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                break;
            case 3:
                imgStart1.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart2.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart3.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart4.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                imgStart5.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                break;
            case 4:
                imgStart1.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart2.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart3.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart4.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart5.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                break;
            case 5:
                imgStart1.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart2.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart3.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart4.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                imgStart5.setImageDrawable(res.getDrawable(R.drawable.ic_star_active));
                break;
            default:
                imgStart1.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                imgStart2.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                imgStart3.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                imgStart4.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                imgStart5.setImageDrawable(res.getDrawable(R.drawable.ic_star_unactive));
                break;
        }
    }
}
