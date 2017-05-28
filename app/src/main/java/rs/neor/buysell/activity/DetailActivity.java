package rs.neor.buysell.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EViewGroup;
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
    @Extra
    boolean isMyItem;

    @ViewById
    TextView textName;
    @ViewById
    TextView textDescription;
    @ViewById
    TextView textPrice;
    @ViewById
    TextView textDate;
    @ViewById
    TextView textContactInfo;
    @ViewById
    Button buttonDelete;
    @ViewById
    SimpleDraweeView itemPhoto;

    @AfterViews
    void init(){
        textName.setText(itemForSale.getName());
        textDescription.setText(itemForSale.getDescription());
        textPrice.setText("$"+String.format("%1.2f",itemForSale.getPrice()));
        //textDate.setText(itemForSale.getDate().toString());
        textDate.setText("Item added: " + android.text.format.DateFormat.getDateFormat(getApplicationContext()).format(itemForSale.getDate()));

        textContactInfo.setText(itemForSale.getUser().toString());
        itemPhoto.setImageURI(itemForSale.getPhoto());

        if (isMyItem){
            buttonDelete.setVisibility(View.VISIBLE);
        }
        else {
            buttonDelete.setVisibility(View.INVISIBLE);
        }
    }

    @Click
    void buttonDelete(){
        itemForSaleDao.delete(itemForSale);
        finish();
    }
}
