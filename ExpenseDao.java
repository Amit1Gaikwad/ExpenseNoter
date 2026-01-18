package servletproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDao {

    // DB Connection (same as EmpDao)
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dmart", "root", "root");

        if (con != null) {
            System.out.println("Connection created");
        } else {
            System.out.println("Connection not created");
        }
        return con;
    }

    // ✅ SAVE EXPENSE
    public static int save(Expense e) {
        int st = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                "insert into expense(city,date,day,product,amount) values(?,?,?,?,?)");

            ps.setString(1, e.getCity());
            ps.setString(2, e.getDate());
            ps.setString(3, e.getDay());
            ps.setString(4, e.getProduct());
            ps.setInt(5, e.getAmount());

            st = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return st;
    }

	
    // ✅ GET ALL EXPENSES
    
    public static List<Expense> getAllExpense() {
        List<Expense> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from expense");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Expense e = new Expense();
                e.setId(rs.getInt(1));
                e.setCity(rs.getString(2));
                e.setDate(rs.getString(3));
                e.setDay(rs.getString(4));
                e.setProduct(rs.getString(5));
                e.setAmount(rs.getInt(6));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    } 

    // ✅ GET EXPENSE BY ID
    
    public static Expense getExpense(int id) {
        Expense e = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                "select * from expense where id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                e = new Expense();
                e.setId(rs.getInt(1));
                e.setCity(rs.getString(2));
                e.setDate(rs.getString(3));
                e.setDay(rs.getString(4));
                e.setProduct(rs.getString(5));
                e.setAmount(rs.getInt(6));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    // ✅ UPDATE EXPENSE
    
    public static int update(Expense e) {
        int st = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                "update expense set city=?,date=?,day=?,product=?,amount=? where id=?");

            ps.setString(1, e.getCity());
            ps.setString(2, e.getDate());
            ps.setString(3, e.getDay());
            ps.setString(4, e.getProduct());
            ps.setInt(5, e.getAmount());
            ps.setInt(6, e.getId());

            st = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return st;
    }

    // ✅ DELETE EXPENSE
    
    public static int delete(int id) {
        int st = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                "delete from expense where id=?");
            ps.setInt(1, id);

            st = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return st;
    }
}
