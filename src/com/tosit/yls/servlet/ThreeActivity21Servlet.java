package com.tosit.yls.servlet;

import com.tosit.yls.dao.YlsDao;
import com.tosit.yls.entiy.DataFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by DELL on 2016/9/27.
 */   //景区新闻2.1详情
@WebServlet("/threeActivity21")
public class ThreeActivity21Servlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;chartset=utf-8");

        List<DataFile> dataFiles=new YlsDao().query();
        //传递一个str过去
        int s= Integer.parseInt(req.getParameter("str_id"));
        req.setAttribute("str",s);
       // System.out.println(s);
//
        int x= Integer.parseInt(req.getParameter("activity_id1"));
         req.setAttribute("sid",x);
       // System.out.println(x);
        req.setAttribute("dataFiles",dataFiles);
        req.getRequestDispatcher("threeLevel/activity.jsp").forward(req,resp);
    }
}
