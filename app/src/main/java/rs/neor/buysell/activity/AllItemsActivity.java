package rs.neor.buysell.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import rs.neor.buysell.R;
import rs.neor.buysell.adapter.ItemForSaleAdapter;
import rs.neor.buysell.dao.UserDao;
import rs.neor.buysell.model.User;

@OptionsMenu(R.menu.single_user)
@EActivity(R.layout.activity_all_items)
public class AllItemsActivity extends AppCompatActivity {
    private User user=null;
    private static final int USER_LOGIN_CODE = 111;


    @ViewById
    GridView gridView;

    @Bean
    ItemForSaleAdapter itemForSaleAdapter;
    @Bean
    UserDao userDao;

    @AfterViews
    void init(){

        gridView.setAdapter(itemForSaleAdapter);

    }

    @OnActivityResult(value = USER_LOGIN_CODE)
    void loginSucceeded(int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }
        else {
            int userId = data.getIntExtra("user_id",-1);
            if (userId!=-1){
                user = userDao.getUser(userId);
                MyItemsActivity_.intent(this).user(user).start();
            }
        }
    }
    @OptionsItem
    void myItems() {
        if (user==null){
            LoginActivity_.intent(this).startForResult(USER_LOGIN_CODE);
        }
        else {
            MyItemsActivity_.intent(this).user(user).start();
        }

    }
    @OptionsItem
    void loginUser() {
        LoginActivity_.intent(this).startForResult(USER_LOGIN_CODE);
    }
}
