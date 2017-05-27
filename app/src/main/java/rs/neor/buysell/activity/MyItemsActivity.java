package rs.neor.buysell.activity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import rs.neor.buysell.R;
import rs.neor.buysell.adapter.ItemForSaleAdapter;
import rs.neor.buysell.model.User;

@EActivity(R.layout.activity_my_items)
public class MyItemsActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private boolean twoColumns;

    @Extra
    User user;

    @ViewById
    GridView gridView;

    @Bean
    ItemForSaleAdapter itemForSaleAdapter;


    @AfterViews
    void init(){
        itemForSaleAdapter.setUser(user);
        setGridColumns();
        gridView.setAdapter(itemForSaleAdapter);

    }

    private void setGridColumns(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        twoColumns = sharedPreferences.getBoolean("two_columns", false);
        if (twoColumns) {
            if (gridView.getNumColumns()!=2){
                gridView.setNumColumns(2);
            }
        }
        else {
            if (gridView.getNumColumns()!=1) {
                gridView.setNumColumns(1);
            }
        }
    }

    // Called when fab button is clicked.
    @Click
    void fab() {
        CreateItemActivity_.intent(this).user(user).start();
    }
}
