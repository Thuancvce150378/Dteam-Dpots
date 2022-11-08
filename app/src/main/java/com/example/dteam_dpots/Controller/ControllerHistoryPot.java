package com.example.dteam_dpots.Controller;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dteam_dpots.*;
import com.example.dteam_dpots.Beans.*;
import com.example.dteam_dpots.Model.ModelHistoryPot;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerHistoryPot extends AppCompatActivity {
    private ModelHistoryPot _model = new ModelHistoryPot();
    private MenuBuilder menuBuilder;
    private RecyclerView rcvItemName;
    private RecyclerView rcvBillGroup;

    private RecyclerView.LayoutManager RecyclerViewLayoutManager;
    private ListItemAdapter adapterListItemName;
    private LinearLayoutManager HorizontalLayout;
    private ListGroupBillAdapter adapterListGroupBill;
    private LinearLayoutManager BillGroupLayoutManger;
    private List<Bill> listBill;
    private List<PotItem> listPotItem;
    private String currentItemName = "All";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_pot);
        String PotName = getIntent().getStringExtra("potName");

        Pot pot = _model.GetPot(PotName); //get data current pot

        TextView txtPotName = findViewById(R.id.txtpotName);
        txtPotName.setText(pot.getFullName());

        TextView txtPotAmount = findViewById(R.id.txtPotAmount);
        txtPotAmount.setText(_model.doubleToMoneyVND(_model.getPotAmount()));

        ImageButton back = findViewById(R.id.ibBackHistoryPot);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView txtPotBalance = findViewById(R.id.txtPotBalance);
        txtPotBalance.setText(_model.doubleToMoneyVND(_model.getPotBalance()));
        listPotItem = _model.GetPotItem(PotName);

        rcvItemName = findViewById(R.id.recyclerview);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcvItemName.setLayoutManager(RecyclerViewLayoutManager);
        adapterListItemName = new ListItemAdapter(listPotItem);
        HorizontalLayout = new LinearLayoutManager(
                ControllerHistoryPot.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        rcvItemName.setLayoutManager(HorizontalLayout);
        rcvItemName.setAdapter(adapterListItemName);
        //
        BillGroupLayoutManger
                = new LinearLayoutManager(
                getApplicationContext());
        listBill = _model.getBill("All");
        //list date from bill

        rcvBillGroup = findViewById(R.id.RecyclerViewGroupBill);
        rcvBillGroup.setLayoutManager(BillGroupLayoutManger);
        adapterListGroupBill = new ListGroupBillAdapter(listBill);

        rcvBillGroup.setLayoutManager(BillGroupLayoutManger);
        rcvBillGroup.setAdapter(adapterListGroupBill);

        menuBuilder = new MenuBuilder(this);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.popupmenuoptionchoice, menuBuilder);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onResume() {
        super.onResume();
        updateHistory(currentItemName);
    }


    @SuppressLint("RestrictedApi")
    public void PopupMenuHistoryPot(MenuBuilder a, View view, Bill pill) {
        @SuppressLint("RestrictedApi") MenuPopupHelper optionMenu = new MenuPopupHelper(this, a, view);
        optionMenu.setForceShowIcon(true);
        menuBuilder.setCallback(new MenuBuilder.Callback() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onMenuItemSelected(@NonNull MenuBuilder menu, @NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_edit:
                        Intent intent = new Intent(ControllerHistoryPot.this, ControllerEditTransaction.class);
                        intent.putExtra("PillID", pill.getID());
                        startActivity(intent);
                        return true;
                    case R.id.menu_remove:
                        try {
                            boolean result = _model.deleteBill(pill);
                            if (result) {
                                updateHistory(currentItemName);
                            } else {
                                Toast.makeText(ControllerHistoryPot.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            Toast.makeText(ControllerHistoryPot.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void updateHistory(String itemName) {
        _model.updatePot();
        this.listBill = this._model.getBill(itemName);
        //bills remove all same bill
        //update Recycle view
        adapterListGroupBill = new ListGroupBillAdapter(this.listBill);
        rcvBillGroup.setAdapter(adapterListGroupBill);
        adapterListGroupBill.notifyDataSetChanged();
    }

    // list_item adapter
    class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListItemName> {

        private List<String> list;

        ListItemAdapter(List<PotItem> list) {
            this.list = new ArrayList<>();
            this.list.add("All");
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
            return this.list.size();
        }

        class ListItemName extends RecyclerView.ViewHolder {
            TextView textView;

            public ListItemName(@NonNull View itemView) {
                super(itemView);
                textView = (TextView) itemView
                        .findViewById(R.id.pot_name);
                textView.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View view) {
                        updateHistory(textView.getText().toString());
                    }
                });
            }
        }
    }

    class ListGroupBillAdapter extends RecyclerView.Adapter<ListGroupBillAdapter.GroupBill> {
        private List<Bill> list;
        private List<Date> AllDate;

        @RequiresApi(api = Build.VERSION_CODES.N)
        ListGroupBillAdapter(List<Bill> bills) {
            bills.stream().sorted((b1, b2) -> b2.getDate().compareTo(b1.getDate()));
            this.list = bills;
            //sort alldate
            this.AllDate = bills.stream().map(bill -> bill.getDate()).collect(Collectors.toSet()).stream().sorted((e, d) -> d.compareTo(e)).collect(Collectors.toList());
        }

        @NonNull
        @Override
        public GroupBill onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_groub_item, parent, false);
            return new GroupBill(itemView);
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onBindViewHolder(@NonNull GroupBill holder, int position) {
            //get obj Date at position
            Date date = this.AllDate.get(position);
            // Set the text of each item of Recycler view with the list items
            //get day in week
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            String day = "";
            switch (dayOfWeek) {
                case 1:
                    day = "Chủ nhật";
                    break;
                case 2:
                    day = "Thứ hai";
                    break;
                case 3:
                    day = "Thứ ba";
                    break;
                case 4:
                    day = "Thứ tư";
                    break;
                case 5:
                    day = "Thứ năm";
                    break;
                case 6:
                    day = "Thứ sáu";
                    break;
                case 7:
                    day = "Thứ bảy";
                    break;
            }
            holder.txtDay.setText(day);
            //get month in year
            int month = calendar.get(Calendar.MONTH);
            holder.txtMonth.setText(month + 1 + "-");

            //get year
            int year = calendar.get(Calendar.YEAR);
            holder.txtYear.setText(year + "");
            //get date
            int dateOfMonth = calendar.get(Calendar.DATE);
            holder.txtDated.setText(dateOfMonth + "");
            List<Bill> BillInday = this.list.stream().filter(bill -> bill.getDate().equals(date)).collect(Collectors.toList());
            int total = 0;
            for (Bill bill : BillInday) {
                total += bill.getCurrency();
                holder.addBillDetail(bill);
            }
            holder.txtTotal.setText(total + "");
        }

        @Override
        public int getItemCount() {
            return this.AllDate.size();
        }

        class GroupBill extends RecyclerView.ViewHolder {
            TableLayout tableLayout;
            TextView txtDated;
            TextView txtDay;
            TextView txtMonth;
            TextView txtYear;
            TextView txtTotal;

            public GroupBill(@NonNull View itemView) {
                super(itemView);
                tableLayout = itemView.findViewById(R.id.group_bill);
                txtDated = itemView.findViewById(R.id.txtDated);
                txtDay = itemView.findViewById(R.id.txtDay);
                txtMonth = itemView.findViewById(R.id.txtMonth);
                txtYear = itemView.findViewById(R.id.txtYear);
                txtTotal = itemView.findViewById(R.id.txtTotal);
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            void addBillDetail(Bill bill) {
                TextView itemName;
                TextView itemDescription;
                TextView price;
                ImageButton ibOptionChoicePotHistory;
                ImageView history_item_icon;

                View view = LayoutInflater.from(itemView.getContext()).inflate(R.layout.history_item, null);
                itemName = view.findViewById(R.id.itemName);
                itemDescription = view.findViewById(R.id.itemDescription);
                price = view.findViewById(R.id.price);
                ibOptionChoicePotHistory = view.findViewById(R.id.ibOptionChoicePotHistory);
                history_item_icon = view.findViewById(R.id.history_item_icon);

                itemName.setText(_model.GetPotItemName(bill.getID_Pottem()));
                itemDescription.setText(bill.getDescription());
                price.setText(_model.doubleToMoneyVND(bill.getCurrency()) + "");
                ibOptionChoicePotHistory.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PopupMenuHistoryPot(menuBuilder, view, bill);
                    }
                });
                history_item_icon.setImageResource(bill.getPotItem().getPicture());
                tableLayout.addView(view);
            }

        }

        class ItemBill extends RecyclerView.ViewHolder {
            TextView itemName;
            TextView itemDescription;
            TextView price;
            ImageButton ibOptionChoicePotHistory;
            ImageView history_item_icon;

            public ItemBill(@NonNull View itemView) {
                super(itemView);
                itemName = itemView.findViewById(R.id.itemName);
                itemDescription = itemView.findViewById(R.id.itemDescription);
                price = itemView.findViewById(R.id.price);
                ibOptionChoicePotHistory = itemView.findViewById(R.id.ibOptionChoicePotHistory);
                history_item_icon = itemView.findViewById(R.id.history_item_icon);
            }
        }
    }


}