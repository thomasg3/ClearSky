package tgeboers.clearsky;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    // Display location
    // Menu item to change location

    //TODO: background thread weather and generate notification

    @BindView(R.id.location_text)
    TextView mLocationTextView;
    @BindView(R.id.country_text)
    TextView mCountryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        startActivity(new Intent(this, SearchLocationActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        String locationName = getPreferences(Context.MODE_APPEND).getString("LOCATION_NAME", "");
        String locationCountry = getPreferences(Context.MODE_APPEND).getString("LOCATION_COUNTRY", "");
        if(TextUtils.isEmpty(locationName) || TextUtils.isEmpty(locationCountry)){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    String locationName = getPreferences(Context.MODE_APPEND).getString("LOCATION_NAME", "");
                    String locationCountry = getPreferences(Context.MODE_APPEND).getString("LOCATION_COUNTRY", "");
                    mLocationTextView.setText(locationName);
                    mCountryTextView.setText(locationCountry);
                }
            }, 2000);
        } else {
            mLocationTextView.setText(locationName);
            mCountryTextView.setText(locationCountry);
        }
    }
}
