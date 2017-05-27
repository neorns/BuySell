package rs.neor.buysell.activity;

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
    @Extra
    User user;

    @ViewById
    GridView gridView;

    @Bean
    ItemForSaleAdapter itemForSaleAdapter;


    @AfterViews
    void init(){

        gridView.setAdapter(itemForSaleAdapter);

    }

    /**
     * Called when button with id=fab is clicked.
     */
    @Click
    void fab() {
        CreateItemActivity_.intent(this).user(user).start();
    }
}
