package com.sifterstudios.postmanquiz.part4;

import java.util.List;
public class UserDatabase {
    public static UserDatabase users = new UserDatabase();
    private List<User> all;

    public void setAll(List<User> all) {
        this.all = all;
    }


    public UserDatabase() {
        all = List.of(
                new User(12, "Kari", "Nordmann", "kari@nordmann.no", PaymentType.PAYPAL),
                new User("Tormod", "Liseth", "tormod@liseth.no"));
    }

    public List<User> getAll() {
        return all;
    }

    public void addUser(User user) {
        all.add(user);
    }
}
