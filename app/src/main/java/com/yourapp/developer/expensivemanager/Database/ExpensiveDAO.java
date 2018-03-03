package com.yourapp.developer.expensivemanager.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by nirmal.ku on 11/15/2017.
 */

@Dao
public interface ExpensiveDAO {
    @Insert(onConflict = REPLACE)
     void insertExpensive(AdddbModel adddbModel);
    @Query("select * from adddbmodel")
    List<AdddbModel> getAll();
    @Delete
    void delete(AdddbModel adddbModel);
    @Update
    void update(AdddbModel adddbModel);
    @Query("select * from adddbmodel where money_format like :format")
    List<AdddbModel> getAllLend(String format);

}
