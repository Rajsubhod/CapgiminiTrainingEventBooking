package com.captraining.dao;

import com.captraining.annotation.RoleRequired;
import com.captraining.entity.Event;
import com.captraining.entity.User;

import java.util.List;

@RoleRequired(role = "Admin")
public class Admin extends User {

    public Admin(String id, String name) {
        super(id, name);
    }

    @Override
    public void showProfile() {
        System.out.println("Admin ID: " + id + ", Name: " + name);
    }

    void removeEvent(List<Event> events, String title) {
        try {
            RoleRequired roleRequired = this.getClass().getAnnotation(RoleRequired.class);

            if (roleRequired != null && "Admin".equals(roleRequired.role())) {

                events.removeIf(event -> event.getTitle().equals(title));

                System.out.println("Event with title '" + title + "' removed successfully.");
            } else {
                System.out.println("Access denied. Only Admins can remove events.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
