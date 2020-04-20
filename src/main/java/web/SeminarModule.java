/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import dao.JDBCManageSeminar;
import org.jooby.Jooby;

public class SeminarModule extends Jooby {
    
    private JDBCManageSeminar manageSeminar = new JDBCManageSeminar();

    public SeminarModule(JDBCManageSeminar manageSeminar) {
        
        get("/api/seminars/:id", (req) -> {
         String id = req.param("id").value();
         return manageSeminar.getSeminarById(id);
});
    }

    
    
    
    
    
}
