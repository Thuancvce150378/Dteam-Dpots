package com.example.dteam_dpots.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.dteam_dpots.*;

public class ControllerHistoryPot extends AppCompatActivity {

    ImageButton ibOptionChoice;
    MenuBuilder menuBuilder;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_pot);

        ibOptionChoice = findViewById(R.id.ibOptionChoice);
        menuBuilder = new MenuBuilder(this);

        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.popupmenuhistorypot, menuBuilder);

        ibOptionChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenuHistoryPot(menuBuilder, view);
            }
        });
    }

    @SuppressLint("RestrictedApi")
    public void PopupMenuHistoryPot(MenuBuilder a, View view) {
        @SuppressLint("RestrictedApi") MenuPopupHelper optionMenu = new MenuPopupHelper(this, a,view);
        optionMenu.setForceShowIcon(true);
        menuBuilder.setCallback(new MenuBuilder.Callback() {
            @Override
            public boolean onMenuItemSelected(@NonNull MenuBuilder menu, @NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_edit:
                        Intent intent = new Intent(ControllerHistoryPot.this, ControllerEditTransaction.class);
                        startActivity(intent);
                        return true;
                    case R.id.menu_remove:
                        Intent intent2 = new Intent(ControllerHistoryPot.this, ControllerHistoryPot.class);
                        startActivity(intent2);
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onMenuModeChange(@NonNull MenuBuilder menu) {

            }
        });
        optionMenu.show();
    }
    }
