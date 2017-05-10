package ismael.com.inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;

import ismael.com.inventory.fragments.ListProductFragment;
import ismael.com.inventory.fragments.ManageProductFragment;

public class MainActivity extends AppCompatActivity implements ListProductFragment.ListProductListener{

    public static final int ADD_PRODUCT_CODE = 1;

    private ListProductFragment listproduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            listproduct = ListProductFragment.newInstance(null);
            getSupportFragmentManager().beginTransaction().add(R.id.main_container, listproduct).commit();
        }
    }


    /*Se inicializa el fragment que permite añadir un product*/
    @Override
    public void onAddProductListener() {
        startActivityForResult(new Intent(MainActivity.this, ManageProductActivity.class), ADD_PRODUCT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
            listproduct.reset();
    }


}
