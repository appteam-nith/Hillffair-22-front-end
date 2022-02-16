package com.nith.hillfair2k22.screens.eventsAndWorkshops;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nith.hillfair2k22.R;

import java.util.ArrayList;


public class WorkshopFragment extends Fragment {

    private RecyclerView workshopsRV;

    private EventsAdapter workshopsAdapter;
    private ArrayList<EventsModal> workshopsModalArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workshop, container, false);

        workshopsRV = view.findViewById(R.id.workshop_RecV);
        workshopsModalArrayList = new ArrayList<>();

        getWorkshopData();

        buildRecyclerView();

        return view;
    }

    private void getWorkshopData() {
        for (int i=0;i<9; i++){
            workshopsModalArrayList.add(new EventsModal("E_Title"+i,"E_club"+i,"E_date"+i,false));

        }
    }

    private void buildRecyclerView() {
        workshopsAdapter = new EventsAdapter(workshopsModalArrayList, getActivity());

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        workshopsRV.setHasFixedSize(true);

        workshopsRV.setLayoutManager(manager);

        workshopsRV.setAdapter(workshopsAdapter);

//        int firstVisibleItemPosition = ((LinearLayoutManager) workshopsRV.getLayoutManager()).findFirstVisibleItemPosition();
//        int secondVisibleItemPosition = firstVisibleItemPosition++;
//
//        RecyclerView.ViewHolder holder = workshopsRV.findViewHolderForAdapterPosition(1);
//
//        if (holder == null){
//            Log.d("HOLDER", "buildRecyclerView: NULL");
//        }
//                    Button regBtn = holder.itemView.findViewById(R.id.btn_register);
//                    regBtn.setVisibility(View.VISIBLE);
    }
}