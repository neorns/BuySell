package rs.neor.buysell.model;

import android.net.Uri;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Radni on 26.05.2017.
 */

@DatabaseTable(tableName = ItemForSale.TABLE_ITEMFORSALE)
public class ItemForSale implements Serializable {
    public static final String TABLE_ITEMFORSALE = "itemforsale";

    public static final String ITEMFORSALE_FIELD_ID = "id";
    public static final String ITEMFORSALE_FIELD_NAME = "name";
    public static final String ITEMFORSALE_FIELD_DESCRIPTION = "description";
    public static final String ITEMFORSALE_FIELD_PRICE = "price";
    public static final String ITEMFORSALE_FIELD_DATE = "date";
    public static final String ITEMFORSALE_FIELD_USER = "user";
    public static final String ITEMFORSALE_FIELD_PHOTO = "photo";

    @DatabaseField(columnName = ITEMFORSALE_FIELD_ID, generatedId = true)
    private int id;
    @DatabaseField(columnName = ITEMFORSALE_FIELD_NAME)
    private String name;
    @DatabaseField(columnName = ITEMFORSALE_FIELD_DESCRIPTION)
    private String description;
    @DatabaseField(columnName = ITEMFORSALE_FIELD_PRICE)
    private BigDecimal price;
    @DatabaseField(columnName = ITEMFORSALE_FIELD_DATE)
    private Date date;
    @DatabaseField(columnName = ITEMFORSALE_FIELD_PHOTO)
    private String photo;

    public Uri getPhoto() {
        if (photo==null||photo==""){
            return null;
        }
        else {
            return Uri.parse(photo);
        }
    }

    public void setPhoto(Uri photo) {
        this.photo = photo.toString();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
