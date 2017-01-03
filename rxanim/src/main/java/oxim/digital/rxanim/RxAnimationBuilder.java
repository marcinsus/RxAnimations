package oxim.digital.rxanim;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.functions.Consumer;
import oxim.digital.rxanim.koko.valueanimator.KokoAnimator;

public final class RxAnimationBuilder {
    private final List<Consumer<ViewPropertyAnimatorCompat>> animateActions = new ArrayList<>();

    private final View view;

    public static RxAnimationBuilder animate(final View view) {
        return new RxAnimationBuilder(view);
    }

    private RxAnimationBuilder(final View view) {
        this.view = view;
    }

    public RxAnimationBuilder addAnimator(final KokoAnimator propertyAnimator) {
        animateActions.add(viewPropertyAnimatorCompat -> propertyAnimator.animator(view));
        return this;
    }

    public Completable build() {
        return new AnimateCompletable(view, animateActions);
    }
}
