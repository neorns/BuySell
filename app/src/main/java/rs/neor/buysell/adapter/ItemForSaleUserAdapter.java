package rs.neor.buysell.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

import rs.neor.buysell.dao.ItemForSaleDao;
import rs.neor.buysell.model.ItemForSale;
import rs.neor.buysell.model.User;
import rs.neor.buysell.view.ItemForSaleView;
import rs.neor.buysell.view.ItemForSaleView_;

/**
 * Created by Radni on 26.05.2017.
 */

@EBean
public class ItemForSaleUserAdapter extends BaseAdapter implements ItemForSaleDao.RefreshData {

    private User user = null;
    private List<ItemForSale> items = new ArrayList<>();

    //private final LayoutInflater layoutInflater;

    private final Context context;

    public ItemForSaleUserAdapter(Context context) {
        this.context = context;
        //this.layoutInflater = LayoutInflater.from(context);
    }

    @Bean
    ItemForSaleDao itemForSaleDao;


    @AfterInject
    public void init(){
        itemForSaleDao.setMyItems(this);
        items = itemForSaleDao.getItems(user);
    }

    public void setUser(User user) {
        this.user = user;
        items = itemForSaleDao.getItems(user);
    }

    @Override
    public int getCount() {
        if (items==null){
            return 0;
        }
        else {
            return items.size();
        }
    }

    @Override
    public ItemForSale getItem(int position) {

        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ItemForSaleView itemForSaleView;

        if (convertView == null) {  // if view item is not created
            itemForSaleView = ItemForSaleView_.build(context);
        } else {    // if view item was already created
            itemForSaleView = (ItemForSaleView_) convertView;
        }

        // bind data to view
        itemForSaleView.bind(getItem(position));

        return itemForSaleView;

    }


    public void refresh () {
        items = itemForSaleDao.getItems(user);
        notifyDataSetChanged();
    }
}
