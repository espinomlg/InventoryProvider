package ismael.com.inventory.fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import ismael.com.inventory.R;
import ismael.com.inventory.adapters.ListProductAdapter;
import ismael.com.inventory.interfaces.ProductPresenter;
import ismael.com.inventory.models.Product;
import ismael.com.inventory.presenter.ProductPresenterImpl;

/**
 * Created by espino on 24/04/17.
 */

public class ListProductFragment extends ListFragment implements ProductPresenter.View {

    private FloatingActionButton btn;

    private ListProductListener callback;
    private ProductPresenter presenter;
    private ListProductAdapter adapter;

    private Product p;

    public interface ListProductListener{
        void onAddProductListener();
    }

    public static ListProductFragment newInstance(Bundle args){
        ListProductFragment fragment = new ListProductFragment();
        if(args != null)
            fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            callback = (ListProductListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(getActivity().toString() + " debe implementar la interfaz ListProductListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ProductPresenterImpl(getContext(), this);
        adapter = new ListProductAdapter(getContext(), null);
        //se guarda el fragment en la pila de llamadas
        //setRetainInstance(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.getAllProducts(getLoaderManager());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_listproducts, container, false);
        btn = (FloatingActionButton) v.findViewById(R.id.productfragment_btn_add);
        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerForContextMenu(getListView());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onAddProductListener();
            }
        });
        setListAdapter(adapter);

    }

    @Override
    public void setCursor(Cursor c) {
        adapter.changeCursor(c);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
        p = adapter.getItem(info.position);
        menu.setHeaderTitle(adapter.getItem(info.position).getShortName());
        inflater.inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.contextmenu_delete:
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("are you sure?")
                        .setMessage("you want to delete this product?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                presenter.deleteProduct(p);
                                presenter.getAllProducts(getLoaderManager());
                            }
                        })
                        .setNegativeButton("no", null);
                dialog.show();
                break;

            case R.id.contextmenu_edit:

                break;
        }

        return true;

    }
}
