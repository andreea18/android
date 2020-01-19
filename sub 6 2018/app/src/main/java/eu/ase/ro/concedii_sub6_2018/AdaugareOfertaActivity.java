package eu.ase.ro.concedii_sub6_2018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AdaugareOfertaActivity extends AppCompatActivity {

    EditText etAdresa, etNumarCamere, etSuprafara, etData;
    Spinner spnTipLocuinta;
    HomeExchange homeExchange;
    Intent intent;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent=getIntent();
        setContentView(R.layout.activity_adaugare_oferta);
        initComponents();
    }

    private void initComponents(){
        etAdresa = findViewById(R.id.adaugare_et_adresa);
        etNumarCamere = findViewById(R.id.adaugare_et_camere);
        etSuprafara = findViewById(R.id.adaugare_et_suprafata);
        etData = findViewById(R.id.adaugare_et_data);
        spnTipLocuinta =findViewById(R.id.adaugare_spn_tiplocuinta);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.spn_tipcamete,android.R.layout.simple_dropdown_item_1line);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnTipLocuinta.setAdapter(adapter);

        btnSave = findViewById(R.id.adaugare_btn_salvare);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salveaza();
            }
        });
    }

    private void salveaza(){
        if(valid()){
            String adresa = etAdresa.getText().toString();
            int nrCamere = Integer.parseInt(etNumarCamere.getText().toString());
            int suprafata = Integer.parseInt(etSuprafara.getText().toString());
            Date perioada = null;
            String tip = spnTipLocuinta.getSelectedItem().toString();
            SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY);
            try {
                perioada = sfd.parse(etData.getText().toString());
            }catch (ParseException e){
                e.printStackTrace();
            }
            homeExchange = new HomeExchange(adresa, nrCamere, suprafata, perioada, tip);
            intent.putExtra("toAddHome",homeExchange);
            setResult(200,intent);
            finish();

        }
    }

    private boolean valid(){
        String completeaza="Completeaza ";
        if(etAdresa.getText().toString().trim().isEmpty()){
            completeaza+="adresa";
            Toast.makeText(getApplicationContext(),completeaza, Toast.LENGTH_LONG).show();
            return false;
        }
        if(etNumarCamere.getText().toString().trim().isEmpty()){
            completeaza+="numarul de camere";
            Toast.makeText(getApplicationContext(),completeaza, Toast.LENGTH_LONG).show();
            return false;
        }
        if(etSuprafara.getText().toString().trim().isEmpty()){
            completeaza+="suprafata";
            Toast.makeText(getApplicationContext(),completeaza, Toast.LENGTH_LONG).show();
            return false;
        }
        if(etData.getText().toString().trim().isEmpty()){
            completeaza+="data";
            Toast.makeText(getApplicationContext(),completeaza, Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}
