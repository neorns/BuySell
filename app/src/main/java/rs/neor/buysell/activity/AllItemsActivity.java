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

import static rs.neor.buysell.activity.LoginActivity.EXTRA_USER_ID;


@OptionsMenu(R.menu.menu_all_items)
@EActivity(R.layout.activity_all_items)
public class AllItemsActivity extends AppCompatActivity {
    private User user=null;
    private static final int LOGIN_USER_CODE = 111;
    private static final int MY_ITEMS_CODE = 112;
    private static final int REGISTER_USER_CODE = 113;


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
    @OnActivityResult(value = LOGIN_USER_CODE)
    void loginSucceeded(int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }
        else {
            int userId = data.getIntExtra(EXTRA_USER_ID,-1);
            if (userId!=-1){
                user = userDao.getUser(userId);
            }
        }
    }
    @OnActivityResult(value = MY_ITEMS_CODE)
    void myItemsLoginSucceeded(int resultCode, Intent data) {
        loginSucceeded(resultCode,data);
        if (user!=null) {
            MyItemsActivity_.intent(this).user(user).start();
        }
    }

    @OptionsItem
    void myItems() {
        if (user==null){
            //login first than start activity in OnActivityResult
            LoginActivity_.intent(this).startForResult(MY_ITEMS_CODE);
        }
        else {
            MyItemsActivity_.intent(this).user(user).start();
        }

    }
    @OptionsItem
    void registerUser() {
        RegisterActivity_.intent(this).startForResult(REGISTER_USER_CODE);
    }

    @OptionsItem
    void loginUser() {
        LoginActivity_.intent(this).startForResult(LOGIN_USER_CODE);
    }

    @OptionsItem
    void logoutUser() {
        user=null;
    }
}
