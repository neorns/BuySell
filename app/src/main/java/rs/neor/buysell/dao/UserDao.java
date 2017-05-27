package rs.neor.buysell.dao;

import com.j256.ormlite.dao.Dao;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.sql.SQLException;
import java.util.List;

import rs.neor.buysell.db.DatabaseHelper;
import rs.neor.buysell.model.User;

import static rs.neor.buysell.model.User.USER_FIELD_EMAIL;
import static rs.neor.buysell.model.User.USER_FIELD_ID;

/**
 * Created by Radni on 26.05.2017.
 */

@EBean(scope = EBean.Scope.Singleton)
public class UserDao {

    Dao<User, Integer> dao;

    @Bean
    DatabaseHelper databaseHelper;

    @AfterInject
    public void init() {
        dao = databaseHelper.getUserDao();
    }

    public User getUser(String email, String password){
        List<User> userList;
        try {
            userList =  dao.queryForEq(USER_FIELD_EMAIL,email);
            if (userList.isEmpty()){
                return null;
            }
            else {
                return userList.get(0);
            }
        } catch (SQLException e) {
            return null;
        }
    }
    public User getUser(int id){
        List<User> userList;
        try {
            userList =  dao.queryForEq(USER_FIELD_ID,id);
            if (userList.isEmpty()){
                return null;
            }
            else {
                return userList.get(0);
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public void insert(User user){
        try {
            dao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
