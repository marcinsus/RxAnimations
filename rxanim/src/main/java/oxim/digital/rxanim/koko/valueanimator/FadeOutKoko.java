package oxim.digital.rxanim.koko.valueanimator;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import android.view.animation.Interpolator;

public class FadeOutKoko extends KokoAnimator {
    public FadeOutKoko() {
    }

    public FadeOutKoko(int animationDuration, Interpolator interpolator) {
        super(animationDuration, interpolator);
    }

    @Override
    protected ViewPropertyAnimatorCompat createAnimator(View target, ViewPropertyAnimatorCompat animator) {
        return animator.alpha(0f);
    }
}