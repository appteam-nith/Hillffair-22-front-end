package com.nith.hillfair2k22.screens.account;

import static com.nith.hillfair2k22.apis.New_User_VolleyHelper.userRead;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.nith.hillfair2k22.Models.NewUserList;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.apis.New_User_VolleyHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewProfileFragment extends Fragment {

    Button btnedit;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ViewProfileFragment() {
        // Required empty public constructor
    }
    ImageView img;
    TextView name;
    TextView rollno;
    TextView phoneno;
    TextView insta;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewProfileFragment newInstance(String param1, String param2) {
        ViewProfileFragment fragment = new ViewProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//        startActivity(new Intent(getActivity(),EditProfileActivity.class));
//        btnedit= getView().findViewById(R.id.btnedit);
//        btnedit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(),EditProfileActivity.class));
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FirebaseAuth auth;
        auth=FirebaseAuth.getInstance();
        View view  = inflater.inflate(R.layout.fragment_view_profile,container,false);
        img  = view.findViewById(R.id.imageView4);
        name = view.findViewById(R.id.fullname);
        phoneno=view.findViewById(R.id.phonenumber);
        rollno = view.findViewById(R.id.rollnumber);
        insta = view.findViewById(R.id.username);

        btnedit= view.findViewById(R.id.btnedit);
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),EditProfileActivity.class));
            }
        });

        New_User_VolleyHelper n1  = new New_User_VolleyHelper(getContext());
        n1.readUser(auth.getUid());
        final androidx.lifecycle.Observer<NewUserList> obs = new androidx.lifecycle.Observer<NewUserList>() {
            @Override
            public void onChanged(NewUserList newUserList) {
                Log.e("Nlis",String.valueOf(newUserList.getProfileImage()));
                Glide.with(getActivity()).load(newUserList.getProfileImage().replace("http","https")).into(img);
                name.setText(newUserList.getUsername());
                phoneno.setText(newUserList.getPhone());
                rollno.setText(newUserList.getEmail());
                insta.setText(newUserList.getInstagramId());
            }
        };
        userRead.observe(getActivity(),obs);
        return view;

        // return inflater.inflate(R.layout.fragment_view_profile, container, false);
    }
}