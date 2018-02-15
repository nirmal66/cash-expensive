package com.yourapp.developer.expensivemanager.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yourapp.developer.expensivemanager.Database.AdddbModel;
import com.yourapp.developer.expensivemanager.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by nirmal.ku on 1/27/2017.
 */
public class ExpensiveAdapter extends RecyclerView.Adapter<ExpensiveAdapter.CustomViewHolder> {

private List<AdddbModel> notificationLists = new ArrayList<AdddbModel>();

    public ExpensiveAdapter(List<AdddbModel> mnotificationLists) {

        this.notificationLists = mnotificationLists;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView expensive,towhom,type,date,forwhat,note;

        public CustomViewHolder(View itemView) {
            super(itemView);
            expensive = (TextView)itemView.findViewById(R.id.text_expense);
            towhom = (TextView)itemView.findViewById(R.id.text_to_whom);
            type = (TextView)itemView.findViewById(R.id.text_method);
            date = (TextView)itemView.findViewById(R.id.text_date);
            forwhat  = (TextView)itemView.findViewById(R.id.text_for_what);
            note = (TextView)itemView.findViewById(R.id.text_note);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_current_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.expensive.setText(notificationLists.get(position).getExpense().toString());
        holder.towhom.setText(notificationLists.get(position).getTowhom().toString());
        holder.type.setText(notificationLists.get(position).getMoneyType().toString());
        holder.date.setText(notificationLists.get(position).getDateTime().toString());
        holder.forwhat.setText(notificationLists.get(position).getForwhat().toString());
        holder.note.setText(notificationLists.get(position).getNote().toString());


    }

    @Override
    public int getItemCount() {
        return notificationLists.size();
    }


}
