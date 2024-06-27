package com.example.evaluacion.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.evaluacion.Models.Volumen;
import com.example.evaluacion.R;

import java.util.List;

public class AdaptadorVolumenes 
        extends RecyclerView.Adapter<AdaptadorVolumenes.VolumenViewHolder>
{

    private Context Ctx;
    private List<Volumen> lstVolumenes;

    public AdaptadorVolumenes(Context mCtx, List<Volumen> volumenes) {
        this.lstVolumenes = volumenes;
        Ctx=mCtx;
    }
    
    @Override
    public VolumenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Ctx).inflate(R.layout.ly_itemvolumen, parent, false);
        return new VolumenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VolumenViewHolder holder, int position) {

        Volumen volumen = lstVolumenes.get(position);

        holder.textViewTitulo.setText(volumen.getTitulo());
        holder.textViewVol.setText(volumen.getVolumen());
        holder.textViewFecha.setText(volumen.getFecha());

        Glide.with(Ctx)
                .load(volumen.getUrlPortada())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {        return lstVolumenes.size();    }

   class VolumenViewHolder extends RecyclerView.ViewHolder {

    TextView textViewTitulo, textViewVol, textViewFecha;
    ImageView imageView;

       public VolumenViewHolder(View itemView) {
        super(itemView);

        textViewTitulo = itemView.findViewById(R.id.txtTitulo);
        textViewVol = itemView.findViewById(R.id.txtVolumen);
        textViewFecha = itemView.findViewById(R.id.txtFecha);
        imageView = itemView.findViewById(R.id.imgPortada);

    }
}
}
