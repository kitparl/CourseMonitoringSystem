package com.authentication;

import com.exceptions.AdminException;
import com.model.Course;

public interface Authentic {
    String login(String username, String password) throws AdminException;
}
