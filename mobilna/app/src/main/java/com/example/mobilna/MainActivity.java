package com.example.mobilna;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvAge, tvResult;
    private SeekBar sbAge;
    private ListView listSpecies;
    private Button btnConfirm;
    private EditText etOwner, etPoint, etDate;

//    Data
    private final String[] species = {"Pies", "Kot", "Świnka morska"};
    private String specie = "Kot";

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

        tvAge = findViewById(R.id.tvAge);
        tvResult = findViewById(R.id.tvResult);
        sbAge = findViewById(R.id.sbAge);
        listSpecies = findViewById(R.id.listSpecies);
        btnConfirm = findViewById(R.id.btnConfirm);
        etOwner = findViewById(R.id.etOwner);
        etDate = findViewById(R.id.etDate);
        etPoint = findViewById(R.id.etPoint);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.sample_list_view, R.id.tvItem, species);
        listSpecies.setAdapter(arrayAdapter);

//        Listeners
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvAge.setText("Ile ma lat? " + progress);
            }
        });

        listSpecies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                specie = (String) listSpecies.getItemAtPosition(myItemInt);
                switch (specie) {
                    case "Pies":
                        sbAge.setMax(18);
                        break;
                    case "Kot":
                        sbAge.setMax(20);
                        break;
                    case "Świnka morska":
                        sbAge.setMax(9);
                        break;
                    default:
                        break;
                }
            }
        });

        btnConfirm.setOnClickListener(e -> {
            String owner = etOwner.getText().toString();
            String point = etPoint.getText().toString();
            String date = etDate.getText().toString();
            int age = sbAge.getProgress();
            tvResult.setText(owner+", "+specie+", "+age+", "+point+", "+date);
        });
    }
}