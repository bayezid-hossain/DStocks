package com.example.dstocks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class companiesFragment extends Fragment {
    View view;
    private static CompanyListAdapter adapter;
    ArrayList<CompanyModel> dataModels;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.companies_fragment,container,false);
        ListView listView=(ListView)view.findViewById(R.id.companyList);
        dataModels=new ArrayList<>();
        dataModels.add(new CompanyModel("Aamra net Company","AAMARNET",1.1,1.2,1.3,3.2,3.4,5.6,7.7,5.5,6.6,4.3));
        dataModels.add(new CompanyModel("Aamra net Company","AAMARNET",1.1,1.2,1.3,3.2,3.4,5.6,7.7,5.5,6.6,4.3));
        dataModels.add(new CompanyModel("Aamra net Company","AAMARNET",1.1,1.2,1.3,3.2,3.4,5.6,7.7,5.5,6.6,4.3));
        dataModels.add(new CompanyModel("Aamra net Company","AAMARNET",1.1,1.2,1.3,3.2,3.4,5.6,7.7,5.5,6.6,4.3));
        dataModels.add(new CompanyModel("Aamra net Company","AAMARNET",1.1,1.2,1.3,3.2,3.4,5.6,7.7,5.5,6.6,4.3));
        dataModels.add(new CompanyModel("Aamra net Company","AAMARNET",1.1,1.2,1.3,3.2,3.4,5.6,7.7,5.5,6.6,4.3));
        dataModels.add(new CompanyModel("Aamra net Company","AAMARNET",1.1,1.2,1.3,3.2,3.4,5.6,7.7,5.5,6.6,4.3));
        dataModels.add(new CompanyModel("Aamra net Company","AAMARNET",1.1,1.2,1.3,3.2,3.4,5.6,7.7,5.5,6.6,4.3));
        dataModels.add(new CompanyModel("Aamra net Company","AAMARNET",1.1,1.2,1.3,3.2,3.4,5.6,7.7,5.5,6.6,4.3));
        dataModels.add(new CompanyModel("Aamra net Company","AAMARNET",1.1,1.2,1.3,3.2,3.4,5.6,7.7,5.5,6.6,4.3));
        dataModels.add(new CompanyModel("Aamra net Company","AAMARNET",1.1,1.2,1.3,3.2,3.4,5.6,7.7,5.5,6.6,4.3));
        dataModels.add(new CompanyModel("Aamra net Company","AAMARNET",1.1,1.2,1.3,3.2,3.4,5.6,7.7,5.5,6.6,4.3));
        dataModels.add(new CompanyModel("Aamra net Company","AAMARNET",1.1,1.2,1.3,3.2,3.4,5.6,7.7,5.5,6.6,4.3));
        adapter=new CompanyListAdapter(dataModels,getContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CompanyModel dataModel= dataModels.get(position);

                Snackbar.make(view, ((CompanyModel) dataModel).getName()+"\n"+dataModel.getCode()+" API: "+dataModel.getChange(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
        return view;
    }

    public companiesFragment(){

    }
}
