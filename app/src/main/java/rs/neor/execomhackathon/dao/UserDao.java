package rs.neor.execomhackathon.dao;

import com.j256.ormlite.dao.Dao;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.sql.SQLException;

import rs.neor.execomhackathon.db.DatabaseHelper;
import rs.neor.execomhackathon.model.User;

/**
 * Created by Radni on 26.05.2017.
 */

@EBean(scope = EBean.Scope.Singleton)
public class UserDao {




    @Bean
    DatabaseHelper databaseHelper;

    @AfterInject
    public void init() {


    }
}
