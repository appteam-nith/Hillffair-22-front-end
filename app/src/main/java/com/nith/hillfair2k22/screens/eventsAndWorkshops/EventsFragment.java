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
import android.widget.Toast;

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
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        eventsRV = view.findViewById(R.id.events_RecV);
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

//        eventsRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                int firstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
//                int secondVisibleItemPosition = firstVisibleItemPosition + 1;
//                int thirdVisibleItemPosition = firstVisibleItemPosition + 2;
//
//
//                if (newState == RecyclerView.SCROLL_STATE_DRAGGING || newState == RecyclerView.SCROLL_STATE_SETTLING || newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    RecyclerView.ViewHolder holder1 = recyclerView.findViewHolderForAdapterPosition(firstVisibleItemPosition);
//                    Button regBtn1 = holder1.itemView.findViewById(R.id.btn_register);
//                    CardView itemCV1 = holder1.itemView.findViewById(R.id.events_RV_item_CV);
//                    regBtn1.setVisibility(View.GONE);
//                    itemCV1.setCardElevation(3);
//
//                    RecyclerView.ViewHolder holder2 = recyclerView.findViewHolderForAdapterPosition(secondVisibleItemPosition);
//                    Button regBtn2 = holder2.itemView.findViewById(R.id.btn_register);
//                    CardView itemCV2 = holder2.itemView.findViewById(R.id.events_RV_item_CV);
//                    regBtn2.setVisibility(View.VISIBLE);
//                    itemCV2.setCardElevation(500);
//
//
//                    RecyclerView.ViewHolder holder3 = recyclerView.findViewHolderForAdapterPosition(thirdVisibleItemPosition);
//                    Button regBtn3 = holder3.itemView.findViewById(R.id.btn_register);
//                    CardView itemCV3 = holder3.itemView.findViewById(R.id.events_RV_item_CV);
//                    regBtn3.setVisibility(View.GONE);
//                    itemCV3.setCardElevation(3);
//
//                    RecyclerView.ViewHolder holder4 = recyclerView.findViewHolderForAdapterPosition(secondVisibleItemPosition + 2);
//                    Button regBtn4 = holder4.itemView.findViewById(R.id.btn_register);
//                    CardView itemCV4 = holder4.itemView.findViewById(R.id.events_RV_item_CV);
//                    regBtn4.setVisibility(View.GONE);
//                    itemCV4.setCardElevation(3);
//                }
//
//
//            }
//        });
    }

    private void getEventData() {
        for (int i = 0; i < 9; i++) {
            eventsModalArrayList.add(new EventsModal("Treasure Hunt Event", "English Club", "04 April 2022", false));
        }
    }
}