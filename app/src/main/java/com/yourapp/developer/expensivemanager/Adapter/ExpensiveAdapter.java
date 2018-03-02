package com.yourapp.developer.expensivemanager.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yourapp.developer.expensivemanager.Database.AdddbModel;
import com.yourapp.developer.expensivemanager.R;
import com.yourapp.developer.expensivemanager.Utilities.OnClickInterface;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by nirmal.ku on 1/27/2017.
 */
public class ExpensiveAdapter extends RecyclerView.Adapter<ExpensiveAdapter.CustomViewHolder> {

private List<AdddbModel> notificationLists = new ArrayList<AdddbModel>();


    private OnClickInterface mClickInterface;

    public ExpensiveAdapter(List<AdddbModel> mnotificationLists, OnClickInterface ClickInterface) {

        this.notificationLists = mnotificationLists;
        this.mClickInterface = ClickInterface;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView expensive,towhom,type,date,forwhat,note;
        ImageView delete;

        public CustomViewHolder(View itemView) {
            super(itemView);
            expensive = (TextView)itemView.findViewById(R.id.text_expense);
            towhom = (TextView)itemView.findViewById(R.id.text_to_whom);
            type = (TextView)itemView.findViewById(R.id.text_method);
            date = (TextView)itemView.findViewById(R.id.text_date);
            forwhat  = (TextView)itemView.findViewById(R.id.text_for_what);
            note = (TextView)itemView.findViewById(R.id.text_note);
            delete = (ImageView)itemView.findViewById(R.id.delete);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_current_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.expensive.setText(notificationLists.get(position).getExpense().toString());
        holder.towhom.setText(notificationLists.get(position).getTowhom().toString());
        holder.type.setText(notificationLists.get(position).getMoneyType().toString());
        holder.date.setText(notificationLists.get(position).getDateTime().toString());
        holder.forwhat.setText(notificationLists.get(position).getForwhat().toString());
        holder.note.setText(notificationLists.get(position).getNote().toString());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickInterface.onUpdateClick(notificationLists.get(position));
                Log.d("test for delete click", "onClick: "+notificationLists.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return notificationLists.size();
    }


}
