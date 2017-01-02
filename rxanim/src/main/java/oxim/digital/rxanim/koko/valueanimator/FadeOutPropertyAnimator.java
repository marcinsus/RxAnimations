package oxim.digital.rxanim.koko.valueanimator;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;

public class FadeOutPropertyAnimator extends KokoViewPropertyAnimator {

    @Override
    protected ViewPropertyAnimatorCompat createAnimator(View target, ViewPropertyAnimatorCompat animator) {
        return animator.alpha(0f);
    }
}