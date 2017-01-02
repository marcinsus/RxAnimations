package oxim.digital.rxanim;

import android.animation.Animator;

public class RxAnimator {

    public static RxAnimatorCompletable from(final Animator valueAnimator) {
        return new RxAnimatorCompletable(valueAnimator);
    }
}
