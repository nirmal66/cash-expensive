package com.yourapp.developer.expensivemanager.Fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yourapp.developer.expensivemanager.R;
import com.yourapp.developer.expensivemanager.databinding.FragmentContactBinding;

public class ContactFragment extends Fragment {

    FragmentContactBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact, container, false);
        binding.setHandler(new handler());
        return binding.getRoot();    }


    public class handler
    {
        public void contactOnclick(View view)
        {
           // Toast.makeText(getActivity(),binding.contactEdittext.getText().toString(),Toast.LENGTH_LONG).show();

            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL,
                    new String[] { "yourapp001@gmail.com" });
            email.putExtra(Intent.EXTRA_SUBJECT, "Feedback from user");
            email.putExtra(Intent.EXTRA_TEXT, binding.contactEdittext.getText().toString());
            email.setType("message/rfc822");

            startActivity(Intent.createChooser(email,
                    "Choose an Email client :"));
        }
    }
}
