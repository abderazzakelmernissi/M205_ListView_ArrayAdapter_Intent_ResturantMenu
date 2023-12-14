package com.elmernissi.cc_m205;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

// MainActivity.java
// MainActivity.java
// MainActivity.java
public class MainActivity extends AppCompatActivity {

    private ListView listViewMenu;
    private ListView lv;
    private ArrayList<MenuResturant> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialiser la liste des menus (menuList) avec des données préexistantes.
        menuList = new ArrayList<>();
        menuList.add(new MenuResturant("Spaghetti Bolognese", 12.99));
        menuList.add(new MenuResturant("Chicken Alfredo", 14.99));
        menuList.add(new MenuResturant("Margherita Pizza", 9.99));
        // Ajoutez d'autres plats selon vos besoins.

        // Relier l'objet graphique déclaré à l'interface graphique.
       listViewMenu = findViewById(R.id.listViewMenu);

        // Utiliser ArrayAdapter pour afficher les éléments du menu dans la ListView.

        CustomAda adapter = new CustomAda(this,R.layout.list_menu_restaurant,menuList);
        listViewMenu.setAdapter(adapter);

         //Mettre en place un événement de clic pour passer à l'activité Commander.
        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MenuResturant selectedMenu = menuList.get(position);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("menu", selectedMenu);
                startActivity(intent);
            }
        });
    }
}


