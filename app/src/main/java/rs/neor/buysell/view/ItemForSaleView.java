package rs.neor.buysell.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import rs.neor.buysell.R;
import rs.neor.buysell.model.ItemForSale;

/**
 * Created by Radni on 27.05.2017.
 */
@EViewGroup(R.layout.grid_item)
public class ItemForSaleView extends LinearLayout {
    @ViewById
    TextView itemName;

    public ItemForSaleView(Context context) {
        super(context);
    }

    public void bind(ItemForSale itemForSale) {
        itemName.setText(itemForSale.getName());

    }
}
