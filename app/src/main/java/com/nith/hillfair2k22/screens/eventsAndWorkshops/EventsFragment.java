package com.nith.hillfair2k22.screens.eventsAndWorkshops;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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

public class EventsFragment extends Fragment {

    private RecyclerView eventsRV;

    private EventsAdapter eventsAdapter;
    private ArrayList<EventsModal> eventsModalArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_events, container, false);

        eventsRV =view.findViewById(R.id.events_RecV);
        eventsModalArrayList = new ArrayList<>();


        getEventData();

        buildRecyclerView();

        return view;
    }

    private void buildRecyclerView() {

        eventsAdapter = new EventsAdapter(eventsModalArrayList, getActivity());

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        eventsRV.setHasFixedSize(true);

        eventsRV.setLayoutManager(manager);

        eventsRV.setAdapter(eventsAdapter);

        eventsRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                    int firstVisibleItemPosition = ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                    int secondVisibleItemPosition = firstVisibleItemPosition + 1;
                    int thirdVisibleItemPosition = firstVisibleItemPosition +2;

                    RecyclerView.ViewHolder holder = recyclerView.findViewHolderForAdapterPosition(secondVisibleItemPosition);
                    Button regBtn = holder.itemView.findViewById(R.id.btn_register);
                    CardView itemCV = holder.itemView.findViewById(R.id.events_RV_item_CV);

//                    EventsModal eventsModal = eventsModalArrayList.get(firstVisibleItemPosition);
                    regBtn.setVisibility(View.VISIBLE);
                    itemCV.setElevation(50);





            }
        });
    }

    private void getEventData() {
        for (int i=0;i<9; i++){
            eventsModalArrayList.add(new EventsModal("E_Title"+i,"E_club"+i,"E_date"+i,false));
        }
    }
}