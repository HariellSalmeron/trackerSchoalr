/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SCC_PC
 */
public class dbconnector {

    private Connection connection;

    public dbconnector() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarshipsystem", "root", "");
        } catch (SQLException e) {
            System.err.println("Cannot connect to database: " + e.getMessage());
        }

    }

    public ResultSet getData(String sql) throws SQLException {
        Statement statement = (Statement) connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }
public void insertData(String sql){

            try{
            PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sql);
            
            pstmt.executeUpdate();
            System.out.println("Inserted Successfully!");
            pstmt.close();
            }catch(SQLException e){
                System.out.println("Connection Error: "+e);
            }
    }
}
