package com.nith.hillfair2k22.screens.account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nith.hillfair2k22.MainActivity;
import com.nith.hillfair2k22.R;

public class EditProfileActivity extends AppCompatActivity {
    Button btnsave;
    EditText etName,etRN,etPhoneNumber,etInstaID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        btnsave=findViewById(R.id.btnsave);
        etName=findViewById(R.id.etName);
        etPhoneNumber=findViewById(R.id.etPhoneNumber);
        etRN=findViewById(R.id.etRN);
        etInstaID=findViewById(R.id.etInstaId);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtName=etName.getText().toString();
                String txtPhoneNumber=etPhoneNumber.getText().toString();
                String txtRn=etRN.getText().toString();
                String txtInstaID=etInstaID.getText().toString();
                if(TextUtils.isEmpty(txtName)){
                    etName.setError("Empty");

                }else if(TextUtils.isEmpty(txtRn)){
                    etRN.setError("Empty");

                }else if(TextUtils.isEmpty(txtPhoneNumber)){
                    etPhoneNumber.setError("Empty");
                }else{
                    startActivity(new Intent(EditProfileActivity.this, MainActivity.class));
                }
            }
        });
    }
}