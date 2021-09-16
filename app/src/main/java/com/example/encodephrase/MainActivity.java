package com.example.encodephrase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt;
        EditText et;
        bt= findViewById(R.id.button);
        et=findViewById(R.id.editText);
       bt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String str=et.getText().toString();
               System.out.println(str);
              String result= encode( str);
               et.setText(result);
           }
       });
    }
    public String encode(String str){

         String StringEncodeLetters="";
            str=str.toLowerCase();
        //a-z 97-122 //Hi there
        for(int i=0;i<str.length();i++){

            int intEncodeLetter=0;
            if((int)str.charAt(i)>=97&&(int)str.charAt(i)<=122) {
                intEncodeLetter = (int) str.charAt(i) + 13;
                if (intEncodeLetter > 122) {
                    int temp = intEncodeLetter - 122-1;
                    intEncodeLetter = 97 + temp;
                }
                StringEncodeLetters = StringEncodeLetters + (char) intEncodeLetter;

            }//end of if((int)str.charAt(i)>=97&&(int)str.charAt(i)<=122)
            else{ //if it was a space or special character
                StringEncodeLetters = StringEncodeLetters +str.charAt(i);
            }
            System.out.println("StringEncodeLetters: "+StringEncodeLetters);
        }//end for loop
        System.out.println(StringEncodeLetters);


        return  StringEncodeLetters;
    }
}