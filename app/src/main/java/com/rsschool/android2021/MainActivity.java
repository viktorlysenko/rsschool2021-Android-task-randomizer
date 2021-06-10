package com.rsschool.android2021;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;

public class MainActivity extends AppCompatActivity implements FirstFragment.ActionPerformedListenerFirstFragment, SecondFragment.ActionPerformedListenerSecondFragment {
    //private static final String TAG = "Test Activity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Log.d(TAG,"Create Artivity");
        openFirstFragment(0);
    }

    private void openFirstFragment(int previousNumber) {
        final Fragment firstFragment = FirstFragment.newInstance(previousNumber);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, firstFragment);
        transaction.commit();
        // TODO: invoke function which apply changes of the transaction
    }

    private void openSecondFragment(int min, int max) {
        // TODO: implement it
        final Fragment secondFragment = SecondFragment.newInstance(min,max);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, secondFragment);
        transaction.commit();
    }

    public void onActionPerformedFirsFragment(int min, int max){

        openSecondFragment(min,max);
    }

    public void onActionPerformedSecondFragment(int previousNumber){
        openFirstFragment(previousNumber);
    }
}
