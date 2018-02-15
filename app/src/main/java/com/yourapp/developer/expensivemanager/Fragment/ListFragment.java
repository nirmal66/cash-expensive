package com.yourapp.developer.expensivemanager.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yourapp.developer.expensivemanager.Adapter.ExpensiveAdapter;
import com.yourapp.developer.expensivemanager.Database.AdddbModel;
import com.yourapp.developer.expensivemanager.R;
import com.yourapp.developer.expensivemanager.Utilities.BaseFragment;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<AdddbModel> model = new ArrayList<AdddbModel>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view_app);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        new DatabaseAsync().execute();
    }

    private class DatabaseAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mAdapter = new ExpensiveAdapter(model);
            mRecyclerView.setAdapter(mAdapter);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            model =  db.epensiveDAO().getAll();
            return null;
        }
    }
}
