package oxim.digital.rxanimations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Completable;
import oxim.digital.rxanim.RxAnimationBuilder;
import oxim.digital.rxanim.koko.valueanimator.RotateByAnimator;

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
        final Completable rxValueAnimator = RxAnimationBuilder.animate(sampleView).rotateBy(10).build()
                .andThen(RxAnimationBuilder.animate(sampleView).addAnimator(new RotateByAnimator(50)).build())
                .andThen(RxAnimationBuilder.animate(sampleView).rotateBy(-20).build())
                .andThen(RxAnimationBuilder.animate(sampleView).rotateBy(10).build())
                .repeat();

        rxValueAnimator.subscribe();

    }
}
