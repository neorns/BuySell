package rs.neor.execomhackathon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.androidannotations.annotations.EActivity;

import rs.neor.execomhackathon.R;

@EActivity
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
