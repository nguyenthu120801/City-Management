/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static control.DBcontext.conn;
import static control.DBcontext.getData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import model.HoDan;

/**
 *
 * @author PC
 */
public class DAOHoDan {

    public int addHoDan(HoDan hd) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[HODAN]\n"
                + "           ([maHoDan]\n"
                + "           ,[soThanhVien]\n"
                + "           ,[soNha]\n"
                + "           ,[maKhuPho])\n"
                + "     VALUES (?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, hd.getMaHoDan());
            pre.setInt(2, hd.getSoThanhVien());
            pre.setString(3, hd.getSoNha());
            pre.setString(4, hd.getMaKhuPho());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOHoDan.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int GetSoThanhVien(String MaHoDan) {
        int n = 0;
        String sql = "select count(maNguoi) from NGUOI where maHoDan = '" + MaHoDan + "'";
        ResultSet rs = getData(sql);
        try {
            if (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOHoDan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public boolean checkDuplicateHoDan(String MaHoDan) {
        boolean check = false;
        String sql = "select*from HODAN where maHoDan = '" + MaHoDan + "'";
        ResultSet rs = getData(sql);
        try {
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhuPho.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public int UpdateSoThanhVien(String MaHoDan, int soThanhVien) {
        int n = 0;
        String sql = "UPDATE [dbo].[HODAN]\n"
                + "   SET [soThanhVien] = " + soThanhVien + "\n"
                + " where maHoDan = '" + MaHoDan + "'";
        try {
           PreparedStatement pre = conn.prepareStatement(sql);
           n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOHoDan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int UpdateSoNha(String MaHoDan, String soNha) {
        int n = 0;
        String sql = "UPDATE [dbo].[HODAN]\n"
                + "   SET [soNha] = '" + soNha + "'\n"
                + " where maHoDan = '" + MaHoDan + "'";
        try {
           PreparedStatement pre = conn.prepareStatement(sql);
           n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOHoDan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
