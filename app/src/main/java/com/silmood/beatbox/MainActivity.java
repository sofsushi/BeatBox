package com.silmood.beatbox;

import android.support.v4.app.Fragment;

public class MainActivity extends FragmentContainerActivity{

    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }

}
