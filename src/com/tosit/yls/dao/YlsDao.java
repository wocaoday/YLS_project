package com.tosit.yls.dao;

import com.tosit.yls.entiy.DataFile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2016/9/26.
 */
public class YlsDao {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //查询数据库内容
    public List<DataFile> query() {
        DataFile dataFile=new DataFile();
        List<DataFile> listData=new ArrayList<>();
        Connection conn=null;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/download","root","root");
            PreparedStatement ps=conn.prepareStatement("select * from uploadlist");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String column=rs.getString("username");
                String content=rs.getString("realName");
                //把取到的id等信息添加到集合里面
                dataFile.setColumn(column);
                dataFile.setContent(content);

                listData.add(dataFile);
            }
            return listData;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        YlsDao ylsDao=new YlsDao();
       // DataFile dataFile=new DataFile();
       // uploadDao.setupload(DataFile);
        ylsDao.query();

    }
}
