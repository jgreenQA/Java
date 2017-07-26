package com.qac.library;

import java.util.ArrayList;

public class UserBase {
    private ArrayList<User> users;

    public UserBase() {
        users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUserByID(int id) {
        for (User u : users) {
            if (u.getUserID() == id) {
                return u;
            }
        }
        return null;
    }

    public User getUserByName(String name) {
        for (User u : users) {
            if (u.getUserName().equals(name)) {
                return u;
            }
        }
        return null;
    }

    public void addUser(User u) {
        users.add(u);
    }

    public void removeUser(User u) {
        users.remove(u);
    }

    public void updateAddress(User u, String address) {
        if (users.contains(u)) {
            u.setUserAddress(address);
        }
    }

    public void updatePhone(User u, int phone) {
        if (users.contains(u)) {
            u.setUserPhoneNumber(phone);
        }
    }
}
