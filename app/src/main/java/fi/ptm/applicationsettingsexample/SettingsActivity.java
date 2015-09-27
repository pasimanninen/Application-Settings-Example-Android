package fi.ptm.applicationsettingsexample;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by pasi on 27/09/15.
 */
public class SettingsActivity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // open a fragment to settings
        getFragmentManager().beginTransaction()
            .replace(android.R.id.content, new SettingsFragment())
            .commit();
    }
}
