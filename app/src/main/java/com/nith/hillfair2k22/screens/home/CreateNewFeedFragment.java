package com.nith.hillfair2k22.screens.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.nith.hillfair2k22.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateNewFeedFragment#} factory method to
 * create an instance of this fragment.
 */
public class CreateNewFeedFragment extends AppCompatActivity {
    ImageView imgaeview1;
    ImageView imageview2;
    ImageView imageview3;
    int SELECT_PICTURE = 200;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters


    public CreateNewFeedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment CreateNewFeedFragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static CreateNewFeedFragment newInstance(String param1, String param2) {
//        CreateNewFeedFragment fragment = new CreateNewFeedFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_create_new_feed, container, false);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_create_new_feed);
        imgaeview1=findViewById(R.id.btn_user_post_image);
        imgaeview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CreateNewFeedFragment.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        imageview2= findViewById(R.id.user_post_back_icon);
        imageview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imageview3=findViewById(R.id.user_post_image_upload);
        imageview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();

            }

        });

    }

    void imageChooser(){
//        Intent i = new Intent(Intent.ACTION_PICK,
//                android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
//        final int ACTIVITY_SELECT_IMAGE = 1234;
//        startActivityForResult(i, ACTIVITY_SELECT_IMAGE);
        Intent i=new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i,"Select Picture"),SELECT_PICTURE);
    }
    public void onActivityResult(int requestCode,int resultCode,Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(resultCode==SELECT_PICTURE){
                Uri selectedImageUri=data.getData();
                if(null!=selectedImageUri){
                    imageview3.setImageURI(selectedImageUri);
                }
            }
        }
    }


}