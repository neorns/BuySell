package rs.neor.buysell.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Radni on 26.05.2017.
 */

@DatabaseTable(tableName = User.TABLE_USER)
public class User implements Serializable {
    public static final String TABLE_USER = "item_for_sale";

    public static final String USER_FIELD_ID = "id";
    public static final String USER_FIELD_EMAIL = "email";
    public static final String USER_FIELD_PASSWORD = "password";
    public static final String USER_FIELD_NAME = "name";
    public static final String USER_FIELD_PHONE = "phone";

    @DatabaseField(columnName = USER_FIELD_ID, generatedId = true)
    private int id;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @DatabaseField(columnName = USER_FIELD_EMAIL)
    private String email;

    @DatabaseField(columnName = USER_FIELD_PASSWORD)
    private String password;

    @DatabaseField(columnName = USER_FIELD_NAME)
    private String name;

    @DatabaseField(columnName = USER_FIELD_PHONE)
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ForeignCollectionField(foreignFieldName = "user", eager = true)
    private ForeignCollection<ItemForSale> items;


    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
