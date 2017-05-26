package rs.neor.execomhackathon.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Radni on 26.05.2017.
 */

@DatabaseTable(tableName = ItemForSale.TABLE_ITEMFORSALE)
public class ItemForSale {
    public static final String TABLE_ITEMFORSALE = "item_for_sale";

    public static final String ITEMFORSALE_FIELD_ID = "id";
    public static final String ITEMFORSALE_FIELD_NAME = "name";
    public static final String ITEMFORSALE_FIELD_DESCRIPTION = "description";
    public static final String ITEMFORSALE_FIELD_USER = "user";

    @DatabaseField(columnName = ITEMFORSALE_FIELD_ID, generatedId = true)
    private int id;
    @DatabaseField(columnName = ITEMFORSALE_FIELD_NAME)
    private String name;
    @DatabaseField(columnName = ITEMFORSALE_FIELD_DESCRIPTION)
    private String description;


    @DatabaseField(columnName = ITEMFORSALE_FIELD_USER, foreign = true, foreignAutoRefresh = true, canBeNull = false)
    private User user;


    public ItemForSale() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
