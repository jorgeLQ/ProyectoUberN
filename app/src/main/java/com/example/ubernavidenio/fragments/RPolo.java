package com.example.ubernavidenio.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.fragment.app.Fragment;

import com.example.ubernavidenio.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RPolo.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RPolo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RPolo extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Spinner sp1;
    Spinner sp2;
    Spinner sp3;
    Spinner sp4;
    View vista;

    private boolean isFristTime=true;

    public RPolo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RPolo.
     */
    // TODO: Rename and change types and number of parameters
    public static RPolo newInstance(String param1, String param2) {
        RPolo fragment = new RPolo();
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
        vista=inflater.inflate(R.layout.fragment_rpolo, container, false);
        sp1=(Spinner) vista.findViewById(R.id.idTallas);
        sp2=(Spinner) vista.findViewById(R.id.spinner1);
        sp3=(Spinner) vista.findViewById(R.id.spinner);
        sp4=(Spinner) vista.findViewById(R.id.idCantidad);
        final FloatingActionButton fab = vista.findViewById(R.id.fab);

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(getContext(),
                R.array.combotalla,android.R.layout.simple_spinner_item
        );

        ArrayAdapter<CharSequence>adapter1=ArrayAdapter.createFromResource(getContext(),
                R.array.combocantidad,android.R.layout.simple_spinner_item
        );

        sp1.setAdapter(adapter);
        sp2.setAdapter(adapter1);
        sp3.setAdapter(adapter);
        sp4.setAdapter(adapter1);


        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String seleccioT1 = sp1.getSelectedItem().toString();
                    if (seleccioT1.equals("XS") || seleccioT1.equals("S") || seleccioT1.equals("M") || seleccioT1.equals("L") || seleccioT1.equals("XL") || seleccioT1.equals("XXL")) {
                        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String seleccionC1 = sp2.getSelectedItem().toString();
                                if (seleccionC1.equals("1") || seleccionC1.equals("2") || seleccionC1.equals("3") || seleccionC1.equals("4")) {
                                    fab.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Snackbar.make(v, "Se añadio un nuevo elemento al carrito de compras", Snackbar.LENGTH_LONG)
                                                    .setAction("Action", null).show();
                                        }
                                    });
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }else{
                        fab.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(v, "Por favor seleccione una talla y cantidad de un producto", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            }
                        });
                    }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccioT1 = sp3.getSelectedItem().toString();
                if (seleccioT1.equals("XS") || seleccioT1.equals("S") || seleccioT1.equals("M") || seleccioT1.equals("L") || seleccioT1.equals("XL") || seleccioT1.equals("XXL")) {
                    sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String seleccionC1 = sp4.getSelectedItem().toString();
                            if (seleccionC1.equals("1") || seleccionC1.equals("2") || seleccionC1.equals("3") || seleccionC1.equals("4")) {
                                fab.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Snackbar.make(v, "Se añadio un nuevo elemento al carrito de compras", Snackbar.LENGTH_LONG)
                                                .setAction("Action", null).show();
                                    }
                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }else{
                    fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Snackbar.make(v, "Por favor seleccione una talla y cantidad de un producto", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return vista;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
