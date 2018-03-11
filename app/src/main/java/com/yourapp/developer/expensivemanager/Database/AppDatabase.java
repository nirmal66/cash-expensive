package com.yourapp.developer.expensivemanager.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by nirmal.ku on 11/16/2017.
 */
@Database(entities = {AdddbModel.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase{
    public abstract ExpensiveDAO epensiveDAO() ;
}
