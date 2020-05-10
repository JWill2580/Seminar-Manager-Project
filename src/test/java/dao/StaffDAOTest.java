/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.Staff;
import java.util.ArrayList;
import dao.JDBCManageStaff;
import java.util.Collection;
/**
 *
 * @author admin
 */
public class StaffDAOTest {
    private Staff member1;
    private Staff member2;
    private Staff member3;
    

    private JDBCManageStaff staffMembers = new JDBCManageStaff();

    public StaffDAOTest() {
    }
    
    @Before
    public void setUp() {
        this.member1 = new Staff("98765", "FreeFred", "password123", "Fred", "Flintstone",
        "loves a cartoon", "fredflinstone@gmail.com");
        this.member2 = new Staff("76579", "CustomCosta", "unirocks101", "Daniel", "DaCosta",
        "info310 boss", "dancosta123@gmail.com");
        this.member3 = new Staff("24683", "ECorp", "Donthackme7878", "George", "McLuvin",
        "a multi billion dollar industry", "georgemc@ecorp.co.nz");
        
        staffMembers.saveStaff(member1);
        staffMembers.saveStaff(member2);
        staffMembers.saveStaff(member3);
    }
    
    @After
    public void tearDown() {
        staffMembers.delete(member1);
        staffMembers.delete(member2);
        staffMembers.delete(member3);
    }
    
    @Test
    public void saveStaff(){
        staffMembers.saveStaff(member3);
        
        Staff retrieved = staffMembers.getStaffThroughID("24683");
        
        assertEquals("Retrieved staff member should be the same",
        member3, retrieved);
    }
    
    @Test
    public void getStaff(){
        staffMembers.saveStaff(member1);
        Staff p = staffMembers.getStaffThroughID("98765");
        

            if (p.equals(member1)) {
                // ensure that all of the details were correctly retrieved
                assertEquals(member1.getStaffID(), p.getStaffID());
                assertEquals(member1.getUsername(), p.getUsername());
                assertEquals(member1.getPassword(), p.getPassword());
                assertEquals(member1.getFirstName(), p.getFirstName());
                assertEquals(member1.getSurname(), p.getSurname());
                assertEquals(member1.getBio(), p.getBio());
                assertEquals(member1.getEmail(), p.getEmail());
            }
    }
    
    @Test
    public void getStaffThroughID(){
        Staff retrieved = staffMembers.getStaffThroughID(member1.getStaffID());
        assertEquals("retrieved staff should be the same", member1, retrieved);
        
        if(retrieved.equals(member1)){
            assertEquals(member1.getStaffID(), retrieved.getStaffID());
                assertEquals(member1.getUsername(), retrieved.getUsername());
                assertEquals(member1.getPassword(), retrieved.getPassword());
                assertEquals(member1.getFirstName(), retrieved.getFirstName());
                assertEquals(member1.getSurname(), retrieved.getSurname());
                assertEquals(member1.getBio(), retrieved.getBio());
                assertEquals(member1.getEmail(), retrieved.getEmail());
        }
        Staff result = staffMembers.getStaffThroughID("98765");
        // assert that the result is null
        assertNull("Staff member should no longer exist", result);
    }
    //@Test
    //public Boolean validateCredentials(String username, String password){
     //   return true;
    //}
}
