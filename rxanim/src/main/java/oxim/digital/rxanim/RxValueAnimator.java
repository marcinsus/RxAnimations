package oxim.digital.rxanim;

import android.animation.ValueAnimator;

import io.reactivex.functions.Consumer;

public class RxValueAnimator {

    public static RxValueAnimatorCompletable from(final ValueAnimator valueAnimator, final Consumer<ValueAnimator> valueUpdateAction) {
        return new RxValueAnimatorCompletable(valueAnimator, valueUpdateAction);
    }

    public static RxAnimateValueObservable animatedValues(final ValueAnimator valueAnimator) {
        return new RxAnimateValueObservable(valueAnimator, true);
    }

    public static RxAnimateValueObservable animatedValuesReversed(final ValueAnimator valueAnimator) {
        return new RxAnimateValueObservable(valueAnimator, false);
    }

    public static RxAnimateFractionValueObservable animatedFractionValues(final ValueAnimator valueAnimator) {
        return new RxAnimateFractionValueObservable(valueAnimator, true);
    }

    public static RxAnimateFractionValueObservable animatedFractionValuesReversed(final ValueAnimator valueAnimator) {
        return new RxAnimateFractionValueObservable(valueAnimator, false);
    }

}
