package rs.neor.execomhackathon.dao;

import com.j256.ormlite.dao.Dao;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.sql.SQLException;
import java.util.List;

import rs.neor.execomhackathon.db.DatabaseHelper;
import rs.neor.execomhackathon.model.ItemForSale;

/**
 * Created by Radni on 26.05.2017.
 */

@EBean(scope = EBean.Scope.Singleton)
public class ItemForSaleDao {

    List<ItemForSale> list; ;

    @Bean
    DatabaseHelper databaseHelper;

    @AfterInject
    public void init() {

        list = getItems();

    }

    public List<ItemForSale> getItems(){
        List<ItemForSale> list = null;
        Dao<ItemForSale, Integer> dao;
        dao = databaseHelper.getItemForSaleDao();
        if (dao != null) {
            try {
                list = dao.queryForAll();
            } catch (SQLException e) {
                e.printStackTrace();
                list = null;
            }
        }
        return list;
    }

}
