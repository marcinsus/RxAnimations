package oxim.digital.rxanim.koko;

import android.animation.Animator;
import android.view.View;

import io.reactivex.Completable;
import oxim.digital.rxanim.RxAnimator;

public abstract class KokoAnimator {
    public abstract Animator createAnimator(View target);

}