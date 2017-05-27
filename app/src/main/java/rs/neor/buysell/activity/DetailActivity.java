package rs.neor.buysell.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import rs.neor.buysell.R;
import rs.neor.buysell.dao.ItemForSaleDao;
import rs.neor.buysell.model.ItemForSale;

@EActivity(R.layout.activity_detail)
public class DetailActivity extends AppCompatActivity {

    @Bean
    ItemForSaleDao itemForSaleDao;

    @Extra
    ItemForSale itemForSale;

    @ViewById
    TextView textName;
    @ViewById
    TextView textDescription;
    @ViewById
    TextView textPrice;
    @ViewById
    TextView textDate;

    @AfterViews
    void init(){
        textName.setText(itemForSale.getName());
        textDescription.setText(itemForSale.getDescription());
        textPrice.setText(String.format("%1.2f",itemForSale.getPrice()));
        textDate.setText(itemForSale.getDate().toString());
    }

    @Click
    void buttonDelete(){
        itemForSaleDao.delete(itemForSale);
    }
}
