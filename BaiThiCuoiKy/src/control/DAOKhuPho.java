package control;

import static control.DBcontext.conn;
import static control.DBcontext.getData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoDan;
import model.KhuPho;

public class DAOKhuPho {

    public List<KhuPho> GetAllList() {
        List<KhuPho> list = new ArrayList<>();
        String sql = "select*from KHUPHO";
        ResultSet result = getData(sql);
        try {
            while (result.next()) {
                String makhupho = result.getString(1);
                String tenkhupho = result.getString(2);
                KhuPho kp = new KhuPho(makhupho, tenkhupho);
                list.add(kp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public int addKhuPho(KhuPho kp) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[KHUPHO]\n"
                + "           ([maKhuPho],[tenKhuPho])\n"
                + "     VALUES (?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, kp.getMaKhuPho());
            pre.setString(2, kp.getTenKhuPho());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhuPho.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public boolean checkDuplicateKhuPho(String MaKhuPho){
        boolean check = false;
        String sql = "select*from KHUPHO where maKhuPho = '"+MaKhuPho+"'";
        ResultSet rs = getData(sql);
        try {
            if(rs.next()){
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhuPho.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    
    public int removeNguoi(String id) {
        int n = 0;
        String sql = "delete from Nguoi where [maHoDan]='" + id + "'";
        // check foreign key costain
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public int removeHoDan(String id) {
        int n = 0;
        String sql = "delete from HoDan where [maKhuPho]='" + id + "'";
        // check foreign key costain
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public int removeKhuPho(String id) {
        int n = 0;
        String sql = "delete from KhuPho where [maKhuPho]='" + id + "'";
        // check foreign key costain
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public List<HoDan> GetHoDan(String maKhuPho){
        List<HoDan> list = new ArrayList<>();
        ResultSet rs = getData("select * from HoDan where maKhuPho = '"+ maKhuPho + "'");
        try {
            while(rs.next()){
                HoDan hd = new HoDan(rs.getString(1), rs.getString(3), rs.getInt(2), rs.getString(4));
                list.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhuPho.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public KhuPho GetKhuPho(String maKhuPho){
        ResultSet rs = getData("select * from KhuPho where maKhuPho = '"+ maKhuPho + "'");
        KhuPho kp = new KhuPho();
        try {
            if(rs.next()){
                kp = new KhuPho(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhuPho.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kp;
    }
    
    public int UpdateKhuPho(String KhuPho, String tenKhuPho) {
        int n = 0;
        String sql = "UPDATE [dbo].[KhuPho]\n"
                + "   SET [tenKhuPho] = '" + tenKhuPho + "'\n"
                + " where maKhuPho = '" + KhuPho + "'";
        try {
           PreparedStatement pre = conn.prepareStatement(sql);
           n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOHoDan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
