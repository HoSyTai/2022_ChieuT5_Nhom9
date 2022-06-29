package com.example.demo1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SignupControl", value = "/signup")
public class SignupControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        String mail = request.getParameter("mail");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
//        if(!pass.equals(re_pass)){
//            response.sendRedirect("Login.jsp");
//        }else{
//            DAO dao = new DAO();
//            Account a = dao.checkAccountExist(user);
//            if(a == null){
//                //dc signup
//                dao.singup(user, pass, mail);
//                response.sendRedirect("home");
//            }else{
//                //day ve trang login.jsp
//                response.sendRedirect("Login.jsp");
//            }
//        }
        //sign up
        if (user.equals("")){
            request.setAttribute("mess3","Vui lòng nhập username!");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if (mail.equals("")) {
            request.setAttribute("mess4", "Vui lòng nhập email!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else  if (pass.equals("")){
            request.setAttribute("mess5","Vui lòng nhập mật khẩu!");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } else if (!pass.equals(re_pass)){
            request.setAttribute("mess1","Vui lòng nhập lại mật khẩu!");
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }else {
            DAO dao = new DAO();
            Account account = dao.checkAccountExit(user);
            if (account==null){
                dao.signUp(user,pass,mail);
                response.sendRedirect("login.jsp");
            }
            else {
                request.setAttribute("mess2","Username đã tồn tại!");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
