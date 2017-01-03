package oxim.digital.rxanim;

import android.view.View;

import io.reactivex.Completable;
import oxim.digital.rxanim.koko.valueanimator.FadeInKoko;
import oxim.digital.rxanim.koko.valueanimator.FadeOutKoko;
import oxim.digital.rxanim.koko.valueanimator.RotateByAnimator;

import static oxim.digital.rxanim.RxAnimationBuilder.animate;

public final class RxAnimations {

    public static Completable fadeOut(final View view) {
        return animate(view)
                .addAnimator(new FadeOutKoko())
                .build();
    }

    public static Completable rotateBy(final View view, final float value) {
        return animate(view)
                .addAnimator(new RotateByAnimator(value))
                .build();
    }

    public static Completable fadeIn(View view) {
        return animate(view)
                .addAnimator(new FadeInKoko())
                .build();
    }
}
