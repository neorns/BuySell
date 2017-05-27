package rs.neor.buysell;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import org.androidannotations.annotations.EApplication;

import rs.neor.buysell.db.DatabaseHelper;

/**
 * Created by Radni on 27.05.2017.
 */

@EApplication
public class BuySellApplication extends Application {



    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseHelper.databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        Fresco.initialize(this);
    }


}
