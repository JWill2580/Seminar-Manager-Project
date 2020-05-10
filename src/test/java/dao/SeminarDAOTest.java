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
    
    private JDBCManageSeminar seminarDAO = new JDBCManageSeminar();
    
    public SeminarDAOTest() {
    }
    
    @Before
    public void setUp() {
        this.sem1 = new Seminar("123","Computer Science","The Beggining",
                "Back in 1978","St Davids 1","Humble","18th June 2020","John");
        this.sem2 = new Seminar("456","Astro Physics","What's really out there?",
                "We begin with the big bang","The Link","True vs False","23rd May 2020","Jeff");
        this.sem3 = new Seminar("789","Teaching","The Proper Way",
                "Classical conditioning","Teaching College","Strict!","1st December 2020","Katey");
        seminarDAO.saveSeminar(sem1);
        seminarDAO.saveSeminar(sem2);
        seminarDAO.saveSeminar(sem3);
    }
    
    @After
    public void tearDown() {
        seminarDAO.delete(sem1);
        seminarDAO.delete(sem2);
        seminarDAO.delete(sem3);
        
        
    }
    
    @Test
    public void saveSeminar(){
        seminarDAO.saveSeminar(sem3);
        
        Seminar retrieved = seminarDAO.getSeminarById("24683");
        
        assertEquals("Retrieved seminar should be the same",
        sem3, retrieved);
    }
    @Test
    public void getSeminars(){
        Collection<Seminar> seminars = seminarDAO.getSeminars();
        
        assertTrue("sem1 should exist", seminars.contains(sem1));
        assertTrue("sem2 should exist", seminars.contains(sem2));
        
        assertEquals("Only 2 staff in result", 2, seminars.size());
        
        for (Seminar s : seminars) {
            if (s.equals(sem1)) {
                // ensure that all of the details were correctly retrieved
                assertEquals(sem1.getSeminarID(), s.getSeminarID());
                assertEquals(sem1.getTopic(), s.getTopic());
                assertEquals(sem1.getTitle(), s.getTitle());
                assertEquals(sem1.getAbstracts(), s.getAbstracts());
                assertEquals(sem1.getLocation(), s.getLocation());
                assertEquals(sem1.getModality(), s.getModality());
                assertEquals(sem1.getDate(), s.getDate());
                assertEquals(sem1.getDisplayName(), s.getDisplayName());
            }
        }
    }
    @Test
    public void getSeminarById(){
        Seminar retrieved = seminarDAO.getSeminarById(sem1.getSeminarID());
        assertEquals("retrieved seminar should be the same", sem1, retrieved);
        
        if(retrieved.equals(sem1)){
            // ensure that all of the details were correctly retrieved
                assertEquals(sem1.getSeminarID(), retrieved.getSeminarID());
                assertEquals(sem1.getTopic(), retrieved.getTopic());
                assertEquals(sem1.getTitle(), retrieved.getTitle());
                assertEquals(sem1.getAbstracts(), retrieved.getAbstracts());
                assertEquals(sem1.getLocation(), retrieved.getLocation());
                assertEquals(sem1.getModality(), retrieved.getModality());
                assertEquals(sem1.getDate(), retrieved.getDate());
                assertEquals(sem1.getDisplayName(), retrieved.getDisplayName());
            
        }
        Seminar result = seminarDAO.getSeminarById("123");
        
        assertNull("Seminar member should no longer exist", result);
        
    }
    
}
