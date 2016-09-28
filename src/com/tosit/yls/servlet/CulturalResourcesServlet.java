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
 */
@WebServlet("/culturalResources")
public class CulturalResourcesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");


        List<DataFile> dataFiles=new YlsDao().query();

        int s= Integer.parseInt(req.getParameter("str_id"));
        req.setAttribute("str",s);

        int x= Integer.parseInt(req.getParameter("cultural_id"));
        req.setAttribute("sid",x);
        //System.out.println("这是返回回来的："+x);

        req.setAttribute("dataFiles",dataFiles);
        req.getRequestDispatcher("threeLevel/culturalResources.jsp").forward(req,resp);
    }
}
