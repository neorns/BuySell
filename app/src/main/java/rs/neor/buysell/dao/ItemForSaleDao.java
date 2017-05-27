package rs.neor.buysell.dao;

import com.j256.ormlite.dao.Dao;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.sql.SQLException;
import java.util.List;

import rs.neor.buysell.db.DatabaseHelper;
import rs.neor.buysell.model.ItemForSale;
import rs.neor.buysell.model.User;

/**
 * Created by Radni on 26.05.2017.
 */

@EBean(scope = EBean.Scope.Singleton)
public class ItemForSaleDao {

    List<ItemForSale> itemForSaleList; ;
    Dao<ItemForSale, Integer> dao;
    @Bean
    DatabaseHelper databaseHelper;

    @AfterInject
    public void init() {
        dao = databaseHelper.getItemForSaleDao();
        itemForSaleList = getItems(null);
    }

    public List<ItemForSale> getItems(User user){
        List<ItemForSale> list = null;
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

    public void insert(ItemForSale itemForSale){
        try {
            dao.create(itemForSale);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(ItemForSale itemForSale){
        try {
            dao.update(itemForSale);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(ItemForSale itemForSale){
        try {
            dao.delete(itemForSale);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
