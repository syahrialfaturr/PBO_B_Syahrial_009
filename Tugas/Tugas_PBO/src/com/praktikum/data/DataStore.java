package com.praktikum.data;

import com.praktikum.users.User;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.data.Item;

import java.util.ArrayList;

public class DataStore {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    static {
        userList.add(new Admin("Syahrial", "009", "Admin009", "Password009"));
        userList.add(new Mahasiswa("Syahrial Nur Faturrahman", "202410370110009"));

        reportedItems.add(new Item("Hp", "iphone 16", "Kantek"));
        reportedItems.add(new Item("Kunci Motor", "Vespa matic", "ICT"));
    }
}
