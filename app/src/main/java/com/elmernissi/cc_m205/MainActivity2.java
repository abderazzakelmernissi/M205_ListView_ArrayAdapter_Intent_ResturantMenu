package com.elmernissi.cc_m205;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private EditText edQtite;
    private Button btnValider;
    private TextView tvAffiche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edQtite = findViewById(R.id.edQtite);
        btnValider = findViewById(R.id.btnValider);
        tvAffiche = findViewById(R.id.tvAffiche);

          // Récupérer les données passées depuis MainActivity.
        Intent intent = getIntent();
        if (intent.hasExtra("menu")) {
            MenuResturant selectedMenu = (MenuResturant) intent.getSerializableExtra("menu");
            edQtite.setText("1");
            tvAffiche.setText("Plate" + selectedMenu.getNomPlat() +
                    "\nPrix unitaire: " + selectedMenu.getPrixPlat()+
                    "\nQuantité: 1" +
                    "\nPrix à payer: " + selectedMenu.getPrixPlat());
            // Mettre en place un événement de clic pour afficher les détails du menu sélectionné.
            btnValider.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int quantite = Integer.parseInt(edQtite.getText().toString());
                    double prixTotal = selectedMenu.getPrixPlat() * quantite;

                    // Afficher les détails du menu et le prix total à payer.
                    String affichage = "Plat: " + selectedMenu.getNomPlat() +
                            "\nPrix unitaire: " + selectedMenu.getPrixPlat() +
                            "\nQuantité: " + quantite +
                            "\nPrix à payer: " + prixTotal;

                    tvAffiche.setText(affichage);
                }
            });
        }
    }
}