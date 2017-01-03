package oxim.digital.rxanimations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Completable;
import oxim.digital.rxanim.RxAnimations;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.sample_view)
    View sampleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.root_view)
    public void animateSampleView() {
        final Completable rxValueAnimator = Completable.mergeArray(RxAnimations.rotateBy(sampleView, 10), RxAnimations.rotateBy(sampleView, 50))
                .andThen(RxAnimations.rotateBy(sampleView, 160))
                .repeat();

        rxValueAnimator.subscribe();

    }
}
