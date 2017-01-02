package oxim.digital.rxanim;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;

public class RxAnimate {
    public static Completable animateTogether(final CompletableSource... completables) {
        return Completable.mergeArray(completables);
    }
}
