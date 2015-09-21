package com.nghiatt.demomaterialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.nghiatt.demomaterialdesign.R;
import com.nghiatt.demomaterialdesign.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ngh on 9/6/2015.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Item> mList;

    private OnViewClickListener mViewListener;
    private Context context;

    private LayoutInflater inflater;
    private List<Integer> listDeleteClick;


    public ListAdapter(Context context, List<Item> list) {
        mList = list;
        this.context = context;
        listDeleteClick = new ArrayList<>();
        inflater = LayoutInflater.from(context);


    }


    public void setOnViewClickListener(OnViewClickListener listener) {
        mViewListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.layout_item, parent, false);
        final ViewHolder viewholder = new ViewHolder(v);

        viewholder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mViewListener != null) {
                    mViewListener.onViewClick(view, viewholder.getAdapterPosition());
                }
            }
        });

        return viewholder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = mList.get(position);
        holder.tvName.setText(item.name);
    }


    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            view = (View) itemView.findViewById(R.id.container);
            tvName=(TextView)itemView.findViewById(R.id.tv_name);

        }
    }


    public interface OnViewClickListener {
        void onViewClick(View view, int position);
    }
}


