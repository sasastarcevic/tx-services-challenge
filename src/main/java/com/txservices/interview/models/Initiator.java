package com.txservices.interview.models;

import org.springframework.data.mongodb.core.index.Indexed;

public class Initiator {

    private String name;

    @Indexed
    private String email;
    private boolean notify;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }
}
