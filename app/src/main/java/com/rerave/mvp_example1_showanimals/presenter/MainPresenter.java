package com.rerave.mvp_example1_showanimals.presenter;

import com.rerave.mvp_example1_showanimals.view.MainView;

public interface MainPresenter {

    void attachView(MainView mainView);

    void detachView(MainView mainView);

    void showAnimalImage();

    void showNextAnimalImage();

    void showPreviousAnimalImage();

}
