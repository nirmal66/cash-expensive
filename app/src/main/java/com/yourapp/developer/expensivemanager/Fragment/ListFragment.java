package com.yourapp.developer.expensivemanager.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yourapp.developer.expensivemanager.Adapter.ExpensiveAdapter;
import com.yourapp.developer.expensivemanager.Database.AdddbModel;
import com.yourapp.developer.expensivemanager.MainActivity;
import com.yourapp.developer.expensivemanager.R;
import com.yourapp.developer.expensivemanager.Utilities.BaseFragment;
import com.yourapp.developer.expensivemanager.Utilities.OnClickInterface;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends BaseFragment implements OnClickInterface {

    List<AdddbModel> model = new ArrayList<AdddbModel>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int i;
    private AdddbModel adddbModel;

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

    @Override
    public void onItemClick(AdddbModel model) {
        Log.d("delete", "testing:" + model.getTowhom());
        i = 1;
        adddbModel = model;
        new DatabaseAsync().execute();
    }

    @Override
    public void onUpdateClick(AdddbModel model) {


        AddExpensiveFragment addExpensiveFragment = new AddExpensiveFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_transaction, addExpensiveFragment, "ListFragment");
        addExpensiveFragment.Update(model);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    private class DatabaseAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mAdapter = new ExpensiveAdapter(model, ListFragment.this);
            mRecyclerView.setAdapter(mAdapter);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            if (i == 1) {
                db.epensiveDAO().delete(adddbModel);
            }
            model = db.epensiveDAO().getAll();
            return null;
        }
    }


}
