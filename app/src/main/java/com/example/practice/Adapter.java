package com.example.practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private ArrayList<ContactData> data;
    private LayoutInflater inflater;
    private Context context;
    public Adapter(ArrayList<ContactData> data, Context context){
        this.data = data;
        this.context = context;
        this.inflater =(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ArrayList<ContactData> getData() {
        return data;
    }

    public void setData(ArrayList<ContactData> data) {
        this.data = data;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    public void setInflater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.contact_layout, null);
        }
        ImageView avatar = view.findViewById(R.id.imageViewAvatar);
        ImageView PhoneIcon = view.findViewById(R.id.imageViewPhone);
        ImageView SmsIcon = view.findViewById(R.id.imageViewSMS);
        TextView name = (TextView) view.findViewById(R.id.textViewName);
        TextView phone = (TextView) view.findViewById(R.id.textViewPhone);

        name.setText(data.get(position).getFullName());
        phone.setText(data.get(position).getPhoneNumber());
        return view;
    }
}
