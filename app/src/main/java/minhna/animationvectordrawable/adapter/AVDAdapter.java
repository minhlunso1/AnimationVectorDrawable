package minhna.animationvectordrawable.adapter;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import minhna.animationvectordrawable.R;
import minhna.animationvectordrawable.application.BaseApplication;
import minhna.animationvectordrawable.model.AVD;
import minhna.animationvectordrawable.utils.ScaleUtils;

/**
 * Created by Administrator on 31-Jul-17.
 */

public class AVDAdapter extends RecyclerView.Adapter<AVDViewHolder> {
    private Context context;
    private List<AVD> avdList;
    private float heightSize;

    public AVDAdapter(Context context, List<AVD> avdList) {
        this.context = context;
        this.avdList = avdList;
        if (avdList != null && avdList.size() != 0)
            heightSize = BaseApplication.screenSize.y / avdList.size() - ScaleUtils.convertDpToPixel(25f);
        else
            heightSize = 240f;
    }

    @Override
    public AVDViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_avd, parent, false);
        return new AVDViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AVDViewHolder holder, final int position) {
        holder.container.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) heightSize));
        holder.container.setBackgroundColor(ContextCompat.getColor(context, avdList.get(position).getColor()));
        holder.imgAVD.setImageDrawable(context.getDrawable(avdList.get(position).getCurrentAVD()));
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (avdList.get(position).isReverse()) {
                    holder.imgAVD.setImageDrawable(context.getDrawable( avdList.get(position).getReverse_avd()));
                    avdList.get(position).setReverse(false);
                } else {
                    holder.imgAVD.setImageDrawable(context.getDrawable(avdList.get(position).getAvd()));
                    avdList.get(position).setReverse(true);
                }
                Drawable d = holder.imgAVD.getDrawable();
                ((AnimatedVectorDrawable) d).start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return avdList != null ? avdList.size():0;
    }
}
