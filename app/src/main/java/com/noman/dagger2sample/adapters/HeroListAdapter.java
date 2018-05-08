package com.noman.dagger2sample.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.noman.dagger2sample.R;
import com.noman.dagger2sample.model.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class HeroListAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<Hero> heroList;

    public HeroListAdapter(Context context, ArrayList<Hero> heroList) {
        this.context = context;
        this.heroList = heroList;
    }


    @Override
    public int getCount() {
        return heroList.size();
    }

    @Override
    public Object getItem(int position) {
        return heroList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item_hero, null);

            viewHolder.nameTxt = (TextView) convertView.findViewById(R.id.name);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nameTxt.setText(heroList.get(position).getName());

        return convertView;
    }

    class ViewHolder {
        protected TextView nameTxt;
    }


}
