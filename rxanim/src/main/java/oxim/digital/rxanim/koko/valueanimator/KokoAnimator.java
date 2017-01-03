package oxim.digital.rxanim.koko.valueanimator;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public abstract class KokoAnimator {
    private static final int DEFAULT_ANIMATION_DURATION = 350;
    private final int animationDuration;
    private final Interpolator interpolator;

    public KokoAnimator() {
        this.animationDuration = DEFAULT_ANIMATION_DURATION;
        this.interpolator = new LinearInterpolator();
    }

    public KokoAnimator(int animationDuration, Interpolator interpolator) {
        this.animationDuration = animationDuration;
        this.interpolator = interpolator;
    }

    protected abstract ViewPropertyAnimatorCompat createAnimator(View target, ViewPropertyAnimatorCompat animator);

    public ViewPropertyAnimatorCompat animator(View target) {
        ViewPropertyAnimatorCompat animator = ViewCompat.animate(target)
                .setDuration(animationDuration)
                .setInterpolator(interpolator);
        return createAnimator(target, animator);
    }
}