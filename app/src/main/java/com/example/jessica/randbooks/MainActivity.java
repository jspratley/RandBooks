package com.example.jessica.randbooks;
import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends Activity {
    public ArrayList<String> titles;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titles = new ArrayList<String>();
        loadTitles();
        final TextView textView = new TextView(this);
        textView.setTextSize(40);
        final EditText textBox = new EditText(this);


        setContentView(textBox);

        setContentView(textView);
        Button addButton = (Button)this.findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titles.add(textBox.getText().toString());
            }
        });
        setContentView(addButton);
        Button pickButton = (Button)this.findViewById(R.id.pick);
        pickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = pickBookTitle();
                textView.setText(name);
                setContentView(textView);
            }
        });
        setContentView(addButton);
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
        titles.add("Treasure Island");
        titles.add("Jane Eyre");
        titles.add("Catch-22");
        titles.add("Harry Potter and the Chamber of Secret");

    }
    public String pickBookTitle(){
        int lsize = titles.size();
        int i = (int)(Math.random()*lsize);
        return titles.get(i);
    }
}
