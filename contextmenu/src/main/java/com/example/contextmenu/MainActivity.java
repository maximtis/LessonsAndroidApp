package com.example.contextmenu;

import android.drm.DrmManagerClient;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnCreateContextMenuListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnCreateContextMenuListener {

    final String MENU_COLOR_RED = "Red";
    final String MENU_COLOR_GREEN = "Green";
    final String MENU_COLOR_BLUE = "Blue";

    final String MENU_SIZE_22 = "4";
    final String MENU_SIZE_26 = "5";
    final String MENU_SIZE_30 = "6";

    TextView tvColor, tvSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvColor = (TextView) findViewById(R.id.tvColor);
        tvSize = (TextView) findViewById(R.id.tvSize);

        // для tvColor и tvSize необходимо создавать контекстное меню
        tvColor.setOnCreateContextMenuListener(this);
        tvSize.setOnCreateContextMenuListener(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.tvColor:
                getMenuInflater().inflate(R.menu.color_menu, menu);

                break;
            case R.id.tvSize:
                getMenuInflater().inflate(R.menu.size_menu, menu);
                break;
        }
    }
    final String TAG = "MyLog";
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Log.d(TAG, String.valueOf(item.getItemId()));
        Log.d(TAG,item.getTitle().toString());
        Log.d(TAG, String.valueOf(item.getItemId()));
        Log.d(TAG,item.getTitle().toString());
        Log.d(TAG, String.valueOf(item.getItemId()));
        Log.d(TAG,item.getTitle().toString());
        switch (item.getTitle().toString()) {
            // пункты меню для tvColor
            case MENU_COLOR_RED:
                Log.d(TAG, String.valueOf(item.getItemId()));
                Log.d(TAG,item.getTitle().toString());

                tvColor.setTextColor(Color.RED);
                tvColor.setText("Text color = red");
                break;
            case MENU_COLOR_GREEN:
                Log.d(TAG, String.valueOf(item.getItemId()));
                Log.d(TAG,item.getTitle().toString());
                tvColor.setTextColor(Color.GREEN);
                tvColor.setText("Text color = green");
                break;
            case MENU_COLOR_BLUE:
                Log.d(TAG, String.valueOf(item.getItemId()));
                Log.d(TAG,item.getTitle().toString());
                tvColor.setTextColor(Color.BLUE);
                tvColor.setText("Text color = blue");
                break;
            // пункты меню для tvSize
            case MENU_SIZE_22:
                tvSize.setTextSize(22);
                tvSize.setText("Text size = 22");
                break;
            case MENU_SIZE_26:
                tvSize.setTextSize(26);
                tvSize.setText("Text size = 26");
                break;
            case MENU_SIZE_30:
                tvSize.setTextSize(30);
                tvSize.setText("Text size = 30");
                break;
        }
        return super.onContextItemSelected(item);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
