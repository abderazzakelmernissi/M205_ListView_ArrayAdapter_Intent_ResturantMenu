package com.elmernissi.cc_m205;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CustomAda extends ArrayAdapter<MenuResturant> {
    public CustomAda(@NonNull Context context, int resource, @NonNull List<MenuResturant> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu_restaurant, parent, false);
        }

        MenuResturant currentMenu = getItem(position);

        // Remplir les TextView du layout personnalisé avec les données du menu.
        TextView textViewNomPlat = convertView.findViewById(R.id.textViewNomPlat);
        TextView textViewPrixPlat = convertView.findViewById(R.id.textViewPrixPlat);

        if (currentMenu != null) {
            textViewNomPlat.setText(currentMenu.getNomPlat());
            textViewPrixPlat.setText(String.valueOf(currentMenu.getPrixPlat()));
        }

        return convertView;
    }
}
