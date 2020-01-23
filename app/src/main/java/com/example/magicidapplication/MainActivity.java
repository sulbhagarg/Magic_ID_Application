package com.example.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnSubmit;
    TextView TVResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID=findViewById(R.id.etID);
        btnSubmit=findViewById(R.id.btnSubmit);
        TVResult=findViewById(R.id.TVResult);

        TVResult.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idNumber = etID.getText().toString().trim();

                String dob1 = idNumber.substring(0, 6);

                String dob="";
                int count=0;
                for(int i=0;i<6;i++)
                {
                    if(count==2)
                    {
                        dob+="/"+dob1.charAt(i);
                        count=0;
                    }
                    else
                        dob+=dob1.charAt(i);
                    count++;
                }

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sGender;

                if(gender<5)
                    sGender="Female";
                else
                    sGender="Male";

                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String sNationality;
                if(nationality==0)
                    sNationality = "Indian Citizen";
                else
                    sNationality = "NRI";

                String text = getString(R.string.dob) +dob+ "\n" +
                        getString(R.string.gender) +sGender+ "\n" +
                        getString(R.string.nationality) +sNationality;

                TVResult.setText(text);

                TVResult.setVisibility(View.VISIBLE);
            }
        });
    }
}
