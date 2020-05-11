/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import dao.JDBCManageStaff;
import dao.JDBCManageSeminar;
import java.util.concurrent.CompletableFuture;
import org.jooby.Jooby;
import org.jooby.Status;

import org.jooby.json.Gzon;



public class Server extends Jooby {
    
    private JDBCManageStaff manageStaff = new JDBCManageStaff();
    private JDBCManageSeminar manageSeminar = new JDBCManageSeminar();
    
    public Server(){
        port(8083);
       
        
        use(new Gzon());
        use(new StaffModule(manageStaff));
        use(new SeminarModule(manageSeminar));
        use(new AssetModule());
    }
    
   
    public static void main(String[] args) throws Exception {
        System.out.println("\nStarting Server.");
        Server server = new Server();        
        CompletableFuture.runAsync(() -> {
          server.start();
        });
        
        server.onStarted(() -> {
          System.out.println("\nPress Enter to stop the server.");
        });
        // wait for user to hit the Enter key
        System.in.read();
        System.exit(0);
     }
    
}
