package tgeboers.clearsky;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tgeboers.clearsky.data.AccuWeatherLocation;
import tgeboers.clearsky.services.AccuWeatherService;
import tgeboers.clearsky.services.ServiceFactory;

public class SearchLocationActivity extends Activity {

    // Search location and save it in settings
    @BindView(R.id.list)
    ListView mList;

    private AccuWeatherService mAccuWeatherService;
    private AccuWeatherLocationAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_location);
        ButterKnife.bind(this);
        if(mAccuWeatherService == null)
            mAccuWeatherService = (new ServiceFactory()).createAccuWeatherService();

        mListAdapter = new AccuWeatherLocationAdapter(this, R.layout.activity_search_location);
        mList.setAdapter(mListAdapter);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AccuWeatherLocation selectedItem = mListAdapter.getItem(position);
                getPreferences(Context.MODE_APPEND).edit()
                        .putString("LOCATION_KEY", selectedItem.getKey())
                        .putString("LOCATION_NAME", selectedItem.getLocalizedName())
                        .putString("LOCATION_COUNTRY", selectedItem.getCountry().getLocalizedName())
                        .commit();
                finish();
            }
        });

    }

    @OnTextChanged(R.id.query_box)
    public void onEditTextChanged(CharSequence s, int start, int count, int after){
        mAccuWeatherService.autocompleteLocations(s.toString()).enqueue(new Callback<List<AccuWeatherLocation>>() {
            @Override
            public void onResponse(Call<List<AccuWeatherLocation>> call, Response<List<AccuWeatherLocation>> response) {
                mListAdapter.updateAccuWeatherLocations(response.body());
            }

            @Override
            public void onFailure(Call<List<AccuWeatherLocation>> call, Throwable t) {

            }
        });
    }

    private class AccuWeatherLocationAdapter extends ArrayAdapter<AccuWeatherLocation> {
        public void updateAccuWeatherLocations(List<AccuWeatherLocation> accuWeatherLocations){
            this.clear();
            this.addAll(accuWeatherLocations);
            this.notifyDataSetChanged();
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_accuweatherlocation, null);
            }
            AccuWeatherLocation accuWeatherLocation = getItem(position);
            if(accuWeatherLocation != null){
                TextView locationTextView = (TextView) convertView.findViewById(R.id.location_text);
                TextView countryTextView = (TextView) convertView.findViewById(R.id.country_text);

                locationTextView.setText(accuWeatherLocation.getLocalizedName());
                if(accuWeatherLocation.getCountry() != null){
                    countryTextView.setText(accuWeatherLocation.getCountry().getLocalizedName());
                }

            }
            return convertView;
        }

        public AccuWeatherLocationAdapter(Context context, int resource) {
            super(context, resource);
        }

        public AccuWeatherLocationAdapter(Context context, int resource, int textViewResourceId) {
            super(context, resource, textViewResourceId);
        }

        public AccuWeatherLocationAdapter(Context context, int resource, AccuWeatherLocation[] objects) {
            super(context, resource, objects);
        }

        public AccuWeatherLocationAdapter(Context context, int resource, int textViewResourceId, AccuWeatherLocation[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        public AccuWeatherLocationAdapter(Context context, int resource, List<AccuWeatherLocation> objects) {
            super(context, resource, objects);
        }

        public AccuWeatherLocationAdapter(Context context, int resource, int textViewResourceId, List<AccuWeatherLocation> objects) {
            super(context, resource, textViewResourceId, objects);
        }
    }
}
