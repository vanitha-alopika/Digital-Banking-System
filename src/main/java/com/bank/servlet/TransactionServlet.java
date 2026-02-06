package com.bank.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/transactions")
public class TransactionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        Integer accNo = (Integer) req.getSession().getAttribute("accNo");

        if (accNo == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        List<String[]> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT type, amount, txn_date FROM transactions WHERE acc_no=? ORDER BY txn_date DESC";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accNo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new String[]{
                    rs.getString("type"),
                    rs.getString("amount"),
                    rs.getString("txn_date")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("transactions", list);
        req.getRequestDispatcher("transactions.jsp").forward(req, res);
    }
}
