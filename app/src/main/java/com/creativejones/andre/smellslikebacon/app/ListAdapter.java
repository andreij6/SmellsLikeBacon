package com.creativejones.andre.smellslikebacon.app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.creativejones.andre.smellslikebacon.R;
import com.creativejones.andre.smellslikebacon.models.Recipes;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder> {

    ListFragment.OnRecipeSelected mListener;

    public ListAdapter(ListFragment.OnRecipeSelected listener) {
        mListener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextView;
        private ImageView mImageView;
        private int mIndex;

        public Holder(View itemView) {
            super(itemView);
            mTextView = (TextView)itemView.findViewById(R.id.itemText);
            mImageView = (ImageView) itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mTextView.setText(Recipes.names[position]);
            mImageView.setImageResource(Recipes.resourceIds[position]);
            mIndex = position;
        }

        @Override
        public void onClick(View v) {
            mListener.onListRecipeSelected(mIndex);
        }
    }
}
