package com.example.asheransari.broadcastreciever1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by asher.ansari on 6/29/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {

    ArrayList<IncomingNumber> numbers = new ArrayList<>();

    private Context context;

    public RecyclerAdapter(ArrayList<IncomingNumber> numbers, Context context) {
        this.numbers = numbers;
        this.context = context;
    }

    public RecyclerAdapter(ArrayList<IncomingNumber> numbers) {
        this.numbers = numbers;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {

        holder.idTextView.setText(""+numbers.get(position).getId());
        holder.numberTextView.setText(numbers.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView idTextView;
        TextView numberTextView;

        public myViewHolder(View itemView) {
            super(itemView);
            idTextView = (TextView) itemView.findViewById(R.id.textId);
            numberTextView = (TextView) itemView.findViewById(R.id.txtNumber);
        }
    }
}
