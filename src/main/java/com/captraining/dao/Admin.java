package com.captraining.dao;

import com.captraining.annotation.RoleRequired;
import com.captraining.entity.User;

@RoleRequired(role = "admin")
public class Admin extends User {

    public Admin(String id, String name) {
        super(id, name);
    }

    @Override
    public void showProfile() {

    }


}
