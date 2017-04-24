package ismael.com.inventory.fragments;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    private static final int CURSOR_ID = 1;

    private ListProductListener callback;
    private ProductPresenter presenter;
    private ListProductAdapter adapter;

    public interface ListProductListener{
        void onAddProductListener();
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
        //se guarda el fragment en la pila de llamadas
        //setRetainInstance(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        getLoaderManager().initLoader(CURSOR_ID, null, (ProductPresenterImpl)presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_listproducts, container, false);

        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(adapter);

    }

    @Override
    public void setCursor(Cursor c) {
        adapter.changeCursor(c);
    }
}
