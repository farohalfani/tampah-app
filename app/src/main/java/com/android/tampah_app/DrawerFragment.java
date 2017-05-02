package com.android.tampah_app;


import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerFragment extends Fragment {

    RecyclerView recyclerView;
    DataAdapter adapter;
    List<Data> dataList;
    Data data;

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
        data = new Data();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        dataList = new ArrayList<>();
        adapter = new DataAdapter(getContext(),dataList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);



//        GridView gridView = (GridView) rootView.findViewById(R.id.grid_view);
//        gridView.setAdapter(new ImageAdapter(getContext()));
//        // Instance of ImageAdapter Class
//        gridView.setAdapter(new ImageAdapter(getContext()));
//
//
//        /**
//         * On Click event for Single Gridview Item
//         * */
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//
//                // Sending image id to FullScreenActivity
//                Intent i = new Intent(getActivity().getApplicationContext(), ItemActivity.class);
//                // passing array index
//                i.putExtra("id", position);
//                startActivity(i);
//
//
//            }

//        });
        return rootView;
    }
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
