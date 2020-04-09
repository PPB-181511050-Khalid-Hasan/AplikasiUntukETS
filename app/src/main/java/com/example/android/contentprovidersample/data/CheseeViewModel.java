package com.example.android.contentprovidersample.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CheseeViewModel extends AndroidViewModel {
    private CheeseRepository mRepository;

    private LiveData<List<Cheese>> mAllCheese;

    public CheseeViewModel(@NonNull Application application) {
        super(application);
        mRepository = new CheeseRepository(application);
        mAllCheese = mRepository.getAllCheese();
    }

    public LiveData<List<Cheese>> getAllCheese() {return mAllCheese;}

}
