package minhna.animationvectordrawable;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import minhna.animationvectordrawable.adapter.AVDAdapter;
import minhna.animationvectordrawable.application.BaseApplication;
import minhna.animationvectordrawable.model.AVD;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    @BindView(R.id.rv_avd)
    public RecyclerView rvAVD;

    private List<AVD> avdList;
    private Animation animation1, animation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getWindowManager().getDefaultDisplay().getSize(BaseApplication.screenSize);

        buildListData();
        rvAVD.setLayoutManager(new LinearLayoutManager(this));
        rvAVD.setAdapter(new AVDAdapter(this, avdList));

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startFlipVerticleRepeatedAnimation();
//            }
//        }, 2000);
    }

    private void startFlipVerticleRepeatedAnimation() {
        animation1 = AnimationUtils.loadAnimation(this, R.anim.to_middle);
        animation1.setAnimationListener(this);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.from_middle);
        animation2.setAnimationListener(this);

        rvAVD.clearAnimation();
        rvAVD.setAnimation(animation1);
        rvAVD.startAnimation(animation1);
    }

    private void buildListData() {
        avdList = new ArrayList<>();
        avdList.add(new AVD(R.drawable.plus_to_check_anim, R.drawable.plus_to_check_rev_anim, false,
                R.color.indigo_1));
        avdList.add(new AVD(R.drawable.android_to_android_bridge_anim, R.drawable.android_to_android_bridge_rev_anim,
                false, R.color.cyan_1));
        avdList.add(new AVD(R.drawable.right_to_left_anim, R.drawable.right_to_left_rev_anim, false,
                R.color.deep_purple1));
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animation1) {
            rvAVD.clearAnimation();
            rvAVD.setAnimation(animation2);
            rvAVD.startAnimation(animation2);
        } else {
            rvAVD.clearAnimation();
            rvAVD.setAnimation(animation1);
            rvAVD.startAnimation(animation1);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
