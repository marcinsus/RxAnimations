package oxim.digital.rxanim.koko.valueanimator;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;

public abstract class KokoViewPropertyAnimator {
    protected abstract ViewPropertyAnimatorCompat createAnimator(View target, ViewPropertyAnimatorCompat animator);

    public ViewPropertyAnimatorCompat animator(View target) {
        ViewPropertyAnimatorCompat animator = ViewCompat.animate(target);
        return createAnimator(target, animator);
    }
}