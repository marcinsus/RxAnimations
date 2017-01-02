package oxim.digital.rxanim.koko.valueanimator;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;

public class RotateByAnimator extends KokoViewPropertyAnimator {

    private final float value;

    public RotateByAnimator(float value) {
        this.value = value;
    }

    @Override
    protected ViewPropertyAnimatorCompat createAnimator(View target, ViewPropertyAnimatorCompat animator) {
        return animator.rotationBy(value);
    }
}