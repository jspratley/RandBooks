package com.example.jessica.randbooks;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
    public String[] titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadTitles();
        String name = pickBookTitle();
        TextView textView = new TextView(this);
        textView.setTextSize(40);

        textView.setText(name);


        setContentView(textView);
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
    public void loadTitles(){
        titles = new String[4];
        titles[0]="Treasure Island";
        titles[1]="Jane Eyre";
        titles[2]="Catch-22";
        titles[3]="Harry Potter and the Chamber of Secrets";
    }
    public String pickBookTitle(){
        int size = titles.length;
        int i = (int)(Math.random()*size);
        return titles[i];
    }
}
