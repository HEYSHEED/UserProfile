package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        Button saveInformationButton=findViewById(R.id.btn_main_save);
        saveInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast= Toast.makeText(MainActivity.this, "User Clicked on Save Information Button", Toast.LENGTH_SHORT);
                toast.show();
            }

        });
        CheckBox androidSkillcheckbox=findViewById(R.id.checkBox_main_android);
        androidSkillcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Android Skill is checked", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Android Skill is not checked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        CheckBox uiCheckBox=findViewById(R.id.checkBox8_main_ui);
        uiCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "UI Design is checked", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this, "UI Design is not checked", Toast.LENGTH_SHORT).show();

                }
            }
        });
        CheckBox deepLearningCheckBox=findViewById(R.id.checkBox9_main_deep);
        deepLearningCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Deep Learning is checked", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Deep Learning is not checked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        RadioGroup radioGroup = findViewById(R.id.group1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio) {
                    Toast.makeText(MainActivity.this, "ON - Toronto is checked", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radio1) {
                    Toast.makeText(MainActivity.this, "BC - Vancouver is checked", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radio2) { // Use else if for additional conditions
                    Toast.makeText(MainActivity.this, "QC - Montreal is checked", Toast.LENGTH_SHORT).show();
                }
            }
        });
Button editProfileBtn=findViewById(R.id.btn_main_editProfile);
editProfileBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this,EditProfile.class);
        TextView fullNameTv=findViewById(R.id.tv_main_fullName);
        intent.putExtra("fullName", fullNameTv.getText());
        startActivityForResult(intent,1001);

    }
});
Button viewWebsiteBtn=findViewById(R.id.btn_main_viewWebsite);
viewWebsiteBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/"));
        startActivity(intent);
    }
});
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data); // Call to the superclass

        if (requestCode == 1001 && resultCode == MainActivity.RESULT_OK && data != null) {
            String fullName = data.getStringExtra("fullName");
            TextView textView = findViewById(R.id.tv_main_fullName);
            textView.setText(fullName);
        }
    }

}