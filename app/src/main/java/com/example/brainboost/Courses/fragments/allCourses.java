package com.example.brainboost.Courses.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.brainboost.Courses.views.seeCourses;
import com.example.brainboost.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link allCourses#newInstance} factory method to
 * create an instance of this fragment.
 */
public class allCourses extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FrameLayout thing;
    public allCourses() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment allCourses.
     */
    // TODO: Rename and change types and number of parameters
    public static allCourses newInstance(String param1, String param2) {
        allCourses fragment = new allCourses();
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

        View view=inflater.inflate(R.layout.fragment_all_courses, container, false);
        /*
        thing= view.findViewById(R.id.nameCourse);

        //para cambiar de pantalla
        thing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=getContext();
                Intent intento = new Intent(getActivity(), seeCourses.class);
                startActivity(intento);
            }
        });

        //para añadir a favoritos
        thing.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Mostrar el diálogo de alerta
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("¿Quieres añadir este curso a tus favoritos?")
                        .setTitle("Añadir a favoritos")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Se añade a favoritos
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // No pasa nada pq se cancela
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });
*/
        createLayout(view);

        return view;
    }


    public void createLayout(View view) {
        //donde se van a añdir las cosas
        LinearLayout content=view.findViewById(R.id.contentPanel);
        //fuentes a usar:
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "font/poppins_medium.ttf");
        Typeface typeface2 = Typeface.createFromAsset(getActivity().getAssets(), "font/poppins.ttf");


        //margenes y parametros de ancho y alto:
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        //margenes y su conversion a dp
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        float marginLeft = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, getResources().getDisplayMetrics());
        float marginRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, getResources().getDisplayMetrics());
        float marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, getResources().getDisplayMetrics());
        float marginButton = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, getResources().getDisplayMetrics());
        params.setMargins((int) marginLeft,(int)  marginTop,(int)  marginRight,(int) marginButton);//por defecto, se alteran sefun sea necesario


        Context context=getContext();
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        left = 0;
        right = 0;
        top = 0;
        bottom = 0;
        marginLeft = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, getResources().getDisplayMetrics());
        marginRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, getResources().getDisplayMetrics());
        marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, getResources().getDisplayMetrics());
        marginButton = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, getResources().getDisplayMetrics());
        layoutParams.setMargins((int) marginLeft,(int)  marginTop,(int)  marginRight,(int) marginButton);
        frameLayout.setLayoutParams(layoutParams);
        //id framelayout
        //int myFrameLayoutId = 1234; // Puedes cambiar este número a cualquier valor entero que desees
       // frameLayout.setId(myFrameLayoutId);

        //imagene:
        ImageView imageView= new ImageView(context);
        Drawable drawable = getResources().getDrawable(R.drawable.avatar);
        imageView.setImageDrawable(drawable);
        FrameLayout.LayoutParams layoutImage = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        left = 25;
        right = 0;
        top = 0;
        bottom = 0;
        marginLeft = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, getResources().getDisplayMetrics());
        marginRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, getResources().getDisplayMetrics());
        marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, getResources().getDisplayMetrics());
        marginButton = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, getResources().getDisplayMetrics());
        layoutImage.setMargins((int) marginLeft,(int)  marginTop,(int)  marginRight,(int) marginButton);

        int width=70;
        int height=70;
        int width2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, getResources().getDisplayMetrics());
        int height2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height, getResources().getDisplayMetrics());
        layoutImage.height = width2; // Alto en píxeles o dp
        layoutImage.width = height2; // Ancho en píxeles o dp

        imageView.setLayoutParams(layoutImage);
        frameLayout.addView(imageView);


        // Crear TITULO
        TextView textView = new TextView(context);
        textView.setText("Nombre curso");//nombre curso
            //margenes del titulo
        left = 120;
        right = 0;
        top = 0;
        bottom = 0;
        marginLeft = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, getResources().getDisplayMetrics());
        marginRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, getResources().getDisplayMetrics());
        marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, getResources().getDisplayMetrics());
        marginButton = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, getResources().getDisplayMetrics());
        params.setMargins((int) marginLeft,(int)  marginTop,(int)  marginRight,(int) marginButton);//por defecto, se alteran sefun sea necesario
        textView.setLayoutParams(params);
        textView.setTypeface(typeface);
        textView.setTextColor(Color.parseColor("#1F1F39"));
        textView.setTextSize(14);
        frameLayout.addView(textView);


        // Crear TUTOR
        TextView textView2 = new TextView(context);
        textView2.setText("tutor");//tutor
        //margenes del titulo
        left = 120;
        right = 0;
        top = 30;
        bottom = 0;
        marginLeft = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, getResources().getDisplayMetrics());
        marginRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, getResources().getDisplayMetrics());
        marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, getResources().getDisplayMetrics());
        marginButton = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, getResources().getDisplayMetrics());
        params.setMargins((int) marginLeft,(int)  marginTop,(int)  marginRight,(int) marginButton);//por defecto, se alteran sefun sea necesario
        textView2.setLayoutParams(params);
        textView2.setTypeface(typeface);
        textView2.setTextColor(Color.parseColor("#B8B8D2"));
        textView2.setTextSize(12);
        frameLayout.addView(textView2);


        // Crear CANTIDAD DE CAPITULOS
        TextView textView3 = new TextView(context);
        textView3.setText("capitulos");//cantidad capitulos
        //margenes del titulo
        left = 120;
        right = 0;
        top = 50;
        bottom = 0;
        marginLeft = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, getResources().getDisplayMetrics());
        marginRight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, getResources().getDisplayMetrics());
        marginTop = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, getResources().getDisplayMetrics());
        marginButton = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, getResources().getDisplayMetrics());
        params.setMargins((int) marginLeft,(int)  marginTop,(int)  marginRight,(int) marginButton);//por defecto, se alteran sefun sea necesario
        textView3.setLayoutParams(params);
        textView3.setTypeface(typeface);
        textView3.setTextColor(Color.parseColor("#FF6905"));
        textView3.setBackground(Drawable.createFromPath("drawable/corner.xml"));
        textView3.setTextSize(10);
       // frameLayout.addView(textView,textView2,textView3);
        frameLayout.addView(textView3);




        //evento para linkear la vista del curso


        //para cambiar de pantalla
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=getContext();
                Intent intento = new Intent(getActivity(), seeCourses.class);
                startActivity(intento);
            }
        });

        //para añadir a favoritos
        frameLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Mostrar el diálogo de alerta
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("¿Quieres añadir este curso a tus favoritos?")
                        .setTitle("Añadir a favoritos")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Se añade a favoritos
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // No pasa nada pq se cancela
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });



        content.addView(frameLayout);


    }
}