package com.android.tampah_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(getContext()));


        /**
         * On Click event for Single Gridview Item
         * */
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getActivity().getApplicationContext(), ItemActivity.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);


                }

            });
        return rootView;
}
}
