package com.example.vehiclehmi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Settings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Settings extends Fragment {

    RecyclerView mRecycler;
    RecyclerView nRecycler;
    ArrayAdapter<String> adapter;
    String[] data={"Touch Screen Beep","Fuel Saver Display","Display Mode Manuel","Display Brightness HL ON","Display Brightness HL OFF"};


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Settings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Settings.
     */
    // TODO: Rename and change types and number of parameters
    public static Settings newInstance(String param1, String param2) {
        Settings fragment = new Settings();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_settings,container,false);
        // lv=(ListView) view.findViewById(R.id.listView);
        //adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,data);
        //lv.setAdapter(adapter);
        // return view;
        mRecycler=view.findViewById(R.id.recycler_view);
        nRecycler=view.findViewById(R.id.recycler_view2);
        setAdapter1();
        setAdapter2();
        return  view;
    }

    private void setAdapter2() {
        CustomRowAdapter customRowAdapter=new CustomRowAdapter();
        LinearLayoutManager mLayoutManager=new LinearLayoutManager(getActivity());
        nRecycler.setLayoutManager(mLayoutManager);
        nRecycler.setAdapter(customRowAdapter);
    }

    private void setAdapter1() {
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(recyclerAdapter);
    }

}