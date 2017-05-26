package rs.neor.execomhackathon.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Radni on 26.05.2017.
 */

@DatabaseTable(tableName = User.TABLE_USER)
public class User {
    public static final String TABLE_USER = "item_for_sale";

    public static final String USER_FIELD_ID = "id";
    public static final String USER_FIELD_NAME = "name";

    @DatabaseField(columnName = USER_FIELD_ID, generatedId = true)
    private int id;
    @DatabaseField(columnName = USER_FIELD_NAME)
    private String name;

    @ForeignCollectionField(foreignFieldName = "user", eager = true)
    private ForeignCollection<ItemForSale> items;


    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ForeignCollection<ItemForSale> getItems() {
        return items;
    }

    public void setItems(ForeignCollection<ItemForSale> items) {
        this.items = items;
    }
}