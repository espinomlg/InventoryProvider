package ismael.com.inventory.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import ismael.com.inventory.R;

/**
 * Created by espino on 8/05/17.
 */

public class ManageProductFragment extends Fragment {


    private TextInputLayout serial, shortname, description;
    private Spinner category, subcategory, productclass;

    private ManageProductListener callback;

    public interface ManageProductListener{
        void onManageProductListener();
    }

    public static ManageProductFragment newInstance(Bundle args){
        ManageProductFragment fragment = new ManageProductFragment();
        if(args != null)
            fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            callback = (ManageProductListener)activity;
        }catch (ClassCastException ex){
            throw new ClassCastException(getActivity().toString() + " must implement interface ManageProductListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_addproduct, container);
        serial = (TextInputLayout) v.findViewById(R.id.addpoduct_serial);
        shortname = (TextInputLayout) v.findViewById(R.id.addpoduct_shortname);
        description = (TextInputLayout) v.findViewById(R.id.addpoduct_description);

        category = (Spinner) v.findViewById(R.id.addproduct_spn_category);
        subcategory = (Spinner) v.findViewById(R.id.addproduct_spn_subcategory);
        productclass = (Spinner) v.findViewById(R.id.addproduct_spn_productclass);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
