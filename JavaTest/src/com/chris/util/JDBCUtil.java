package com.chris.util;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 * Created by Chris on 2017/11/10.
 */
public class JDBCUtil {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/yto";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    /*
     * 创建连接池BasicDataSource
     */
    public static BasicDataSource dataSource = new BasicDataSource();
    //静态代码块
    static {
        //对连接池对象 进行基本的配置
        dataSource.setDriverClassName(DRIVER); // 这是要连接的数据库的驱动
        dataSource.setUrl(URL); //指定要连接的数据库地址
        dataSource.setUsername(USERNAME); //指定要连接数据的用户名
        dataSource.setPassword(PASSWORD); //指定要连接数据的密码
//        dataSource.setMaxActive(10);//最大连接数量
//        dataSource.setMinIdle(1);//最小空闲连接数
//        dataSource.setMaxIdle(5);//最大空闲连接数
//        dataSource.setInitialSize(10);//初始化连接

    }
    /*
     * 返回连接池对象
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

}
