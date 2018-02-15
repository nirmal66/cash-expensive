package com.yourapp.developer.expensivemanager.Utilities;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yourapp.developer.expensivemanager.Database.AppDatabase;

/**
 * Created by nirmal.ku on 11/16/2017.
 */

public class BaseFragment extends android.support.v4.app.Fragment {

   public static AppDatabase db;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "expensivemanager.db").build();
    }
}
