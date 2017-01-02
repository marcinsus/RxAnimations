package oxim.digital.rxanim;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.functions.Consumer;
import oxim.digital.rxanim.koko.valueanimator.KokoViewPropertyAnimator;

public final class RxAnimationBuilder {
    private final List<Consumer<KokoViewPropertyAnimator>> animateActions;
    private final View view;

    public static RxAnimationBuilder animate(final View view) {
        return new RxAnimationBuilder(view);
    }

    private RxAnimationBuilder(final View view) {
        this.view = view;
        this.animateActions = new ArrayList<>();
        this.animateActions.add(animate -> animate.animator(view));
    }

    public RxAnimationBuilder addAnimator(final KokoViewPropertyAnimator propertyAnimator) {
        propertyAnimator.animator(view);
        return this;
    }

    public Completable build() {
        return new AnimateCompletable(view, animateActions);
    }
}
