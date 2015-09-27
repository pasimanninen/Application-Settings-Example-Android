package fi.ptm.applicationsettingsexample;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by pasi on 27/09/15.
 */
public class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {
    private final String KEY_PREF_EDITTEXT= "edittext_preference";
    private final String KEY_PREF_LIST= "list_preference";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.application_preferences);
    }

    @Override
    public void onStart() {
        super.onStart();
        // register preference change listener
        SharedPreferences sharedPreferences = getPreferenceManager().getSharedPreferences();
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        // show values
        Preference editTextPref = findPreference(KEY_PREF_EDITTEXT);
        editTextPref.setSummary(sharedPreferences.getString(KEY_PREF_EDITTEXT, ""));
        Preference listPref = findPreference(KEY_PREF_LIST);
        listPref.setSummary(sharedPreferences.getString(KEY_PREF_LIST, ""));
    }

    @Override
    public void onStop() {
        super.onStop();
        // unregister
        SharedPreferences sharedPreferences = getPreferenceManager().getSharedPreferences();
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setBackgroundColor(Color.WHITE);
    }

    // change text or list values in PreferenceActivity ("Screen/Page")
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPref, String key) {
        Log.d(">>APPLICATION SETTINGS", "key=" + key);
        // Edit Text
        if (key.equals(KEY_PREF_EDITTEXT)) {
            Preference editTextPref = findPreference(key);
            editTextPref.setSummary(sharedPref.getString(key, ""));
            // list value
        } else if (key.equals(KEY_PREF_LIST)) {
            Preference listPref = findPreference(key);
            listPref.setSummary(sharedPref.getString(key, ""));
        }

    }
}
