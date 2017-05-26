package rs.neor.execomhackathon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import rs.neor.execomhackathon.R;

@EActivity(R.layout.activity_base)
public class SingleUserActivity  extends BaseActivity {

    @AfterViews
    void init(){

        gridView.setAdapter(itemForSaleAdapter);

    }
}
