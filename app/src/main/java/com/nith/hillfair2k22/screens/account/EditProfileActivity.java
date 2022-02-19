package com.nith.hillfair2k22.screens.account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nith.hillfair2k22.MainActivity;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.entities.UserProfile;
import com.nith.hillfair2k22.screens.home.UserFeedFragment;

public class EditProfileActivity extends AppCompatActivity {
    private UserProfile User = new UserProfile("Name", "00", "1234567890", "unknown");
    private String name;
    private String rollNO;
    private String phoneNo;
    private String instaID;
    private Button btnSave;
    FirebaseAuth auth;
    EditText inputName, inputRollNo, inputPhoneNumber, inputInstaID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        inputName = findViewById(R.id.etName);
        inputRollNo = findViewById(R.id.etRN);
        inputPhoneNumber = findViewById(R.id.etPhoneNumber);
        inputInstaID = findViewById(R.id.etInstaId);
        btnSave = findViewById(R.id.btnsave);
        auth=FirebaseAuth.getInstance();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=inputName.getText().toString().trim();
                rollNO=inputRollNo.getText().toString().trim();
                instaID=inputInstaID.getText().toString().trim();
                phoneNo=inputPhoneNumber.getText().toString().trim();

                startActivity(new Intent(EditProfileActivity.this, UserFeedFragment.class));
            }
        });

        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            inputName.setText(User.getName());
            inputRollNo.setText(User.getRollNO());
            inputPhoneNumber.setText(User.getPhoneNo());
            inputInstaID.setText(User.getInstaID());
            btnSave.setText("Edit Profile");
        }

    }
}