package com.yourapp.developer.expensivemanager.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by nirmal.ku on 11/15/2017.
 */

@Dao
public interface ExpensiveDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     void insertExpensive(AdddbModel adddbModel);
    @Query("select * from adddbmodel")
    List<AdddbModel> getAll();

}
