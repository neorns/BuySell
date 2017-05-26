package rs.neor.execomhackathon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import rs.neor.execomhackathon.R;
import rs.neor.execomhackathon.adapter.ItemForSaleAdapter;
import rs.neor.execomhackathon.db.DatabaseHelper;

@EActivity(R.layout.activity_base)
public class BaseActivity extends AppCompatActivity {

    @ViewById
    GridView gridView;

    @Bean
    ItemForSaleAdapter itemForSaleAdapter;

    @Bean
    DatabaseHelper databaseHelper;

    @AfterViews
    void init(){



        gridView.setAdapter(itemForSaleAdapter);

    }
}
