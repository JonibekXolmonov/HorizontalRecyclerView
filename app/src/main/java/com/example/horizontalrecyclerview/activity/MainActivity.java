package com.example.horizontalrecyclerview.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.horizontalrecyclerview.R;
import com.example.horizontalrecyclerview.adapter.ContactAdapter;
import com.example.horizontalrecyclerview.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts = new ArrayList<>();
    RecyclerView recyclerViewHorizontal;
    RecyclerView recyclerViewVertical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews() {
        recyclerViewHorizontal = findViewById(R.id.rv_contacts_horizontal);
        recyclerViewHorizontal.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false));

        recyclerViewVertical = findViewById(R.id.rv_contacts_vertical);
        recyclerViewVertical.setLayoutManager(new GridLayoutManager(this, 1));

        fillContactList();

        refreshAdapter();
    }

    void refreshAdapter() {
        ContactAdapter contactAdapter = new ContactAdapter(contacts);
        recyclerViewHorizontal.setAdapter(contactAdapter);
        recyclerViewVertical.setAdapter(contactAdapter);
    }

    void fillContactList() {
        for (int i = 1; i <= 30; i++) {
            contacts.add(new Contact("Contact_name" + i, "+(998)93-247-97-78"));
        }
    }
}