package edu.wit.mobileapp.checkedtextlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CheckedTextView ctv = (CheckedTextView) findViewById(R.id.ctv);
        ctv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckedTextView ctv = (CheckedTextView) v;
                if (ctv.isChecked())
                    ctv.setChecked(false);
                else
                    ctv.setChecked(true);
            }
        });
    }
}

