package com.chris.test;

import com.chris.util.DBUtil;
import com.chris.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chris on 2017/3/18.
 */
public class DBListTest {

    public static void main(String[] args) {
        DBListTest test = new DBListTest();
//        test.insert();
        test.list();
//        testResultSetMetaData();
//        testPreparedStatement();
//        testDelete();
//        testCallableStatement3();
    }

    @Test
    //演示使用数据库连接池
    public void dataSource(){
        try {
            //获取一个用来执行SQL语句的对象   QueryRunner
            QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "INSERT INTO UserTbl(id,username,password,age) VALUES(?,?,?,?)";
            Object[] params = {7, "sally", "987654", 31};
            int line = qr.update(sql,params);
            //结果集处理
            System.out.println("line = " + line);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //删除功能
    @Test
    public void delete(){
        try {
            //创建一个QueryRunner对象，用来完成SQL语句的执行
            QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
            //执行SQL语句
            String sql = "DELETE FROM UserTbl WHERE username = ?";
            Object[] params = {"hanmeimei"};
            int line = qr.update(sql, params);
            //结果集的处理
            System.out.println("line="+line);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    //使用QueryRunner实现对数据库的增删改
    public void insert(){
        try {
            //获取一个用来执行SQL语句的对象   QueryRunner
            QueryRunner qr = new QueryRunner();

            String sql = "INSERT INTO UserTbl(id,username,password) VALUES(?,?,?)";
            Object[] params = {"6", "hanmeimei", "123abc"};

            DBUtil util = new DBUtil();
            Connection conn = util.openConnection();
            int line = qr.update(conn,sql,params);// 用来完成表数据的增加、删除、更新操作
            //结果集处理
            System.out.println("line = " + line);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.Test
    public void queryArrayHandler(){
        try {
            //获取QueryRunner对象
            QueryRunner qr = new QueryRunner();
            //执行SQL语句
            String sql = "SELECT * FROM UserTbl";
            Object[] params = {};
            DBUtil util = new DBUtil();
            Connection conn = util.getConnection();
            //ArrayHandler返回第一条数组数据
            Object[] objArray = qr.query(conn, sql, new ArrayHandler(), params);
            //结果集的处理
            System.out.println( Arrays.toString(objArray) );

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryArrayListHandler(){
        try {
            //获取QueryRunner对象
            QueryRunner qr = new QueryRunner();
            //执行SQL语句
            String sql = "SELECT * FROM UserTbl WHERE age>?";
            Object[] params = {20};
            DBUtil util = new DBUtil();
            Connection conn = util.getConnection();
            List<Object[]> list = qr.query(conn, sql, new ArrayListHandler(), params);
            //结果集的处理
            for (Object[] objArray : list) {
                System.out.println(  Arrays.toString(objArray) );
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryBeanHandler(){
        try{
            //获取QueryRunner
            QueryRunner qr = new QueryRunner();
            //执行SQL语句
            String sql = "SELECT * FROM UserTbl WHERE id=?";
            Object[] params = {1};
            DBUtil util = new DBUtil();
            Connection conn = util.getConnection();
            User zw;
            zw = qr.query(conn, sql, new BeanHandler<>(User.class), params);
            //结果集处理
            System.out.println(zw);

            conn.close();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Test
    public void queryBeanListHandler(){
        try{
            //获取QueryRunner
            QueryRunner qr = new QueryRunner();
            //执行SQL语句
            String sql = "SELECT * FROM UserTbl WHERE age>=? or age is null";
            Object[] params = {20};
            DBUtil util = new DBUtil();
            Connection conn = util.getConnection();
            List<User> list = qr.query(conn, sql, new BeanListHandler<>(User.class), params);
            //结果集处理
            for (User user : list)
                System.out.println(user);

            conn.close();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    static void testCallableStatement3() {
        DBUtil util = new DBUtil();
        Connection conn = util.openConnection();
        String call_sql = "{call getPwdByName(?,?)}";

        try {
            CallableStatement cstmt = conn.prepareCall(call_sql);
            cstmt.setString(1, "dog");
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.execute();
            String pwd = cstmt.getString(2);
            System.out.println("pwd = "+pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.closeConnection(conn);
        }
    }

    static void testDelete() {
        DBUtil util = new DBUtil();
        Connection conn = util.openConnection();
        String sql = "delete from UserTbl where  username = \"cat\" ";
        //update
        String updateSql = "update UserTbl set username = ?, password = ? where id = ?";
        //query
        String querySql = "select id,username,password from UserTbl where id > 2";
        //calltest
        String call_sql = "{call all_user()}";

        try{

            CallableStatement callableStatement = conn.prepareCall(call_sql);
            ResultSet rs = callableStatement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(id+":"+username+":"+password);
            }
//            Statement stm = conn.createStatement();
//            stm.executeUpdate(sql);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void testPreparedStatement() {
        DBUtil util = new DBUtil();
        Connection conn = util.openConnection();
        String sql = "insert into UserTbl(id, username, password) VALUES (?,?,?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "kelyy");
            preparedStatement.setString(3, "0000");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    static void testResultSetMetaData() {
        DBUtil util = new DBUtil();
        Connection conn = util.openConnection();
        String sql = "select id,username,password from UserTbl";

        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            //注意从第一行开始
            for (int i=1; i<=md.getColumnCount(); i++) {
                System.out.println(md.getColumnName(i));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void list() {
        DBUtil util = new DBUtil();
//        Connection conn = util.getConnection();
        Connection conn = util.openConnection();
        String sql = "select id,username,password from UserTbl";

        try {
//            Statement stm = conn.createStatement();
            //可更新时必须加入这两个参数
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stm.executeQuery(sql);

//            rs.absolute(1);
//            rs.updateString("username","chris");
//            rs.updateRow();

            while(rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(id+":"+username+":"+password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.closeConnection(conn);
        }
    }
}
