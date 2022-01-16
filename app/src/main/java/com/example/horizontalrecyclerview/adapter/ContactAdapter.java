package com.example.horizontalrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.horizontalrecyclerview.R;
import com.example.horizontalrecyclerview.model.Contact;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Contact> contacts = new ArrayList<>();

    public ContactAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_layout, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Contact contact = contacts.get(position);

        if (holder instanceof ContactViewHolder) {
            ((ContactViewHolder) holder).name.setText(contact.getName());
            ((ContactViewHolder) holder).number.setText(contact.getNumber());
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView name;
        TextView number;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            name = view.findViewById(R.id.tv_contact_name);
            number = view.findViewById(R.id.tv_contact_number);
        }
    }
}
