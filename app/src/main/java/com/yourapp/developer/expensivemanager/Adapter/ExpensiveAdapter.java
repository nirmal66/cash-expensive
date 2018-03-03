package com.yourapp.developer.expensivemanager.Adapter;

import android.graphics.Color;
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

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView expensive, towhom, type, date, forwhat, note;
        ImageView delete, update;

        public CustomViewHolder(View itemView) {
            super(itemView);
            expensive = (TextView) itemView.findViewById(R.id.text_expense);
            towhom = (TextView) itemView.findViewById(R.id.text_to_whom);
            type = (TextView) itemView.findViewById(R.id.text_method);
            date = (TextView) itemView.findViewById(R.id.text_date);
            forwhat = (TextView) itemView.findViewById(R.id.text_for_what);
            note = (TextView) itemView.findViewById(R.id.text_note);
            delete = (ImageView) itemView.findViewById(R.id.delete);
            update = (ImageView) itemView.findViewById(R.id.update);
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


        try {
            holder.expensive.setText(notificationLists.get(position).getExpense());
            if (notificationLists.get(position).getFormat().equals("Lend"))
                holder.expensive.setTextColor(Color.GREEN);
            else
                holder.expensive.setTextColor(Color.RED);
            holder.towhom.setText(notificationLists.get(position).getTowhom());
            holder.type.setText(notificationLists.get(position).getMoneyType());
            holder.date.setText(notificationLists.get(position).getDateTime());
            holder.forwhat.setText(notificationLists.get(position).getForwhat());
            holder.note.setText(notificationLists.get(position).getNote());

            holder.update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickInterface.onUpdateClick(notificationLists.get(position));
                    Log.d("test for update click", "onClick: " + notificationLists.get(position).getId());
                }
            });


            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickInterface.onItemClick(notificationLists.get(position));
                    Log.d("test for delete click", "onClick: " + notificationLists.get(position).getId());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return notificationLists.size();
    }


}
