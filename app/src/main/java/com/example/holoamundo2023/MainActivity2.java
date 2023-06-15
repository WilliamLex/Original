package com.example.holoamundo2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;

public class MainActivity2 extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txtSaludo = (TextView) findViewById(R.id.textView);
        Bundle bundle = this.getIntent().getExtras();
        txtSaludo.setText("Hola, Bienvenido \n " + "Nombre: " + bundle.getString("NOMBRE") + "\n" +
                "Password: " + bundle.getString("PASSWORD")+ "\n" +
                "Genero: " + bundle.getString("GENERO") + "\n" +
                "Notifica: " + bundle.getString("NOTIFICA")+ "\n"
        );

        /*Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("http://api.androidhive.info/contacts/", datos,
                MainActivity2.this, MainActivity2.this);
        ws.execute("GET");*/
    }
    RequestQueue queue = Volley.newRequestQueue(this);
    String url ="http://revistas.uteq.edu.ec/ws/login.php?usr="
    //bundle.getString("NOMBRE") + "&pass=" + bundle.getString("PASSWORD");
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(MainActivity2.this, "Resp: " + response,
                            Toast.LENGTH_SHORT).show();

                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity2.this, "Error: " + error.getMessage(),
                            Toast.LENGTH_SHORT).show();

                }
            });
            queue.add(stringRequest);
    @Override
    public void processFinish(String result) throws JSONException {
        Toast.makeText(this, "Resp: " + result, Toast.LENGTH_SHORT).show();




    }
}