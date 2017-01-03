package oxim.digital.rxanim.koko.valueanimator;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.view.animation.Interpolator;

public class RotateByAnimator extends KokoAnimator {

    private final float value;

    public RotateByAnimator(int animationDuration, Interpolator interpolator, float value) {
        super(animationDuration, interpolator);
        this.value = value;
    }

    public RotateByAnimator(float value) {
        this.value = value;
    }

    @Override
    protected ViewPropertyAnimatorCompat createAnimator(View target, ViewPropertyAnimatorCompat animator) {
        return animator.rotationBy(value);
    }
}