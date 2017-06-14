package com.loftblog.layout_inflater_2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView resultText_Name;
    private TextView resultText_Phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // components from main.xml
        button = (Button) findViewById(R.id.button);
        resultText_Name = (TextView) findViewById(R.id.result_name);
        resultText_Phone = (TextView) findViewById(R.id.result_phone);




        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showInputDialog();
            }
        });



    }//end onCreate


    /*function showInputDialog() */
    protected void showInputDialog() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.inflater_dialog, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText_Name = (EditText) promptView.findViewById(R.id.edittext_Name);
        final EditText editText_Phone = (EditText) promptView.findViewById(R.id.edittext_Phone);

        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        resultText_Name.setText("Hello, " + editText_Name.getText());
                        resultText_Phone.setText("@"+ editText_Phone.getText()+"@");
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();




    }//end showInputDialog




}
