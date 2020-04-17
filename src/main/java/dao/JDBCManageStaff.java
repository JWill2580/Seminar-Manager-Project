/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Staff;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.h2.jdbc.JdbcConnection;

/**
 *
 * @author wiljo912
 */
public class JDBCManageStaff  {

    String dbURI = DbConnection.getDefaultConnectionUri();

    public JDBCManageStaff() {

    }

    public JDBCManageStaff(String URI) {
        this.dbURI = URI;
    }

    public void saveCustomer(Staff aStaff) {
        String statement = "insert into STAFF(ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, BIO, EMAIL) values(?,?,?,?,?,?,?)";

        try (
                // get connection to database
                Connection dbCon = DbConnection.getConnection(
                        DbConnection.getDefaultConnectionUri());
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);) {
            // copy the data from the student domain object into the SQL parameters
                  
            stmt.setString(1, aStaff.getStaffID());
            stmt.setString(2, aStaff.getUsername());
            stmt.setString(3, aStaff.getPassword());
            stmt.setString(4, aStaff.getFirstName());
            stmt.setString(5, aStaff.getSurname());
            stmt.setString(6, aStaff.getBio());
            stmt.setString(7, aStaff.getEmail());

            stmt.executeUpdate();  // execute the statement

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            System.out.println(rs.getString(1));

            
            
        } catch (SQLException ex) {  // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public Staff getStaff(String usernameDefined) {

        String statement = "select * from STAFF where USERNAME = ?";
        try (
                // get a connection to the database
                Connection dbCon = DbConnection.getConnection(
                        DbConnection.getDefaultConnectionUri());
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(statement);) {

            stmt.setString(1, usernameDefined);

            // execute the query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String staffID = rs.getString("STAFF_ID");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String firstName = rs.getString("FIRSTNAME");
                String surname = rs.getString("SURNAME");
                String bio = rs.getString("BIO");
                String email = rs.getString("EMAIL");

                return new Staff(staffID, username, password,
                        firstName, surname, bio, email);
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
                Connection dbCon = DbConnection.getConnection(
                        DbConnection.getDefaultConnectionUri());
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
