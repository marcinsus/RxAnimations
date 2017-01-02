package oxim.digital.rxanim;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Consumer;
import oxim.digital.rxanim.koko.valueanimator.KokoViewPropertyAnimator;

import static io.reactivex.android.MainThreadDisposable.verifyMainThread;

final class AnimateCompletable extends Completable {

    private final View view;
    private final List<Consumer<KokoViewPropertyAnimator>> animationActions;

    AnimateCompletable(View view,
                       final List<Consumer<KokoViewPropertyAnimator>> animationActions) {
        this.view = view;
        this.animationActions = animationActions;
    }

    @Override
    protected void subscribeActual(CompletableObserver completableObserver) {
        verifyMainThread();
        final ViewPropertyAnimatorCompat animator = ViewCompat.animate(view);
        Listener listener = new Listener(animator);
        completableObserver.onSubscribe(listener);
        callAnimateActions(completableObserver, animator);
    }

    private void callAnimateActions(CompletableObserver completableObserver, ViewPropertyAnimatorCompat animator) {
        for (final Consumer<KokoViewPropertyAnimator> action : animationActions) {
            try {
                action.accept(animator);
            } catch (Exception e) {
                completableObserver.onError(e);
            }
        }
        animator.withEndAction(completableObserver::onComplete).start();
    }

    private static class Listener extends MainThreadDisposable {
        private final ViewPropertyAnimatorCompat animator;

        private Listener(ViewPropertyAnimatorCompat propertyAnimator) {
            animator = propertyAnimator;
        }

        @Override
        protected void onDispose() {
            animator.cancel();
        }
    }
}
