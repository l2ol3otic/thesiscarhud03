package com.thesis.carhud.carhudb03;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar mActionBar = getActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);


        View mCustomView = mInflater.inflate(R.layout.actionbarcustum, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("My Own Title");

        ImageButton imageButton = (ImageButton) mCustomView
        .findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Refresh Clicked!",
                        Toast.LENGTH_LONG).show();

            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        final ImageButton imgbtn = (ImageButton) findViewById(R.id.imb1);
        imgbtn.setImageResource(R.drawable.clock);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Clock", "Check");
                Intent intent = new Intent(MainActivity.this,ClockPage.class);
                startActivity(intent);
            }
        });

        //ปุ่ม2
        final ImageButton imgbtn1 = (ImageButton) findViewById(R.id.imb2);
        imgbtn1.setImageResource(R.drawable.music);
        imgbtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Music", "Check");
                Intent intent = new Intent(MainActivity.this,MusicPage.class);
                startActivity(intent);
            }
        });


        final ImageButton imgbtn2 = (ImageButton) findViewById(R.id.imb3);
        imgbtn2.setImageResource(R.drawable.map);
        imgbtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Map", "Check");
                Intent intent = new Intent(MainActivity.this,MapPage.class);
                startActivity(intent);
            }
        });


        final ImageButton imgbtn3 = (ImageButton) findViewById(R.id.imb4);
        imgbtn3.setImageResource(R.drawable.setting);
        imgbtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Setting", "Check");
                Intent intent = new Intent(MainActivity.this,CallPage.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
