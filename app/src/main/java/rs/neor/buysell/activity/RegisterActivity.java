package rs.neor.buysell.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import rs.neor.buysell.R;
import rs.neor.buysell.dao.UserDao;
import rs.neor.buysell.model.User;

import static rs.neor.buysell.tools.Tools.getSha1Hex;

@EActivity(R.layout.activity_register)
public class RegisterActivity extends AppCompatActivity {

    @Bean
    UserDao userDao;

    @ViewById
    EditText textEmail;
    @ViewById
    EditText textPassword;
    @ViewById
    EditText textName;
    @ViewById
    EditText textPhone;

    @Click
    void buttonRegister(){
        User user = new User();
        user.setEmail(textEmail.getText().toString());
        //only keep hashed password
        user.setPassword(getSha1Hex(textPassword.getText().toString()));
        user.setName(textName.getText().toString());
        user.setPhone(textPhone.getText().toString());

        userDao.insert(user);

        finish();
    }
    @Click
    void buttonCancel(){
        finish();
    }
}
