package rs.neor.buysell.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.math.BigDecimal;
import java.util.Date;

import rs.neor.buysell.R;
import rs.neor.buysell.dao.ItemForSaleDao;
import rs.neor.buysell.model.ItemForSale;
import rs.neor.buysell.model.User;

@EActivity(R.layout.activity_create_item)
public class CreateItemActivity extends AppCompatActivity {

    @Bean
    ItemForSaleDao itemForSaleDao;

    @Extra
    User user;

    @ViewById
    EditText textName;
    @ViewById
    EditText textDescription;
    @ViewById
    EditText textPrice;



    @Click
    void buttonCreate(){
        ItemForSale itemForSale = new ItemForSale();
        itemForSale.setName(textName.getText().toString());
        itemForSale.setDescription(textDescription.getText().toString());
        itemForSale.setDate(new Date());
        BigDecimal price;
        try {
            price = new BigDecimal(textPrice.getText().toString());
        } catch (NumberFormatException e){
            price = new BigDecimal(0);
        }
        itemForSale.setPrice(price);
        itemForSale.setUser(user);

        itemForSaleDao.insert(itemForSale);
        finish();
    }
    @Click
    void buttonCancel(){
        finish();
    }
}
