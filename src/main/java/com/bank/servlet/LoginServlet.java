package com.bank.servlet;

import java.io.IOException;

import com.bank.service.BankService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException {
		int accNo = Integer.parseInt(req.getParameter("accNo"));
		String pin = req.getParameter("pin");

		if (BankService.login(accNo, pin)) {
			System.out.println("Login success for accNo = " + accNo);
			req.getSession().setAttribute("accNo", accNo);
			res.sendRedirect(req.getContextPath() + "/dashboard.jsp");
			} else {
				res.sendRedirect(req.getContextPath() + "/login.jsp");
				}
		}
	}
