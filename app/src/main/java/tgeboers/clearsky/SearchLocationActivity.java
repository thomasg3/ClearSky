package tgeboers.clearsky;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import java.util.logging.Level;
import java.util.logging.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;

public class SearchLocationActivity extends Activity {

    // Search location and save it in settings
    @BindView(R.id.tmp)
    TextView mTmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_location);
        ButterKnife.bind(this);
    }

    @OnTextChanged(R.id.query_box)
    public void onEditTextChanged(CharSequence s, int start, int count, int after){
        mTmp.setText(s);
    }
}
