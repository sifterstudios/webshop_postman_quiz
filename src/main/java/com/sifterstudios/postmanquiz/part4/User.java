package com.sifterstudios.postmanquiz.part4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class User {
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private PaymentType preferedPaymentType; // Typo in PostMan tests, need to match here!
    private static List<User> allCreatedUsers;

    public User(int id, String firstName, String lastName, String email, PaymentType preferedPaymentType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.preferedPaymentType = preferedPaymentType;
        if (allCreatedUsers == null) allCreatedUsers = new ArrayList<>();
        allCreatedUsers.add(this);
    }

    public User(String firstName, String lastName, String email) {
        id = getUniqueId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        preferedPaymentType = PaymentType.CARD;
        if (allCreatedUsers == null) allCreatedUsers = new ArrayList<>();
        allCreatedUsers.add(this);
    }

    public int getId() {
        return id;
    }

    private int getUniqueId() {
        boolean unique = false;
        int candidate = -1;
        while (!unique) {
            candidate = ThreadLocalRandom.current().nextInt();
            for (User user : allCreatedUsers) {
                if (user.getId() == candidate) continue;
                else unique = true;
            }
        }
        return candidate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PaymentType getPreferedPaymentType() {
        return preferedPaymentType;
    }

    public void setPreferedPaymentType(PaymentType preferedPaymentType) {
        this.preferedPaymentType = preferedPaymentType;
    }
}
