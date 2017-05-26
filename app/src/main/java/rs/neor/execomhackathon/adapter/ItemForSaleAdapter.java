package rs.neor.execomhackathon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import rs.neor.execomhackathon.dao.ItemForSaleDao;
import rs.neor.execomhackathon.db.DatabaseHelper;
import rs.neor.execomhackathon.model.ItemForSale;

/**
 * Created by Radni on 26.05.2017.
 */

@EBean
public class ItemForSaleAdapter extends BaseAdapter {


    private List<ItemForSale> items = new ArrayList<>();

    private final LayoutInflater layoutInflater;

    private final Context context;

    public ItemForSaleAdapter( Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Bean
    ItemForSaleDao itemForSaleDao;

    @AfterInject
    void init(){
        items = itemForSaleDao.getItems(null);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
