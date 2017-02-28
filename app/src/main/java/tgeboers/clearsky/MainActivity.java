package tgeboers.clearsky;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    // Display location
    // Menu item to change location

    //TODO: background thread weather and generate notification

    @BindView(R.id.location_text)
    TextView mLocationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mLocationTextView.setText("Bierbeek, BE");

        startActivity(new Intent(this, SearchLocationActivity.class));

    }
}
