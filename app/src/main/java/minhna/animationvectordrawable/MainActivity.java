package minhna.animationvectordrawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import minhna.animationvectordrawable.adapter.AVDAdapter;
import minhna.animationvectordrawable.application.BaseApplication;
import minhna.animationvectordrawable.model.AVD;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_avd)
    public RecyclerView rvAVD;

    private List<AVD> avdList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getWindowManager().getDefaultDisplay().getSize(BaseApplication.screenSize);

        buildListData();
        rvAVD.setLayoutManager(new LinearLayoutManager(this));
        rvAVD.setAdapter(new AVDAdapter(this, avdList));
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
}
