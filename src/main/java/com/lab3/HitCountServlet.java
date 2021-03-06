package com.lab3;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HitCountServlet",value = "/HitCountServlet")
public class HitCountServlet extends HttpServlet {
    @Override
    public void init() throws ServletException{
        ServletContext context = getServletContext();
        //2.保存参数
        context.setAttribute("visitTimes", 0);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            response.setContentType("text/html;charset=utf-8");

            PrintWriter out =  response.getWriter();


            ServletContext context = getServletContext();
            int times = (Integer) context.getAttribute("visitTimes");

            times++;

            context.setAttribute("visitTimes", times);
            out.print("<body><center><h1>Total Number of Hits</h1><h2>"+times+"</h2></body></center>");
            System.out.println("我被访问了！"+times);
    }
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
          doGet(request,response);
    }
}
