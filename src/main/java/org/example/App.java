package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        Connection connection;
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/CGI","newuser","password");
        System.out.println( "Connection Connected"+connection );
        Statement stat=connection.createStatement();
        ResultSet resultSet=stat.executeQuery("select * from consumer");
        while (resultSet.next()){
            System.out.println(resultSet.getNString("consumer_name"));
        }
        PreparedStatement pstat=connection.prepareStatement("insert into consumer(consumer_id,consumer_name,city,grade,rep_id) values(?,?,?,?,?)");
        pstat.setInt(1,10000);
        pstat.setString(2,"nitheesh");
        pstat.setString(3,"vijayawada");
        pstat.setString(4,"500");
        pstat.setInt(5,1007);
        pstat.execute();

    }
}
