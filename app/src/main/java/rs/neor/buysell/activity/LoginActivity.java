package rs.neor.buysell.activity;

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

    @Bean
    UserDao userDao;

    @ViewById
    EditText textEmail;
    @ViewById
    EditText textPassword;

    @Click
    void buttonLogin(){
        List<User> list;

    }
}
