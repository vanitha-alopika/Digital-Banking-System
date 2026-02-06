package com.bank.service;

import java.sql.*;
import com.bank.util.DBConnection;

public class BankService {

public static void createAccount(String name, String pin, double balance) {
    try (Connection con = DBConnection.getConnection()) {
        String sql = "INSERT INTO accounts(name,pin,balance) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, pin);
        ps.setDouble(3, balance);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static boolean login(int accNo, String pin) {
    try (Connection con = DBConnection.getConnection()) {
        String sql = "SELECT * FROM accounts WHERE acc_no=? AND pin=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, accNo);
        ps.setString(2, pin);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

public static void deposit(int accNo, double amount) {
    try (Connection con = DBConnection.getConnection()) {

        // update balance
        String sql = "UPDATE accounts SET balance = balance + ? WHERE acc_no = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, amount);
        ps.setInt(2, accNo);
        ps.executeUpdate();

        // insert transaction
        String txnSql = "INSERT INTO transactions(acc_no, type, amount) VALUES (?, 'DEPOSIT', ?)";
        PreparedStatement tps = con.prepareStatement(txnSql);
        tps.setInt(1, accNo);
        tps.setDouble(2, amount);
        tps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}


public static boolean withdraw(int accNo, double amount) {
    try (Connection con = DBConnection.getConnection()) {

        String check = "SELECT balance FROM accounts WHERE acc_no=?";
        PreparedStatement cps = con.prepareStatement(check);
        cps.setInt(1, accNo);
        ResultSet rs = cps.executeQuery();

        if (rs.next() && rs.getDouble("balance") >= amount) {

            String sql = "UPDATE accounts SET balance = balance - ? WHERE acc_no=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setInt(2, accNo);
            ps.executeUpdate();

            // insert transaction
            String txnSql = "INSERT INTO transactions(acc_no, type, amount) VALUES (?, 'WITHDRAW', ?)";
            PreparedStatement tps = con.prepareStatement(txnSql);
            tps.setInt(1, accNo);
            tps.setDouble(2, amount);
            tps.executeUpdate();

            return true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}


public static double checkBalance(int accNo) {
    try (Connection con = DBConnection.getConnection()) {
        String sql = "SELECT balance FROM accounts WHERE acc_no=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, accNo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) return rs.getDouble("balance");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}

}
