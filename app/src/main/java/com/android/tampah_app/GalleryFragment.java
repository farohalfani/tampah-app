package com.android.tampah_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {


    public GalleryFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
        Button nextButton = (Button) rootView.findViewById(R.id.bLanjutkan);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),BankActivity.class));
            }
        });
        // Inflate the layout for this fragment
        return rootView ;
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
//        switch(view.getId()) {
//            case R.id.cbAmbilSendiri:
//                if (checked)
//                // Put some meat on the sandwich
//                else
//                // Remove the meat
//                break;
//            case R.id.cbAntarPemilik:
//                if (checked)
//                // Cheese me
//                else
//                // I'm lactose intolerant
//                break;
//            case R.id.cbAntarJNE:
//                if (checked)
//                // Cheese me
//                else
//                // I'm lactose intolerant
//                break;
//            // TODO: Veggie sandwich
//        }
    }

}
