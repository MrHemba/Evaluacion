package com.example.evaluacion.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Volumen {
    private String titulo;
    private String volumen;
    private String Fecha;
    private String urlPortada;
    private String IssueId;

    public Volumen(JSONObject a) throws JSONException {
        titulo =  a.getString("title").toString();
        volumen =  "Vol: "+a.getString("volume").toString() +
                  " No: "+a.getString("number").toString() +
                 "Año: "+a.getString("year").toString();
       Fecha =  a.getString("date_published").toString() ;
        urlPortada = a.getString("cover").toString() ;
        IssueId = a.getString("issue_id").toString();
    }
    public static ArrayList<Volumen> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Volumen> volumenes = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            volumenes.add(new Volumen(datos.getJSONObject(i)));
        }
        return volumenes;
    }

    public String getIssueId() {
        return IssueId;
    }

    public void setIssueId(String issueId) {
        IssueId = issueId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }

}
