package oxim.digital.rxanim.koko;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

public class FadeOutAnimator extends KokoAnimator {

    @Override
    public Animator createAnimator(View target) {
        return ObjectAnimator.ofFloat(target, "alpha", 1, 0);
    }
}