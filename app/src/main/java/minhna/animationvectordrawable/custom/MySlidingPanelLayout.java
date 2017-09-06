package minhna.animationvectordrawable.custom;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

/**
 * Created by Administrator on 07-Sep-17.
 */

public class MySlidingPanelLayout extends SlidingUpPanelLayout {
    // ===========================================================
    // Constructors
    // ===========================================================
    public MySlidingPanelLayout(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public MySlidingPanelLayout(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public MySlidingPanelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
            if ( MotionEventCompat.getActionMasked(event) != MotionEvent.ACTION_MOVE)
                return super.onTouchEvent(event);
            return true;
        } catch (Exception ex) {
            // Ignore the pointer out of range exception
            return false;
        }
    }
}