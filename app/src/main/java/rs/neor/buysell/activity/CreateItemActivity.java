package rs.neor.buysell.activity;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import rs.neor.buysell.R;
import rs.neor.buysell.dao.ItemForSaleDao;
import rs.neor.buysell.model.ItemForSale;
import rs.neor.buysell.model.User;
import rs.neor.buysell.tools.Tools;

@EActivity(R.layout.activity_create_item)
public class CreateItemActivity extends AppCompatActivity {
    private static final int CHOOSE_PHOTO_CODE = 211;
    private static final int TAKE_PHOTO_CODE = 212;

    private Uri photoUri;

    @Bean
    ItemForSaleDao itemForSaleDao;

    @Extra
    User user;

    @ViewById
    EditText textName;
    @ViewById
    EditText textDescription;
    @ViewById
    EditText textPrice;
    @ViewById
    SimpleDraweeView itemPhoto;



    @Click
    void buttonCreate(){
        ItemForSale itemForSale = new ItemForSale();
        itemForSale.setName(textName.getText().toString());
        itemForSale.setDescription(textDescription.getText().toString());
        itemForSale.setDate(new Date());
        BigDecimal price;
        try {
            price = new BigDecimal(textPrice.getText().toString());
        } catch (NumberFormatException e){
            price = new BigDecimal(0);
        }
        itemForSale.setPrice(price);
        itemForSale.setUser(user);
        if (photoUri!=null) {
            itemForSale.setPhoto(photoUri);
        }

        itemForSaleDao.insert(itemForSale);
        finish();
    }
    @Click
    void buttonCancel(){
        finish();
    }

    @Click
    void buttonPhotoGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, CHOOSE_PHOTO_CODE);
    }
    @Click
    void buttonPhotoCamera(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = Tools.createImageFile(this);
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri uri = FileProvider.getUriForFile(this,
                        "rs.neor.buysell.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(takePictureIntent, TAKE_PHOTO_CODE);
                //save photoUri
                photoUri = uri;
            }
        }

    }

    @OnActivityResult(value = CHOOSE_PHOTO_CODE)
    void choosePhoto(int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            photoUri = data.getData();
            itemPhoto.setImageURI(photoUri);
        }

    }

    @OnActivityResult(value = TAKE_PHOTO_CODE)
    void takePhoto(int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            //photoUri = data.getData();
            //using saved photoUri
            itemPhoto.setImageURI(photoUri);
        }

    }
}
