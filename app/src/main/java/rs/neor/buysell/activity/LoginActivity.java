package rs.neor.buysell.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import rs.neor.buysell.R;
import rs.neor.buysell.dao.UserDao;
import rs.neor.buysell.model.User;

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {
    public static final String EXTRA_USER_ID = "user_id";
    @Bean
    UserDao userDao;

    @ViewById
    EditText textEmail;
    @ViewById
    EditText textPassword;

    @Click
    void buttonLogin(){
        User user = userDao.getUser(textEmail.getText().toString(),textPassword.getText().toString());
        if (user!=null){
            final Intent intent = new Intent();
            intent.putExtra(EXTRA_USER_ID,user.getId());
            setResult(RESULT_OK,intent);
        }
        else {
            setResult(RESULT_CANCELED);
        }
        finish();

    }
}
