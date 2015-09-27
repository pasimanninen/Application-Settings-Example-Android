package fi.ptm.applicationsettingsexample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by pasi on 27/09/15.
 */
public class MainActivity extends Activity {
    private final int SHOW_PREFERENCES = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readAndShowValues();
    }

    // read values from shared preferences, display values in text view
    public void readAndShowValues() {
        // store settings
        String string = "";
        // get text view id
        TextView textView = (TextView) findViewById(R.id.textView2);
        // load preferences
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        // first checkbox
        boolean checked1 = sharedPref.getBoolean("checkbox_preference1", false);
        if (checked1) {
            string += "checkbox 1 checked\n";
        } else {
            string += "checkbox 1 not checked\n";
        }
        // second checkbox
        boolean checked2 = sharedPref.getBoolean("checkbox_preference2", false);
        if (checked2) {
            string += "checkbox 2 checked\n";
        } else {
            string += "checkbox 2 not checked\n";
        }
        // list, get country
        String country = sharedPref.getString("list_preference", "");
        string +="List : " + country + "\n";
        // edit text
        String text = sharedPref.getString("edittext_preference", "");
        string +="EditText : " + text;
        // show values
        textView.setText(string);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent i = new Intent(this, SettingsActivity.class);
                startActivityForResult(i, SHOW_PREFERENCES);
                return true;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        readAndShowValues();
    }

}
