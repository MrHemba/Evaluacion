package com.example.evaluacion;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.evaluacion.Adaptadores.AdaptadorVolumenes;
import com.example.evaluacion.Models.Volumen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://revistas.uteq.edu.ec/ws/issues.php?j_id=2";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ArrayList<Volumen> lstVolumenes = new ArrayList<Volumen> ();
                        try {


        JSONArray JSONlistaVolumenes=  new JSONArray(response);
        lstVolumenes = Volumen.JsonObjectsBuild(JSONlistaVolumenes);


        int resId = R.anim.layout_animation_down_to_up;
        LayoutAnimationController animation =
                AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                resId);
        recyclerView.setLayoutAnimation(animation);


        AdaptadorVolumenes adaptadorVolumen = new AdaptadorVolumenes(getApplicationContext(), lstVolumenes);
        recyclerView.setAdapter(adaptadorVolumen);

    } catch (JSONException e)
   	 {
      	  Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
    	}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               
            }
        });
        
        queue.add(stringRequest);
    }
}