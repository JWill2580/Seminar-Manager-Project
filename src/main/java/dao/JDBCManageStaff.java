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
        String statement = "insert into STAFF(USERNAME, PASSWORD, FIRSTNAME, SURNAME, BIO, EMAIL) values(?,?,?,?,?,?)";

        try (
            // get connection to database
            Connection dbCon = DbConnection.getConnection(DbConnection.getDefaultConnectionUri());
            
            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);) {
                  

            stmt.setString(1, aStaff.getUsername());
            stmt.setString(2, aStaff.getPassword());
            stmt.setString(3, aStaff.getFirstName());
            stmt.setString(4, aStaff.getSurname());
            stmt.setString(5, aStaff.getBio());
            stmt.setString(6, aStaff.getEmail());

            stmt.executeUpdate(); 

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
     
        } catch (SQLException ex) { 
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    public void deleteStaff(Staff staff) {
        String sql = "delete from STAFF";
                    try (
        // get a connection to the database
        Connection dbCon = DbConnection.getConnection(DbConnection.getDefaultConnectionUri());

        // create the statement
        PreparedStatement stmt = dbCon.prepareStatement(sql);
    ) {
        
        //stmt.setInt(1, staff.getStaffID());
        stmt.executeUpdate();
        
        } catch (SQLException ex) {
        throw new DAOException(ex.getMessage(), ex);
    }
        
    }

    public Staff getStaff(String usename) {
        String statement = "select * from STAFF where USERNAME = ?";
        
        try (
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(DbConnection.getDefaultConnectionUri());
            
            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(statement);) {
            stmt.setString(1, usename);

            // execute the query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Integer staffID = rs.getInt("STAFFID");
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
    
    public Staff getStaffThroughID(int id) {
        String statement = "select * from STAFF where STAFFID = ?";
        
        try (
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(DbConnection.getDefaultConnectionUri());
            
            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(statement);) {
            stmt.setInt(1, id);

            // execute the query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Integer staffID = rs.getInt("STAFFID");
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
        public Staff getStaffThroughUsername(String usernames) {
        String statement = "select * from STAFF where USERNAME = ?";
        
        try (
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(DbConnection.getDefaultConnectionUri());
            
            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(statement);) {
            stmt.setString(1, usernames);

            // execute the query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String firstName = rs.getString("FIRSTNAME");
                String surname = rs.getString("SURNAME");
                String bio = rs.getString("BIO");
                String email = rs.getString("EMAIL");
                
                return new Staff(username, password, firstName, surname, bio, email);
                
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
}
