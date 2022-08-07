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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Nguoi;

/**
 *
 * @author PC
 */
public class DAONguoi {

    public int addNguoi(Nguoi n) {
        int a = 0;
        String sql = "INSERT INTO [dbo].[NGUOI]\n"
                + "           ([maNguoi]\n"
                + "           ,[hoVaTen]\n"
                + "           ,[tuoi]\n"
                + "           ,[namSinh]\n"
                + "           ,[ngheNghiep]\n"
                + "           ,[maHoDan])\n"
                + "     VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, n.getMaNguoi());
            pre.setString(2, n.getHoVaTen());
            pre.setInt(3, n.getTuoi());
            pre.setInt(4, n.getNamSinh());
            pre.setString(5, n.getNgheNghiep());
            pre.setString(6, n.getMaHoDan());
            a = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAONguoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public boolean checkDuplicateNguoi(String nguoi) {
        boolean check = false;
        String sql = "select*from NGUOI where maNguoi = '" + nguoi + "'";
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

    public List<Nguoi> GetNguoi(String maHoDan) {
        List<Nguoi> list = new ArrayList<>();
        ResultSet rs = getData("select * from Nguoi where maHoDan = '" + maHoDan + "'");
        try {
            while (rs.next()) {
                Nguoi n = new Nguoi(rs.getString(1), rs.getInt(3), rs.getInt(4), rs.getString(2), rs.getString(5), rs.getString(6));
                list.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhuPho.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int UpdateNguoi(Nguoi nguoi) {
        int n = 0;
        String sql = "UPDATE [dbo].[NGUOI]\n"
                + "   SET [hoVaTen] = ?\n"
                + "      ,[tuoi] = ?\n"
                + "      ,[namSinh] = ?\n"
                + "      ,[ngheNghiep] = ?\n"
                + " WHERE maNguoi = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, nguoi.getHoVaTen());
            pre.setInt(2, nguoi.getTuoi());
            pre.setInt(3, nguoi.getNamSinh());
            pre.setString(4, nguoi.getNgheNghiep());
            pre.setString(5, nguoi.getMaNguoi());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOHoDan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
