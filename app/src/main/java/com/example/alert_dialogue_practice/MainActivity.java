package com.example.alert_dialogue_practice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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


    }

    public void open(View view){

        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        alertdialog.setMessage("Do you want to visit the webView page?");

        alertdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent i = new Intent(MainActivity.this, nextPage.class);
                startActivity(i);
            }
        });

        alertdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Toast.makeText(getApplicationContext(),"closing application...",Toast.LENGTH_SHORT).show();

            }
        });
         AlertDialog altd = alertdialog.create();
         altd.show();
    }




//    public void open(View view){
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this); // for the alert dialog
//        alertDialogBuilder.setMessage("Are You Sure, You Want To Use Your Profile");
//
//        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent(getApplicationContext(), MainWebViewActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        alertDialogBuilder.setNegativeButton("no", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
////                finish();
//                Toast.makeText(getApplicationContext(),"do not resist",Toast.LENGTH_SHORT).show();
//            }
//        });
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
//    }

}