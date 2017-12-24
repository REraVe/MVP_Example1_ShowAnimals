package com.rerave.mvp_example1_showanimals.presenter;

import com.rerave.mvp_example1_showanimals.view.MainView;
import com.rerave.mvp_example1_showanimals.model.MainModel;
import com.rerave.mvp_example1_showanimals.model.MainModelImpl;

public class MainPresenterImpl implements MainPresenter {

    private MainView  mMainView;
    private MainModel mMainModel;

    public MainPresenterImpl() {
        this.mMainModel = new MainModelImpl();
    }

    @Override
    public void attachView(MainView mainView) {
        this.mMainView = mainView;
    }

    @Override
    public void detachView(MainView mainView) {
        if (this.mMainView == mainView) {
            this.mMainView = null;
        }
    }

    @Override
    public void showAnimalImage() {
        mMainView.updateAnimalImage(mMainModel.getAnimalIndex());
    }

    @Override
    public void showNextAnimalImage() {
        mMainView.updateAnimalImage(mMainModel.getNextAnimalIndex());
    }

    @Override
    public void showPreviousAnimalImage() {
        mMainView.updateAnimalImage(mMainModel.getPreviousAnimalIndex());
    }

}
