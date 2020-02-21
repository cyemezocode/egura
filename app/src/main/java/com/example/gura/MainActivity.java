package com.example.gura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText Email,Password;
    String server ="ttps://developer.codeck.rw/config.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.signbtn);
        Email = (EditText)findViewById(R.id.emailinput);
        Password = (EditText)findViewById(R.id.passwordinput);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email,passoword;
                email = Email.getText().toString();
                passoword = Password.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, server, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("email",email);
                        params.put("password",passoword);
                        return params;
                    }
                };
            }

    });
}
