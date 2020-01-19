package eu.ase.ro.concedii_sub6_2018;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     ArrayList<HomeExchange> he2 = new ArrayList<HomeExchange>();
    Button btnLista, btnAdaugare, btnPreluare, btnCentralizator, btnDespre;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==100 && resultCode==200){
            HomeExchange toAddHome = data.getParcelableExtra("toAddHome");
            he2.add(toAddHome);
        }
        //super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents(){
        btnLista=findViewById(R.id.main_btn_lista);
        btnAdaugare=findViewById(R.id.main_btn_adaugare);
        btnPreluare=findViewById(R.id.main_btn_preluare);
        btnCentralizator=findViewById(R.id.main_btn_centralizator);
        btnDespre=findViewById(R.id.main_btn_despre);

        btnDespre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), getString(R.string.nume_utilizator), Toast.LENGTH_LONG).show();
            }
        });

        btnAdaugare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdaugareOfertaActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

}
