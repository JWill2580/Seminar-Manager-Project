/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCManageStaff  {


    public JDBCManageStaff() {}

    public void saveStaff(Staff aStaff) {
        String statement = "insert into STAFF(STAFFID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, BIO, EMAIL) values(?,?,?,?,?,?,?)";

        try (
            // get connection to database
            Connection dbCon = DbConnection.getConnection(DbConnection.getDefaultConnectionUri());
            
            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);) {
                  
            stmt.setString(1, aStaff.getStaffID());
            stmt.setString(2, aStaff.getUsername());
            stmt.setString(3, aStaff.getPassword());
            stmt.setString(4, aStaff.getFirstName());
            stmt.setString(5, aStaff.getSurname());
            stmt.setString(6, aStaff.getBio());
            stmt.setString(7, aStaff.getEmail());

            stmt.executeUpdate(); 

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            System.out.println(rs.getString(1));
     
        } catch (SQLException ex) { 
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public Staff getStaff(String idDefined) {
        String statement = "select * from STAFF where STAFFID = ?";
        
        try (
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(DbConnection.getDefaultConnectionUri());
            
            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(statement);) {
            stmt.setString(1, idDefined);

            // execute the query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String staffID = rs.getString("STAFFID");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String firstName = rs.getString("FIRSTNAME");
                String surname = rs.getString("SURNAME");
                String bio = rs.getString("BIO");
                String email = rs.getString("EMAIL");
                
                return new Staff(staffID, username, password, firstName, surname, bio, email);
                
            } else {
                return null;
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public Boolean validateCredentials(String usernameDefined, String passwordDefined) {
        String statement = "select from STAFF where USERNAME = ? and PASSWORD = ?";

        try (
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(DbConnection.getDefaultConnectionUri());
            
            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(statement);) { 
            stmt.setString(1, usernameDefined);
            stmt.setString(2, passwordDefined);
            
            // execute the query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");

                if (username == usernameDefined && password == passwordDefined) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
  /**
   * Creating a main method for testing purposes*/
    public static void main(String[] args) {
        JDBCManageStaff staff1 = new JDBCManageStaff();
        System.out.println(staff1.getStaff("1").toString());
    }
    

}
