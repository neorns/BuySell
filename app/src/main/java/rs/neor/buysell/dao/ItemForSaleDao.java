package rs.neor.buysell.dao;

import com.j256.ormlite.dao.Dao;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;

import java.sql.SQLException;
import java.util.List;

import rs.neor.buysell.model.ItemForSale;
import rs.neor.buysell.model.User;

import static rs.neor.buysell.db.DatabaseHelper.databaseHelper;

/**
 * Created by Radni on 26.05.2017.
 */

@EBean(scope = EBean.Scope.Singleton)
public class ItemForSaleDao {

    public interface RefreshData{
        void refresh();
    }
    private RefreshData allItems;

    public void setAllItems(RefreshData allItems) {
        this.allItems = allItems;
    }

    public void setMyItems(RefreshData myItems) {
        this.myItems = myItems;
    }

    private RefreshData myItems;

    //List<ItemForSale> itemForSaleList; ;
    Dao<ItemForSale, Integer> dao;


    @AfterInject
    public void init() {
        dao = databaseHelper.getItemForSaleDao();

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
                    list = dao.queryForEq(ItemForSale.ITEMFORSALE_FIELD_USER, user.getId());
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
            publish();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(ItemForSale itemForSale){
        try {
            dao.update(itemForSale);
            publish();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(ItemForSale itemForSale){
        try {
            dao.delete(itemForSale);
            publish();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void publish(){
        //notify adapters
        if (allItems !=null){ allItems.refresh();}
        if (myItems !=null){ myItems.refresh();}
    }
}
