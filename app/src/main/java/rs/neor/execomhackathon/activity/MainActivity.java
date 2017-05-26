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

@EActivity
public class MainActivity extends AppCompatActivity {

    @ViewById
    GridView gridView;

    @Bean
    ItemForSaleAdapter itemForSaleAdapter;

    @Bean
    DatabaseHelper databaseHelper;

    @AfterViews
    void init(){

        try {
            List<ItemForSale> list = databaseHelper.getItemForSaleDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        gridView.setAdapter(itemForSaleAdapter);

    }
}
