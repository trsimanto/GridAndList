package com.example.towhid.gridandlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridViewAdapter extends ArrayAdapter <Product>{
    public GridViewAdapter(Context context, int resource,List<Product> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if (null==view){
            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.grid_item,null);
        }
        Product product=getItem(position);
        ImageView img = (ImageView)view.findViewById(R.id.imageView);
        TextView txtTitle=(TextView)view.findViewById(R.id.txtTitle);
        TextView txtDescription=(TextView)view.findViewById(R.id.txtDescription);


        img.setImageResource(product.getImageId());
        txtTitle.setText(product.getTitle());
        txtDescription.setText(product.getDescription());

        return view;

    }
}
