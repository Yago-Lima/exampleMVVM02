package com.example.examplemvvm02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private CalculadoraViewModel viewModel;
    private TextView textViewResultado;
    private Button buttonCalculadora;
    private EditText editTextN1, editTextN2, editTextOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResultado = findViewById(R.id.textViewResultado);
        buttonCalculadora = findViewById(R.id.buttonCalculadora);
        editTextN1 = findViewById(R.id.editTextN1);
        editTextN2 = findViewById(R.id.editTextN2);
        editTextOp = findViewById(R.id.editTextOp);

        buttonCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(editTextN1.getText().toString());
                double n2 = Double.parseDouble(editTextN2.getText().toString());
                String op = editTextOp.getText().toString();
                viewModel.calcular(n1, n2, op);
            }
        });

        viewModel = new ViewModelProvider(this)
                .get(CalculadoraViewModel.class);

        viewModel.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textViewResultado.setText(s);
            }
        });

    }//onCreate
}//class
