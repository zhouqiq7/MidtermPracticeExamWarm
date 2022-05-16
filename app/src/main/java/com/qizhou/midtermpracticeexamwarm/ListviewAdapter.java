package com.qizhou.midtermpracticeexamwarm;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.qizhou.midtermpracticeexamwarm.entities.ShoppingCar;

import java.util.List;

public class ListviewAdapter extends BaseAdapter {

    private final Context context;
    private final List<ShoppingCar> shoppingCars;
    private OnItemCheckedChanged onItemCheckedChangedListener;

    public ListviewAdapter(Context context, List<ShoppingCar> shoppingCars) {
        super();
        this.context = context;
        this.shoppingCars = shoppingCars;
    }

    @Override
    public int getCount() {
        return shoppingCars.size();
    }

    @Override
    public Object getItem(int arg0) {
        return this.shoppingCars.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup arg2) {
        final ListViewHolder holder;

        holder = new ListViewHolder();
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(R.layout.listview_adapter, null);

        ShoppingCar shoppingCar = shoppingCars.get(position);
        TextView itemName = convertView.findViewById(R.id.item_name);
        itemName.setText(shoppingCar.getItem().getName() + " $" + shoppingCar.getItem().getUnitPrice());

        holder.caption = convertView.findViewById(R.id.quantity);
        holder.caption.setTag(position);
        holder.caption.setText(shoppingCar.getQuantity() != null ? shoppingCar.getQuantity().toString() : "");
        convertView.setTag(holder);

        int tag_position = (Integer) holder.caption.getTag();
        holder.caption.setId(tag_position);
        holder.caption.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                final int position2 = holder.caption.getId();
                final EditText Caption = (EditText) holder.caption;
                if (Caption.getText().toString().length() > 0) {
                    shoppingCars.get(position2).setQuantity(Integer.parseInt(Caption.getText().toString()));
                } else {
                    Toast.makeText(context, "Please enter some value", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        /*
         * https://blog.csdn.net/cuihao1128/article/details/7668161
         */
        CheckBox checkBox = (CheckBox)convertView.findViewById(R.id.checkbox_added);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(onItemCheckedChangedListener != null)
                onItemCheckedChangedListener.onItemCheckedChanged(buttonView, position, isChecked);
            shoppingCar.setAdded(isChecked);
        });
        checkBox.setChecked(shoppingCar.getAdded());

        return convertView;
    }
}

class ListViewHolder {
    EditText caption;
}