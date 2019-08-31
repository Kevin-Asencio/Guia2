package com.example.guia2;

import androidx.appcompat.app.AppCompatActivity;
        import android.content.Context;
        import android.os.Handler;
        import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;
        import android.widget.Button;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Toast;

public class ActivitySecundaria extends AppCompatActivity implements View.OnClickListener {
    ProgressBar Pbar;
    private final String TAG = "EVENTOS";
    Button btnProcesar;

    AutoCompleteTextView ACTAnimal;
    AutoCompleteTextView ACTFruta;
    AutoCompleteTextView ACTLenguaje;
    String [] fruta={"Melocoton", "Anona", "Uva", "Piña", "Tamarindo", "Naranja", "Sandia", "Melon"};
    String [] animal={"Hipopotamo", "Gallina", "Oso", "Toro", "Mono", "Perro", "Ganster", "Raton"};
    String [] lenguaje={"HTML XD", "C++", "Java","Php" , "C", "Python", "JavaScript","C#", "Ruby"};
    private int mProgressStatus = 0;
    Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Rellene los  datos");
        }
        ACTFruta=findViewById(R.id.ACTFruta);
        ACTAnimal=findViewById(R.id.ACTAnimal);
        ACTLenguaje=findViewById(R.id.ACTLenguaje);
        ArrayAdapter<String> adapterF=new ArrayAdapter<>(this, android.R.layout.select_dialog_item, fruta);
        ArrayAdapter<String> adapterA=new ArrayAdapter<>(this, android.R.layout.select_dialog_item, animal);
        ArrayAdapter<String> adapterL=new ArrayAdapter<>(this, android.R.layout.select_dialog_item, lenguaje);
        ACTFruta.setThreshold(1);
        ACTFruta.setAdapter(adapterF);
        ACTAnimal.setThreshold(1);
        ACTAnimal.setAdapter(adapterA);
        ACTLenguaje.setThreshold(1);
        ACTLenguaje.setAdapter(adapterL);
        Pbar=findViewById(R.id.Pbar);
        btnProcesar=findViewById(R.id.btnProcesar);

        btnProcesar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnProcesar: {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (mProgressStatus < 100){
                            mProgressStatus++;
                            SystemClock.sleep(50);
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Pbar.setProgress(mProgressStatus);
                                }
                            });
                        }
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(ActivitySecundaria.this, "El animal seleccionado es "+ACTAnimal.getText(), Toast.LENGTH_SHORT).show();
                                Toast.makeText(ActivitySecundaria.this, "La fruta seleccionada es "+ACTFruta.getText(), Toast.LENGTH_SHORT).show();
                                Toast.makeText(ActivitySecundaria.this, "El lenguaje seleccionado es "+ACTLenguaje.getText(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
            }
            break;
        }
    }

}
