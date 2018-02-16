package com.yourapp.developer.expensivemanager.Fragment;

import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.yourapp.developer.expensivemanager.Database.AdddbModel;
import com.yourapp.developer.expensivemanager.MainActivity;
import com.yourapp.developer.expensivemanager.R;
import com.yourapp.developer.expensivemanager.Utilities.BaseFragment;
import com.yourapp.developer.expensivemanager.databinding.FragmentAddExpensiveBinding;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddExpensiveFragment extends BaseFragment {
    FragmentAddExpensiveBinding binding;
    private RadioButton amountType;
    private String dateTime;
    private Date yourDate;
    private Boolean validate;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_expensive, container, false);
        binding.setHandler(new handler());
        return binding.getRoot();
    }


    public class handler
    {
        public void addOnclick(View view)
        {
            if(validate = Validate()) {
                int selectedId = binding.moneyType.getCheckedRadioButtonId();
                amountType = (RadioButton) getView().findViewById(selectedId);
                DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
                dateTime = df.format(Calendar.getInstance().getTime());
                try {
                    yourDate = df.parse(dateTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Snackbar.make(view, "Do not worry!!! you can save something by next time :)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                new DatabaseAsync().execute();
            }
        }
    }

    private Boolean Validate()
    {

        if(binding.expensive.getText().length()==0)
        {
            binding.expensive.setError("Enter your expensive");
            return false;
        }
        if(binding.toWhom.getText().length()==0)
        {
            binding.toWhom.setError("Enter toWhom");
            return false;
        }
        return true;
    }
    private class DatabaseAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(yourDate);
            AdddbModel add = new AdddbModel();
            add.setExpense(binding.expensive.getText().toString());
            add.setMoneyType(amountType.getText().toString());
            add.setYear(calendar.get(Calendar.YEAR)+"");
            SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
            String month_name = month_date.format(calendar.getTime());
            add.setMonth(month_name+"");
            add.setDateTime(dateTime);
            add.setNote(binding.note.getText().toString());
            add.setTowhom(binding.toWhom.getText().toString());
            add.setForwhat(binding.forWhat.getText().toString());
            db.epensiveDAO().insertExpensive(add);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ((MainActivity) getActivity()).fragment(new ListFragment(),"ListFragment");

        }
    }
}
