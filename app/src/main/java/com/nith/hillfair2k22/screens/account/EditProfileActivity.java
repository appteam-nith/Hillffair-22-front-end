package com.nith.hillfair2k22.screens.account;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.ErrorInfo;
import com.cloudinary.android.callback.UploadCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.nith.hillfair2k22.MainActivity;
import com.nith.hillfair2k22.Models.NewUserList;
import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.apis.New_User_VolleyHelper;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class EditProfileActivity extends AppCompatActivity {
    Button btnsave;
    EditText etName,etRN,etPhoneNumber,etInstaID;
    ImageView image;
    FirebaseAuth auth;
    Uri filepath;
    long sizeOfImage;
    Bitmap bitmap;
    byte[] bytesofimage;
    String encodedimg;
    String picUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        btnsave=findViewById(R.id.btnsave);
        etName=findViewById(R.id.etName);
        etPhoneNumber=findViewById(R.id.etPhoneNumber);
        etRN=findViewById(R.id.etRN);
        etInstaID=findViewById(R.id.etInstaId);
        auth=FirebaseAuth.getInstance();
        image=findViewById(R.id.imageView3);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(EditProfileActivity.this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE).withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        Intent intent =new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(Intent.createChooser(intent,"browse image"),1);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
            }
        });


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
                    NewUserList user=new NewUserList(auth.getUid(),txtName,txtPhoneNumber,txtRn,0,txtInstaID,picUrl);
                    New_User_VolleyHelper User=new New_User_VolleyHelper(EditProfileActivity.this);
                    User.postUser(user);
                    startActivity(new Intent(EditProfileActivity.this, MainActivity.class));
                }
            }
        });
        initConfig();
    }

    private void initConfig() {
        Map config = new HashMap();
        config.put("cloud_name", "dfinmhios");
        config.put("api_key","981293366339261");
        config.put("api_secret","tknXky4p8K5bRT6Aws_xnAnlAFg");
        //  config.put("secure", true);
        MediaManager.init(this, config);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1&&resultCode==RESULT_OK){
            filepath = data.getData();
            try{
                InputStream inputStream =getContentResolver().openInputStream(filepath);
                bitmap = BitmapFactory.decodeStream(inputStream);


                encodeBitmapimage(bitmap);
                sizeOfImage = bytesofimage.length;
                if(sizeOfImage/1024 > 1000){
                    Toast.makeText(this, "Image size more than 10MB", Toast.LENGTH_LONG).show();

                }else{
                    image.setImageBitmap(bitmap);
                    MediaManager.get().upload(filepath).callback(new UploadCallback() {
                        @Override
                        public void onStart(String requestId) {

                        }

                        @Override
                        public void onProgress(String requestId, long bytes, long totalBytes) {

                        }

                        @Override
                        public void onSuccess(String requestId, Map resultData) {
                            picUrl = resultData.get("url").toString();
                            Log.e("Data",picUrl);
                        }

                        @Override
                        public void onError(String requestId, ErrorInfo error) {

                        }

                        @Override
                        public void onReschedule(String requestId, ErrorInfo error) {

                        }
                    }).dispatch();

                }
                //img.setImageBitmap(bitmap);
            }
            catch (Exception e){

            }
        }
        else{
            Toast.makeText(this, "You haven't picked Image",
                    Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void encodeBitmapimage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        bytesofimage =byteArrayOutputStream.toByteArray();

        encodedimg = Base64.encodeToString(bytesofimage, Base64.DEFAULT);
    }
}