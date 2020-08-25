package com.example.hasiltesttrans7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PalindromActivity extends AppCompatActivity {
    private EditText etMasukkanKata;
    private Button btnProses;
    private TextView hasil, tvPalindrome, tvKonsonan ,tvVocal;
    private String kata1, kata2;
    private int vocal, konsonan = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrom);
        etMasukkanKata = findViewById(R.id.etMasukkanKata);
        btnProses = findViewById(R.id.btnTampilkan);
        hasil = findViewById(R.id.hasil);
        tvPalindrome = findViewById(R.id.tvPalindrome);
        tvKonsonan = findViewById(R.id.tvKonsonan);
        tvVocal = findViewById(R.id.tvVocal);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etMasukkanKata.getText().toString().equals("")){
                    String kataInput = etMasukkanKata.getText().toString();
                    String[] splitStr = kataInput.split("\\s+");
                    if(splitStr.length > 1){
                        kata1= splitStr[0];
                        kata2= splitStr[1];
                        if(new StringBuilder(kata1).reverse().toString().equals(kata2)){
                            tvPalindrome.setText(kata1 + " "+ kata2 + " Termasuk palindrome");
                        }else{
                            tvPalindrome.setText(kata1 + " "+ kata2 + " Tidak Termasuk palindrome");
                        }
                    }

                    for(int i= 0; i< kataInput.length(); i++){
                        String s = String.valueOf(kataInput.charAt(i)).toLowerCase();
                        if(s.equals("a") || s.equals("i") ||
                                s.equals("u")|| s.equals("e") ||
                                s.equals("o")){
                            vocal += 1;
                        }else{
                            konsonan +=1;
                        }
                    }
                    tvVocal.setText("Jumlah Vocal: " + String.valueOf(vocal));
                    tvKonsonan.setText("Jumlah Konsonan: "+ String.valueOf(konsonan));
                }
            }
        });

    }
}