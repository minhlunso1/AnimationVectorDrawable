package minhna.animationvectordrawable.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import minhna.animationvectordrawable.R;

/**
 * Created by Administrator on 31-Jul-17.
 */

public class AVDViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.container)
    public View container;
    @BindView(R.id.avd)
    public ImageView imgAVD;

    public AVDViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
