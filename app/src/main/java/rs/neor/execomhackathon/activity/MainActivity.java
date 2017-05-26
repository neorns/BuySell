package rs.neor.execomhackathon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.sql.SQLException;
import java.util.List;

import rs.neor.execomhackathon.R;
import rs.neor.execomhackathon.adapter.ItemForSaleAdapter;
import rs.neor.execomhackathon.db.DatabaseHelper;
import rs.neor.execomhackathon.model.ItemForSale;

@EActivity(R.layout.activity_base)
public class MainActivity extends BaseActivity {

    @AfterViews
    void init(){

        gridView.setAdapter(itemForSaleAdapter);

    }
}
