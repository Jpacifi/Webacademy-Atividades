package br.ufac.sgcm.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        if (username != null && password != null && username.equals("admin") && password.equals("admin123")) {
            res.sendRedirect("sgcm\\src\\main\\webapp\\index.jsp");
        } else {
            res.sendRedirect("login.jsp");
        }
    }
}
