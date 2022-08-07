/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static control.DBcontext.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author PC
 */
public class DAOUserItem {
    
    public User Login(String tenTaiKhoan, String matKhau, boolean vaitro) {
        try {
            String sql = "select *from USERITEM where tenTaiKhoan = ? and matKhau = ? and vaitro = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenTaiKhoan);
            ps.setString(2, matKhau);
            ps.setBoolean(3, vaitro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User account = new User(rs.getString(1), rs.getString(2), rs.getBoolean(3));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUserItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public boolean CheckUserNameExits(){
        return true;
    }
}
