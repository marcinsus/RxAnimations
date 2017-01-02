package oxim.digital.rxanim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.MainThreadDisposable;

import static io.reactivex.android.MainThreadDisposable.verifyMainThread;

final class RxAnimatorCompletable extends Completable {

    private final Animator anim;

    RxAnimatorCompletable(final Animator anim) {
        this.anim = anim;
    }

    @Override
    protected void subscribeActual(CompletableObserver completableObserver) {
        verifyMainThread();
        Listener listener = new Listener(completableObserver, anim);
        completableObserver.onSubscribe(listener);
        anim.addListener(listener.animatorListener);
        anim.start();
    }

    private static class Listener extends MainThreadDisposable {
        private final CompletableObserver observer;
        private final Animator animator;
        private final AnimatorListenerAdapter animatorListener = new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(final Animator animation) {
                animator.removeListener(this);
                observer.onComplete();
            }
        };

        private Listener(CompletableObserver observer, Animator valueAnimator) {
            this.observer = observer;
            this.animator = valueAnimator;
        }

        @Override
        protected void onDispose() {
            animator.removeListener(animatorListener);
            animator.end();
        }
    }
}

