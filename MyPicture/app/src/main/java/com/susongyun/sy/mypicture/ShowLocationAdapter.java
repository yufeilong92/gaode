package com.susongyun.sy.mypicture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

/**
 * @Author : Yufeilong  is Creating a porject in YFPHILPS
 * @Email : yufeilong92@163.com
 * @Time :2016/12/6 14:17
 * @Purpose : 显示地图
 */
public class ShowLocationAdapter extends BaseAdapter {


    private ArrayList<LocationVo> mData;
    private Context mContext;
    private final LayoutInflater mInflater;


    public ShowLocationAdapter(Context context, ArrayList<LocationVo> mData) {
        this.mData = mData;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<LocationVo> mData) {
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData == null ? null : mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View converview, ViewGroup viewGroup) {
        ViewHolder holder;
        if (converview == null) {
            converview = mInflater.inflate(R.layout.show_loaction, null);
            holder = new ViewHolder(converview);
            converview.setTag(holder);
        } else {
            holder = (ViewHolder) converview.getTag();
        }


        holder.location_country.setText(mData.get(i).getCountry());
        holder.location_province.setText(mData.get(i).getProvince());
        holder.location_city.setText(mData.get(i).getCity());
        holder.location_district.setText(mData.get(i).getDistrict());
        holder.location_address.setText(mData.get(i).getAddress());
        return converview;
    }


    public static class ViewHolder {
        public View rootView;
        public RadioButton location_city;
        public RadioButton location_district;
        public RadioButton location_address;
        public RadioGroup location_radio_group;
        public RadioButton location_country;
        public RadioButton location_province;


        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.location_city = (RadioButton) rootView.findViewById(R.id.location_city);
            this.location_district = (RadioButton) rootView.findViewById(R.id.location_district);
            this.location_address = (RadioButton) rootView.findViewById(R.id.location_address);
            this.location_radio_group = (RadioGroup) rootView.findViewById(R.id.location_radio_group);
            this.location_country = (RadioButton) rootView.findViewById(R.id.location_country);
            this.location_province = (RadioButton) rootView.findViewById(R.id.location_province);
        }

    }
}
