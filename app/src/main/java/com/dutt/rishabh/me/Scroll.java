package com.dutt.rishabh.me;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Scroll extends AppCompatActivity {
    DatabaseHelper db=new DatabaseHelper(this);
    private Handler handler=new Handler();
    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText a1,a2,a3,a4,a5,a6,a7,a8;
        spinner=(ProgressBar)findViewById(R.id.p1);
        a1=(EditText) findViewById(R.id.a1);
        a2=(EditText) findViewById(R.id.a2);
        a3=(EditText) findViewById(R.id.a3);
        a4=(EditText) findViewById(R.id.a4);
        a5=(EditText) findViewById(R.id.a5);
        a6=(EditText) findViewById(R.id.a6);
        a7=(EditText) findViewById(R.id.a7);
        a8=(EditText) findViewById(R.id.a8);
        Button a9=(Button) findViewById(R.id.a9);
        a9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean m;
                m=db.addData(a1.getText().toString(),a2.getText().toString(),a3.getText().toString(),a4.getText().toString(),a5.getText().toString(),a6.getText().toString(),a7.getText().toString(),a8.getText().toString());
                if(m){
                    Toast.makeText(Scroll.this,"Inserting....",Toast.LENGTH_SHORT).show();
                    Toast.makeText(Scroll.this,"The Data has been inserted!",Toast.LENGTH_SHORT).show();
                    spinner.setVisibility(View.VISIBLE);
                    handler.postDelayed(mTask,5000);

                }else{
                    Toast.makeText(Scroll.this,"The Data has not been inserted!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private Runnable mTask=new Runnable() {
        @Override
        public void run() {
            Intent k=new Intent(Scroll.this,MainActivity.class);
            startActivity(k);
        }
    };

}
