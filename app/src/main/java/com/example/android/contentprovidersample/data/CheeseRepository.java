package com.example.android.contentprovidersample.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CheeseRepository {
    private CheeseDao mCheeseDao;
    private LiveData<List<Cheese>> mAllCheese;

    CheeseRepository(Application application) {
        CheeseRoomDatabase db = CheeseRoomDatabase.getDatabase(application);
        mCheeseDao = db.cheeseDao();
//        mAllTasks = mCheeseDao.getAlphabetizedWords();
        mAllCheese = (LiveData<List<Cheese>>) mCheeseDao.selectAll();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Cheese>> getAllCheese() {
        return mAllCheese;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
}
