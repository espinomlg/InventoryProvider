package ismael.com.inventory.fragments;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ismael.com.inventory.R;
import ismael.com.inventory.adapters.ListProductAdapter;
import ismael.com.inventory.interfaces.ProductPresenter;
import ismael.com.inventory.presenter.ProductPresenterImpl;

/**
 * Created by espino on 24/04/17.
 */

public class ListProductFragment extends ListFragment implements ProductPresenter.View {

    private FloatingActionButton btn;

    private ListProductListener callback;
    private ProductPresenter presenter;
    private ListProductAdapter adapter;

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
        adapter = new ListProductAdapter(getContext(),null);
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
}
