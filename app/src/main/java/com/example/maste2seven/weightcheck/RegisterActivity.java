package com.example.maste2seven.weightcheck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by User on 10/2/2016.
 */
public class RegisterActivity extends AppCompatActivity {
    //explicit
    private EditText userText,passwordText, nameText;
    private String userString,passwordString, nameString;


    protected void onCreate(Bundle saveInstanceState) {

            super.onCreate(saveInstanceState);
            setContentView(R.layout.activity_register);

        //bind widget

        bindWidget();


    }//main method
    private void bindWidget() {
        userText = (EditText) findViewById(R.id.editText);
        passwordText = (EditText) findViewById(R.id.editText2);
        nameText = (EditText) findViewById(R.id.editText3);

    }

    public void clcikRegist(View view) {

        userString = userText.getText().toString().trim();
        passwordString = passwordText.getText().toString().trim();
        nameString = nameText.getText().toString().trim();

        if (userString.equals("")  || passwordString.equals("")  || nameString.equals("")) {

            //have space
            Toast.makeText(RegisterActivity.this,getResources().getString(R.string.have_space),
                    Toast.LENGTH_SHORT).show();

        } else {

            //no have space
            MyManage objMyManage = new MyManage(this);
            objMyManage.addUserTable(userString, passwordString, nameString);
            Toast.makeText(RegisterActivity.this,
                    getResources().getString(R.string.success_regis),
                    Toast.LENGTH_SHORT).show();


        }  //if else statedment

    }//clickregist
}//main class
