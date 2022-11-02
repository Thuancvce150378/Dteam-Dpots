package com.example.dteam_dpots.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dteam_dpots.*;
import com.example.dteam_dpots.Beans.*;
import com.example.dteam_dpots.Model.ModelHistoryPot;

import java.util.ArrayList;
import java.util.List;

public class ControllerHistoryPot extends AppCompatActivity {
    ModelHistoryPot _model = new ModelHistoryPot();
    ImageButton ibOptionChoice;
    MenuBuilder menuBuilder;
    RecyclerView list_item;
    ArrayList<PotItem> PotItemList;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    ListItemAdapter adapter;
    LinearLayoutManager HorizontalLayout;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_pot);
        String PotName = getIntent().getStringExtra("potName");

        list_item = findViewById(R.id.recyclerview);
        PotItemList = _model.GetPotItem(PotName);
        RecyclerViewLayoutManager
                = new LinearLayoutManager(
                getApplicationContext());
        list_item.setLayoutManager(
                RecyclerViewLayoutManager);

        adapter = new ListItemAdapter(PotItemList);
        HorizontalLayout
                = new LinearLayoutManager(
                ControllerHistoryPot.this,
                LinearLayoutManager.HORIZONTAL,
                false);

        list_item.setLayoutManager(HorizontalLayout);
        list_item.setAdapter(adapter);

        ibOptionChoice = findViewById(R.id.ibOptionChoicePotHistory);
        menuBuilder = new MenuBuilder(this);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.popupmenuoptionchoice, menuBuilder);

        ibOptionChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenuHistoryPot(menuBuilder, view);
            }
        });
    }

    @SuppressLint("RestrictedApi")
    public void PopupMenuHistoryPot(MenuBuilder a, View view) {
        @SuppressLint("RestrictedApi") MenuPopupHelper optionMenu = new MenuPopupHelper(this, a, view);
        optionMenu.setForceShowIcon(true);
        menuBuilder.setCallback(new MenuBuilder.Callback() {
            @Override
            public boolean onMenuItemSelected(@NonNull MenuBuilder menu, @NonNull MenuItem item) {
                switch (item.getItemId()) {
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
    public void updateHistory(String itemName){

    }
    // list_item adapter
    class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListItemName> {

        private List<String> list;

        ListItemAdapter(List<PotItem> list) {
            this.list = new ArrayList<>();
            for (PotItem item : list) {
                this.list.add(item.getName());
            }
        }

        @NonNull
        @Override
        public ListItemName onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView
                    = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.pot_item_name,
                            parent,
                            false);
            // return itemView
            return new ListItemName(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ListItemName holder, int position) {
            // Set the text of each item of
            // Recycler view with the list items
            holder.textView.setText(list.get(position));

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ListItemName extends RecyclerView.ViewHolder {
            TextView textView;

            public ListItemName(@NonNull View itemView) {
                super(itemView);
                textView = (TextView) itemView
                        .findViewById(R.id.pot_name);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        updateHistory(textView.getText().toString());
                    }
                });
            }
        }
    }
}