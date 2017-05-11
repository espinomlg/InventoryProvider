package ismael.com.inventory;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import ismael.com.inventory.DB.DatabaseContract;
import ismael.com.inventory.adapters.MySimpleCursorAdapter;
import ismael.com.inventory.interfaces.ManageProductPresenter;
import ismael.com.inventory.models.Product;
import ismael.com.inventory.presenter.ManageProductPresenterImpl;

/**
 * Created by espino on 10/05/17.
 */

public class ManageProductActivity extends AppCompatActivity implements ManageProductPresenter.View {


    private TextInputLayout serial, shortname, description;
    private Spinner category, subcategory, productclass;
    private Button action;

    private ManageProductPresenter presenter;
    private MySimpleCursorAdapter categoryAdapter, subcategoryAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_addproduct);

        inflate();

        presenter = new ManageProductPresenterImpl(this);
        categoryAdapter = new MySimpleCursorAdapter(getContext(),android.R.layout.simple_spinner_item, null,
                new String[]{DatabaseContract.CategoryEntry.COLUMN_NAME},
                new int[]{android.R.id.text1},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        subcategoryAdapter = new MySimpleCursorAdapter(getContext(),android.R.layout.simple_spinner_item, null,
                new String[]{DatabaseContract.SubCategoryEntry.COLUMN_NAME},
                new int[]{android.R.id.text1},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);


        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle args = new Bundle();
                args.putString("id", categoryAdapter.getItem(i));
                presenter.getAllSubcategories(getSupportLoaderManager(), args);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        category.setAdapter(categoryAdapter);
        subcategory.setAdapter(subcategoryAdapter);
        productclass.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                android.R.id.text1,
                getResources().getStringArray(R.array.productclass)));

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product p = new Product();
                p.setSerial(checkData(serial.getEditText().getText().toString()));
                p.setShortName(shortname.getEditText().getText().toString());
                p.setDescription(description.getEditText().getText().toString());
                p.setCategory(categoryAdapter.getItem(category.getSelectedItemPosition()));
                p.setSubcategory(subcategoryAdapter.getItem(category.getSelectedItemPosition()));
                p.setProductClass(productclass.getSelectedItem().toString());

                presenter.addProduct(p);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getAllCategories(getSupportLoaderManager());
    }

    private void inflate(){
        serial = (TextInputLayout) findViewById(R.id.addpoduct_serial);
        shortname = (TextInputLayout) findViewById(R.id.addpoduct_shortname);
        description = (TextInputLayout) findViewById(R.id.addpoduct_description);

        category = (Spinner) findViewById(R.id.addproduct_spn_category);
        subcategory = (Spinner) findViewById(R.id.addproduct_spn_subcategory);
        productclass = (Spinner) findViewById(R.id.addproduct_spn_productclass);

        action = (Button) findViewById(R.id.addproduct_btn_action);
    }

    @Override
    public void setCategorySpnAdapter(Cursor c) {
        categoryAdapter.changeCursor(c);
    }

    @Override
    public void setSubcategorySpnAdapter(Cursor c) {
        subcategoryAdapter.changeCursor(c);
    }

    @Override
    public Context getContext() {
        return this;
    }


    private String checkData(String s){
        return !TextUtils.isEmpty(s) ? s : "";


    }
}
