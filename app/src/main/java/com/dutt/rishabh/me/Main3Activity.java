package com.dutt.rishabh.me;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    DatabaseHelper db = new DatabaseHelper(this);
    public static String[] info = new String[9];
    private Handler handler=new Handler();
    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        spinner=(ProgressBar)findViewById(R.id.p1);
        final EditText x = (EditText) findViewById(R.id.et9);
        Button btn1 = (Button) findViewById(R.id.btnshow);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = x.getText().toString();
                if (a.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter the field name!", Toast.LENGTH_SHORT).show();
                } else {
                    int id = Integer.parseInt(a);
                    Cursor m = db.view(id);
                    if (m.getCount() == 0) {
                        Toast.makeText(Main3Activity.this, "No Data for the Person found!", Toast.LENGTH_SHORT).show();
                    } else {
                        spinner.setVisibility(View.VISIBLE);
                        while(m.moveToNext()){
                            for(int i=0;i<info.length;i++){
                                info[i]=m.getString(i);
                            }
                            handler.postDelayed(mTask,4000);
                        }

                    }

                }
            }
        });
    }
    private Runnable mTask=new Runnable() {
        @Override
        public void run() {
            Intent j=new Intent(Main3Activity.this,Main2Activity.class);
            startActivity(j);
        }
    };

}