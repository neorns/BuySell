package rs.neor.execomhackathon.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import org.androidannotations.annotations.EBean;

import java.sql.SQLException;

import rs.neor.execomhackathon.model.ItemForSale;
import rs.neor.execomhackathon.model.User;

/**
 * Created by Radni on 26.05.2017.
 */

@EBean(scope = EBean.Scope.Singleton)
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME    = "execomhackathon.db";
    private static final int    DATABASE_VERSION = 1;

    private Dao<ItemForSale, Integer> internalItemForSaleDao = null;
    private Dao<User, Integer> internalUserDao = null;

    //obavezan konstruktor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, ItemForSale.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, ItemForSale.class, true);
            TableUtils.dropTable(connectionSource, User.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //Dao objekat za svaku tabelu
    public Dao<ItemForSale, Integer> getItemForSaleDao() {
        if (internalItemForSaleDao == null) {
            try {
                internalItemForSaleDao = getDao(ItemForSale.class);
            } catch (SQLException e) {
                e.printStackTrace();
                internalItemForSaleDao = null;
            }
        }

        return internalItemForSaleDao;
    }
    public Dao<User, Integer> getUserDao()  {
        if (internalUserDao == null) {
            try {
                internalUserDao = getDao(User.class);
            } catch (SQLException e) {
                e.printStackTrace();
                internalUserDao = null;
            }
        }

        return internalUserDao;
    }

    @Override
    public void close() {
        internalItemForSaleDao = null;
        internalUserDao = null;

        super.close();
    }


}



