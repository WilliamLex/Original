package com.example.holoamundo2023;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import WebService.WebService;

public class MainActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
    }
    public void btnLogin(View view) {

        EditText txtUsuario = (EditText) findViewById(R.id.txtNombre);
        EditText txtClave = (EditText) findViewById(R.id.txtPassword);
        Map<String, String> datos = new HashMap<String, String>();
        datos.put("Correo", txtUsuario.getText().toString());
        datos.put("clave", txtClave.getText().toString());

        WebService ws = new WebService(
                "https://api-uealecpeterson.net/public/login",
                datos, MainActivityLogin.this, MainActivityLogin.this;
        ws.execute("POST");
    }
    @Override
    public void processFinish(String result) throws JSONException{
        Log.i("Resp:", result);
        JSONObject resp = new JSONObject(result);
        if(resp.has("error")){
            Toast.makeText(this, "Error Login" +
                    resp.getString("error"), Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Bienvenido, Token: " +
                    resp.getString("acces_token"), Toast.LENGTH_LONG).show();
        }

    }

        //Toast.makeText(this.getApplicationContext(), txtNombre.getText().toString(), Toast.LENGTH_SHORT).show();


}