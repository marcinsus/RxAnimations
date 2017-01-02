package oxim.digital.rxanim;

import android.animation.ValueAnimator;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Consumer;

public class RxAnimate {

    public static Completable animateTogether(final CompletableSource... completables) {
        return Completable.mergeArray(completables);
    }

    public static RxValueAnimatorCompletable from(final ValueAnimator valueAnimator, final Consumer<ValueAnimator> valueUpdateAction) {
        return new RxValueAnimatorCompletable(valueAnimator, valueUpdateAction);
    }

}
