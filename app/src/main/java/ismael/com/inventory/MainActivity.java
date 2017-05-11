package ismael.com.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ismael.com.inventory.fragments.ListProductFragment;

public class MainActivity extends AppCompatActivity implements ListProductFragment.ListProductListener{

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
        startActivity(new Intent(MainActivity.this, ManageProductActivity.class));
    }



}
