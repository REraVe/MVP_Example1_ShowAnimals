package com.rerave.mvp_example1_showanimals.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rerave.mvp_example1_showanimals.R;
import com.rerave.mvp_example1_showanimals.presenter.MainPresenter;
import com.rerave.mvp_example1_showanimals.presenter.MainPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity implements MainView {

    private static MainPresenter mMainPresenter;

    @BindView(R.id.image_animal) ImageView mAnimalImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initPresenter();

        setFullScreen();

        mMainPresenter.showAnimalImage();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setFullScreen();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mMainPresenter.detachView(this);

        if (!isChangingConfigurations()) {
            mMainPresenter = null;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void updateAnimalImage(int imageIndex) {
        mAnimalImage.setImageDrawable(getDrawable(imageIndex));
    }

    @OnClick(R.id.image_animal)
    void onAnimalImageClick() {
        mMainPresenter.showNextAnimalImage();
    }

    @OnLongClick(R.id.image_animal)
    boolean onAnimalImageLongClick() {
        mMainPresenter.showPreviousAnimalImage();
        return true;
    }

    @OnClick(R.id.button_exit)
    void onExitButtonClick() {
        onBackPressed();
    }

    private void initPresenter() {
        if (mMainPresenter == null) {
            mMainPresenter = new MainPresenterImpl();
        }

        mMainPresenter.attachView(this);
    }

    private void setFullScreen() {
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN;

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(uiOptions);
    }
}
