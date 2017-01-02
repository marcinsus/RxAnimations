package oxim.digital.rxanim;

import android.animation.ValueAnimator;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;

public class RxAnimate {

    public static Completable animateTogether(final CompletableSource... completables) {
        return Completable.mergeArray(completables);
    }

    public static RxAnimatorCompletable from(final ValueAnimator valueAnimator) {
        return new RxAnimatorCompletable(valueAnimator);
    }

}
