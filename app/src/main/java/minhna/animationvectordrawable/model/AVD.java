package minhna.animationvectordrawable.model;

/**
 * Created by Administrator on 31-Jul-17.
 */

public class AVD {
    private int avd;
    private int reverse_avd;
    private boolean isReverse;
    private int color;

    public AVD(int avd, int reverse_avd, boolean isReverse, int color) {
        this.avd = avd;
        this.reverse_avd = reverse_avd;
        this.isReverse = isReverse;
        this.color = color;
    }

    public int getAvd() {
        return avd;
    }

    public void setAvd(int avd) {
        this.avd = avd;
    }

    public int getReverse_avd() {
        return reverse_avd;
    }

    public void setReverse_avd(int reverse_avd) {
        this.reverse_avd = reverse_avd;
    }

    public boolean isReverse() {
        return isReverse;
    }

    public void setReverse(boolean reverse) {
        isReverse = reverse;
    }

    public int getCurrentAVD() {
        if (isReverse())
            return reverse_avd;
        else
            return avd;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
