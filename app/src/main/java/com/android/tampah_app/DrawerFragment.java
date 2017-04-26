package com.android.tampah_app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerFragment extends Fragment {

    public DrawerFragment() {
        // Required empty public constructor super.onCreate(savedInstanceState);


//        GridView gridView = (GridView) getView().findViewById(R.id.grid_view);
//        // Instance of ImageAdapter Class
//        gridView.setAdapter(new ImageAdapter(getContext()));
//        return inflater.inflate(R.layout.fragment_drawer);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drawer, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(getContext()));

        return rootView;
    }

}
