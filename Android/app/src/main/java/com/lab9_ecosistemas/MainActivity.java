package com.lab9_ecosistemas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements OnMessage{

    private ImageView imgNaranja, imgPerro, imgSandwich, imgYogurt;
    private Button bnNaranja, bnPerro, bnSandwich, bnYogurt;
    private TextView txtMenu;

    private UDPConnection udp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgNaranja = findViewById(R.id.imgNaranja);
        imgPerro = findViewById(R.id.imgPerro);
        imgSandwich = findViewById(R.id.imgSandwich);
        imgYogurt = findViewById(R.id.imgYogurt);

        bnNaranja = findViewById(R.id.bnNaranja);
        bnPerro = findViewById(R.id.bnPerro);
        bnSandwich = findViewById(R.id.bnSandwich);
        bnYogurt = findViewById(R.id.bnYogurt);

        txtMenu = findViewById(R.id.txtMenu);

        udp = new UDPConnection();
        udp.start();

        bnNaranja.setOnClickListener(
                (v) -> {
                    Toast.makeText(this, "Jugo de naranja", Toast.LENGTH_SHORT).show();
                }
        );

        bnPerro.setOnClickListener(
                (v) -> {
                    Toast.makeText(this, "Perro caliente", Toast.LENGTH_SHORT).show();
                }
        );

        bnSandwich.setOnClickListener(
                (v) -> {
                    Toast.makeText(this, "Sandwich", Toast.LENGTH_SHORT).show();
                }
        );

        bnYogurt.setOnClickListener(
                (v) -> {
                    Toast.makeText(this, "Yogurt griego", Toast.LENGTH_SHORT).show();
                }
        );
    }

    @Override
    public void onMessage(String message) {

    }
}