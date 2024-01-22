package com.dao;

import com.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacultyDaoImpl implements FacultyDao {
    @Override
    public String updatePassword(String username) {

        String msg = "Not Updated...";

        try (Connection con = DBUtil.provideConnection()) {
            PreparedStatement ps = con.prepareStatement("update faculty set password=? where username=?");

//            ps.setString(1, password);
            ps.setString(2, username);

            ps.executeUpdate();
            msg = "Updated...";

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return msg;
    }
}