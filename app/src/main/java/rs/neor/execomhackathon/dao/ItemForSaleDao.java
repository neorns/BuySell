package rs.neor.execomhackathon.dao;

import com.j256.ormlite.dao.Dao;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.sql.SQLException;
import java.util.List;

import rs.neor.execomhackathon.db.DatabaseHelper;
import rs.neor.execomhackathon.model.ItemForSale;
import rs.neor.execomhackathon.model.User;

/**
 * Created by Radni on 26.05.2017.
 */

@EBean(scope = EBean.Scope.Singleton)
public class ItemForSaleDao {

    List<ItemForSale> itemForSaleList; ;

    @Bean
    DatabaseHelper databaseHelper;

    @AfterInject
    public void init() {

        itemForSaleList = getItems(null);

    }

    public List<ItemForSale> getItems(User user){
        List<ItemForSale> list = null;
        Dao<ItemForSale, Integer> dao = databaseHelper.getItemForSaleDao();
        if (dao != null) {
            try {
                if (user==null){
                    //items from all users
                    list = dao.queryForAll();
                }
                else {
                    //items from one user
                    list = dao.queryForEq(user.USER_FIELD_ID, user.getId());
                }
            } catch (SQLException e) {
                e.printStackTrace();
                list = null;
            }
        }
        return list;
    }

}
