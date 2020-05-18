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
import domain.Seminar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
/**
 *
 * @author admin
 */
public class StaffDAOTest {
    private Staff member1;
    private Staff member2;
    private Staff member3;  
    private Staff test;
    

    private JDBCManageStaff staffMembers = new JDBCManageStaff();

    public StaffDAOTest() {
    }
    
    @Before
    public void setUp() {
        this.member1 = new Staff("FreeFred", "password123", "Fred", "Flintstone","loves a cartoon", "fredflinstone@gmail.com");
        this.member2 = new Staff("CustomCosta", "unirocks101", "Daniel", "DaCosta","info310 boss", "dancosta123@gmail.com");
        this.member3 = new Staff("ECorp", "Donthackme7878", "George", "McLuvin","a multi billion dollar industry", "georgemc@ecorp.co.nz");
        
        staffMembers.saveStaff(member1);
        staffMembers.saveStaff(member2);
        //staffMembers.saveStaff(member3);
    }
    
    @After
    public void tearDown() {
        staffMembers.deleteStaff(member1);
        staffMembers.deleteStaff(member2);
        staffMembers.deleteStaff(member3);
    }
    @Test
    public void testSaveStaff(){
        staffMembers.saveStaff(member1);
        
        test = staffMembers.getStaffThroughUsername("FreeFred");
        
        assertEquals("Retrieved staff member should be the same", member1.getUsername().equals(test.getUsername()));
    }
    @Test
    public void testDeleteStaff(){
        // delete the staff via the DAO
        staffMembers.deleteStaff(member1);
        // try to retrieve the deleted staff member
        Staff retrieved = staffMembers.getStaffThroughUsername("FreeFred");
        // ensure that the staff member was not retrieved (should be null)
        assertNull("Staff should no longer exist", retrieved);
    }

    

}
