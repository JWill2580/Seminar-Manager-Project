/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Seminar;
import domain.Staff;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class SeminarDAOTest {
    private Seminar sem1;
    private Seminar sem2;
    private Seminar sem3;
    private Seminar test;
    
    private JDBCManageSeminar seminarDAO = new JDBCManageSeminar();
    
    public SeminarDAOTest() {
    }
    
    @Before
    public void setUp() {
        sem1 = new Seminar("Computer Science","The Beggining","Back in 1978","St Davids 1","Zoom","18th June 2020","John");
        sem2 = new Seminar("Astro Physics","What's really out there?","We begin with the big bang","The Link","Zoom","23rd May 2020","Jeff");
        sem3 = new Seminar("Teaching","The Proper Way","Classical conditioning","Teaching College","Zoom","1st December 2020","Katey");
        seminarDAO.saveSeminar(sem1);
        seminarDAO.saveSeminar(sem2);
        //seminarDAO.saveSeminar(sem3);
    }
    
    @After
    public void tearDown() {
        seminarDAO.deleteSeminar(sem1);
        seminarDAO.deleteSeminar(sem2);
        seminarDAO.deleteSeminar(sem3);
    
    }
    
    @Test
    public void testSaveSeminar(){
        seminarDAO.saveSeminar(sem1);
        test = seminarDAO.getSeminarThroughTitle("The Beggining"); 
        assertTrue("Retrieved seminar should be the same", sem1.getTitle().equals(test.getTitle()));
    }
    @Test
    public void testDeleteSeminar(){
        // delete the seminar via the DAO
        seminarDAO.deleteSeminar(sem1);
        // try to retrieve the deleted seminar
        Seminar retrieved = seminarDAO.getSeminarById(1);
        // ensure that the seminar was not retrieved (should be null)
        assertNull("Seminar should no longer exist", retrieved);
    }
    

    
}
