package com.example.evaluacion.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAbrev() {
        return Abrev;
    }

    public void setAbrev(String abrev) {
        Abrev = abrev;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getUrlLogo() {
        return UrlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        UrlLogo = urlLogo;
    }

    private String Titulo;
    private String Abrev;
    private String Descripcion;
    private String UrlLogo;
    public Revista(JSONObject a) throws JSONException {
        Titulo =  a.getString("name").toString();
        Abrev =  a.getString("abbreviation").toString() ;
        Descripcion =  a.getString("description").toString() ;
        UrlLogo = a.getString("portada").toString() ;
    }
    public static ArrayList<Revista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revista> revistas = new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            revistas.add(new Revista(datos.getJSONObject(i)));
        }
        return revistas;
    }

}

