/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import dao.JDBCManageSeminar;
import domain.Seminar;
import org.jooby.Jooby;
import org.jooby.Status;

public class SeminarModule extends Jooby {
    
    public SeminarModule(JDBCManageSeminar manageSeminar) {
        get("/api/seminars", () -> manageSeminar.getSeminars());
        get("/api/seminars/:id", (req) -> {
            String id = req.param("id").value();
            return manageSeminar.getSeminarById(id);
        });
        
        
        post("/api/seminars/register", (req, rsp) -> {
            Seminar seminar = req.body().to(Seminar.class);
            manageSeminar.saveSeminar(seminar);
            rsp.status(Status.CREATED);
        });
    }

    
    
    
    
    
}
