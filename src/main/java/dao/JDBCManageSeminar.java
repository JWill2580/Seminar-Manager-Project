/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Seminar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCManageSeminar {
    
    public JDBCManageSeminar(){}
    
    public Seminar getSeminar(String idDefined){
        String statement = "select * from SEMINAR where SEMINARID = ?";
        
        try (
            // get a connection to the database
            Connection dbCon = DbConnection.getConnection(DbConnection.getDefaultConnectionUri());
            
            // create the statement
            PreparedStatement stmt = dbCon.prepareStatement(statement);) {
            stmt.setString(1, idDefined);

            // execute the query
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String seminarID = rs.getString("SEMINARID");
                String topic = rs.getString("TOPIC");
                String title = rs.getString("TITLE");
                String abstracts = rs.getString("ABSTRACT");
                String location = rs.getString("LOCATION");
                String modality = rs.getString("MODALITY");
                String date = rs.getString("DATE");
                
                return new Seminar(seminarID,topic,title,abstracts,location,modality,date);
                
            }else{
                return null;
            }
            
            } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
                   
    }
    
    
    
    
    
    
    
}
