package com.srd14.actividad5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText c1, c2;
    TextView VerTexto;
    Button boton1;

    EditText txtCorreo,txtTelefono,txtWeb;

    Button btnValidar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        c1 = findViewById(R.id.txt1);
        c2 = findViewById(R.id.txt2);
        VerTexto = findViewById(R.id.VerTexto);
        boton1 = findViewById(R.id.boton1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClick(c1,c2,VerTexto);
            }
        });

        txtCorreo = findViewById(R.id.txtCorreo);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtWeb = findViewById(R.id.txtWeb);
        btnValidar = findViewById(R.id.btnValidar);
        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verToast(txtCorreo,txtTelefono,txtWeb);
            }
        });

    }

    public void OnClick(EditText c1, EditText c2, TextView verTexto) {
        String valor1 = c1.getText().toString();
        String valor2 = c2.getText().toString();
        verTexto.setText("->"+ valor1 + " " + valor2);
        verTexto.setTextColor(getResources().getColor(com.google.android.material.R.color.design_dark_default_color_secondary));
    }
    public void verToast(EditText txt1, EditText txt2, EditText txt3) {
        String valor1 = txt1.getText().toString();
        String valor2 = txt2.getText().toString();
        String valor3 = txt3.getText().toString();
        String mensaje = "Correo: " + valor1 + "\nTeléfono: " + valor2 + "\nPágina Web: " + valor3;
        android.widget.Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }
}