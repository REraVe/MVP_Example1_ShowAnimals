package com.rerave.mvp_example1_showanimals.model;

import com.rerave.mvp_example1_showanimals.R;

import java.util.ArrayList;
import java.util.Collections;

public class MainModelImpl implements MainModel {

    private int mCurrentAnimalNum = 0;

    private ArrayList<Integer> mAnimalsList = new ArrayList<>();

    public MainModelImpl() {
        fillAnimalsList();
    }

    @Override
    public int getAnimalIndex() {
        return mAnimalsList.get(mCurrentAnimalNum);
    }

    @Override
    public int getNextAnimalIndex() {
        mCurrentAnimalNum++;

        if (mCurrentAnimalNum >= mAnimalsList.size()) {
            mCurrentAnimalNum = 0;
        }

        return mAnimalsList.get(mCurrentAnimalNum);
    }

    @Override
    public int getPreviousAnimalIndex() {
        mCurrentAnimalNum--;

        if (mCurrentAnimalNum < 0) {
            mCurrentAnimalNum = mAnimalsList.size() - 1;
        }

        return mAnimalsList.get(mCurrentAnimalNum);
    }

    private void fillAnimalsList() {
        mAnimalsList.add(R.drawable.pic_bear);
        mAnimalsList.add(R.drawable.pic_elephant);
        mAnimalsList.add(R.drawable.pic_giraffe);
        mAnimalsList.add(R.drawable.pic_hippo);
        mAnimalsList.add(R.drawable.pic_lion);
        mAnimalsList.add(R.drawable.pic_monkey);
        mAnimalsList.add(R.drawable.pic_tiger);

        Collections.shuffle(mAnimalsList);
    }
}
