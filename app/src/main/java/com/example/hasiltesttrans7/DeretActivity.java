package com.example.hasiltesttrans7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeretActivity extends AppCompatActivity {
    private EditText etMasukkanAngka, etDeretGenap, etDeretGanjil, etDeretFibonnaci;
    private Button btnTampilkanDeret ;
    private int totalangka;
    private String genap, ganjil, fibonnanci ;
    private int angkaFibonnanci, angkaSebelumnya, angkaPenengah, angkaGenap, angkaPrima=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deret);
        etDeretFibonnaci = findViewById(R.id.etDeretFibonnaci);
        etDeretGanjil = findViewById(R.id.etDeretGanjil);
        etDeretGenap = findViewById(R.id.etDeretGenap);
        etMasukkanAngka = findViewById(R.id.etMasukkanAngka);
        btnTampilkanDeret = findViewById(R.id.btnTampilkanDeret);
        btnTampilkanDeret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetSemuaData();
                if(!etMasukkanAngka.getText().toString().equals("")){
                    totalangka = Integer.valueOf(etMasukkanAngka.getText().toString());
                    for(int i = 1; i<=totalangka; i ++) {
                        deretGenap();
                        deretFibonacci(i);
                        deretPrima(i);
                    }



                    etDeretGenap.setText(genap);
                    etDeretGanjil.setText(ganjil);
                    etDeretFibonnaci.setText(fibonnanci);
                }
            }
        });
    }

    private void resetSemuaData() {
        etDeretFibonnaci.setText("");
        etDeretGanjil.setText("");
        etDeretGenap.setText("");
        fibonnanci = null;
        genap = null;
        ganjil = null;
        angkaFibonnanci = 1;
        angkaPenengah = 0;
        angkaSebelumnya = 0;
    }

    private void deretFibonacci(int i) {


        if(fibonnanci == null){
            fibonnanci = String.valueOf(angkaFibonnanci);
            angkaSebelumnya = 0;
        }else{
            angkaPenengah = angkaFibonnanci;
            angkaFibonnanci = angkaFibonnanci + angkaSebelumnya;
            angkaSebelumnya = angkaPenengah;
            fibonnanci = fibonnanci + "," + String.valueOf(angkaFibonnanci);
        }
    }

    private void deretGenap() {


                if (genap == null) {
                    angkaGenap = 2;
                    genap = String.valueOf(angkaGenap);

                } else {
                    angkaGenap += 2;
                    genap += "," + String.valueOf(angkaGenap);

                }

    }

    private void deretPrima(int i) {
        int prima = 0;
        for (int pembagi=i; pembagi >=1; pembagi--){
            if(i % pembagi == 0) {
                prima += 1;
            }
        }
            if(prima == 2)
            {
                if(ganjil == null){
                    ganjil = String.valueOf(i);
                }else{

                    ganjil = ganjil + ","+ String.valueOf(i);
                }
            }
    }
}