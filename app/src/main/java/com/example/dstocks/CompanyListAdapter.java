package com.example.dstocks;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CompanyListAdapter extends ArrayAdapter<CompanyModel> implements Filterable,View.OnClickListener {
    private ArrayList<CompanyModel> companyList;
    private Filter companyFilter;
    ArrayList<String> userFavs;
    private Context mContext;
    private ArrayList<CompanyModel> oriList;
    private String type;
    public CompanyListAdapter(ArrayList<CompanyModel> list,Context context) {
        super(context, R.layout.company_list_adapter, list);
        oriList=list;
        mContext=context;
        this.type=type;
        companyList=list;
        userFavs=MainActivity.userFavs;

    }

    private int lastPosition = -1;
    private static class ViewHolder{
        TextView code;
        TextView name;
        TextView ltp;
        TextView change;
        TextView changeP;
        ImageButton fav;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        CompanyModel model=getItem(position);
        final View result;
        final ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.company_list_adapter,parent,false);
            viewHolder.code=convertView.findViewById((R.id.code));
            viewHolder.name=convertView.findViewById(R.id.name);
            viewHolder.change=convertView.findViewById(R.id.change);
            viewHolder.changeP=convertView.findViewById(R.id.changeP);
            viewHolder.ltp=convertView.findViewById(R.id.ltp);
            viewHolder.fav=convertView.findViewById(R.id.favButton);

            result=convertView;
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)convertView.getTag();
            result=convertView;
        }
        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;
        viewHolder.fav.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getContext(),"H",Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.name.setText(model.getName());
        viewHolder.ltp.setText(model.getLtp().toString());
        viewHolder.change.setText(model.getChange().toString());
        viewHolder.changeP.setText(model.getChangeP().toString());
        viewHolder.code.setText(model.getCode());
        if(model.isFav())viewHolder.fav.setBackgroundResource(R.drawable.ic_favorite_yes);
        else viewHolder.fav.setBackgroundResource(R.drawable.ic_favorite_no);
        return convertView;

    }
    public int getCount() {
        return companyList.size();
    }

    public CompanyModel getItem(int position) {
        return companyList.get(position);
    }

    public long getItemId(int position) {

        return companyList.get(position).hashCode();
    }
    public void resetData() {
        companyList = oriList;
    }




    /*
     * We create our filter
     */

    @Override
    public Filter getFilter() {
        if (companyFilter == null)
            companyFilter = new CompanyFilter();

        return companyFilter;
    }

    @Override
    public void onClick(View v) {

    }


    private class CompanyFilter extends Filter {


        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            // We implement here the filter logic
            if (constraint == null || constraint.length() == 0) {
                // No filter implemented we return all the list
                results.values = oriList;
                results.count = oriList.size();
            }
            else {
                // We perform filtering operation
                ArrayList<CompanyModel> nPlanetList = new ArrayList<CompanyModel>();

                for (CompanyModel p : companyList) {
                    if (p.getName().toLowerCase().startsWith(constraint.toString().toLowerCase())||p.getCode().toLowerCase().startsWith(constraint.toString().toLowerCase()))
                        nPlanetList.add(p);
                }

                results.values = nPlanetList;
                results.count = nPlanetList.size();

            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {

            // Now we have to inform the adapter about the new list filtered
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                companyList = (ArrayList<CompanyModel>) results.values;
                notifyDataSetChanged();
            }

        }

    }
}