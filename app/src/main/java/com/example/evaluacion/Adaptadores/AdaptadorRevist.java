package com.example.evaluacion.Adaptadores;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.evaluacion.Models.Revista;
import com.example.evaluacion.R;

import java.util.ArrayList;

public class AdaptadorRevist extends ArrayAdapter<Revista> {

    public AdaptadorRevist(Context context, ArrayList<Revista> datos) {
        super(context, R.layout.lyresvista, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyresvista, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.lblTResvista);
        lblTitulo.setText(getItem(position).getTitulo());

        TextView lblAbrevi = (TextView)item.findViewById(R.id.lblAbrevi);
        lblTitulo.setText(getItem(position).getAbrev());

        TextView lblDescripcion = (TextView)item.findViewById(R.id.lblDescripcion);
        lblTitulo.setText(Html.fromHtml(getItem(position).getDescripcion()));

        ImageView imageView = (ImageView)item.findViewById(R.id.imgLogo);
        Glide.with(this.getContext())
                .load(getItem(position).getUrlLogo())
                .into(imageView);

        return item;

    }


}
