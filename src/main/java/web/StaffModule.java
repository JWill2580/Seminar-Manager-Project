/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.JDBCManageStaff;
import domain.Staff;
import org.jooby.Jooby;
import org.jooby.Status;

/**
 *
 * @author lucyberes
 */
public class StaffModule extends Jooby {
    
    public StaffModule(JDBCManageStaff manageStaff) {
        
        get("/api/staff/:username", (req) -> {
            String username = req.param("username").value();
            return manageStaff.getStaff(username);      
        });
        
        post("/api/register", (req, rsp) -> {
            Staff staff = req.body().to(Staff.class);
            manageStaff.saveStaff(staff);
            rsp.status(Status.CREATED);
        });
        
    } 
}
        
        
