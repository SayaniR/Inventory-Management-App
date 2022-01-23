/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2.test.dao;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import struts2.test.beans.User;

/**
 *
 * @author Sayani
 */
public class AdminTest {
    public static User testUser=new User();
    public AdminTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Running before all tests");
        testUser.setUserName("sayanir");
        testUser.setPassword("1234");
        testUser.setFirstName("Sayani");
        testUser.setLastName("Roy");
        testUser.setEmail("s@b.com");
        testUser.setPhoneNumber("1234567890");
        testUser.setStatus(true);
        testUser.setValidUser(true);
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Running after all tests");
    }

    /**
     * Test of registerUser method, of class Admin.
     */
//    @Test
//    public void testRegisterUser() throws Exception {
//        System.out.println("registerUserTest running ...");
//        
//        //actual result
//        Admin instance = new Admin();
//        int actResult=instance.registerUser("spaul", "5432", "Susmita", "Paul", "s@p.com", "9876543210");
//        
//        //expected result
//        int expResult = 1;
//        
//        assertEquals(expResult, actResult);
//        
//    }

    /**
     * Test of report method, of class Admin.
     */
//    @Test
//    public void testReport() throws Exception {
//        System.out.println("report");
//        Admin instance = new Admin();
//        List expResult = null;
//        List result = instance.report();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of fetchUserDetails method, of class Admin.
//     */
    @Test
    public void testFetchUserDetails() throws Exception {
        System.out.println("fetchUserDetailsTest running");
        
        //actual result
        Admin instance = new Admin();
        User actResult = instance.fetchUserDetails("sayanir");
        System.out.println(actResult);
        //expected result
        User expResult = testUser;
        System.out.println(expResult);
        boolean result=expResult.equals(actResult);
        
        assertTrue(result);
        
    }

//    /**
//     * Test of updateUserDetails method, of class Admin.
//     */
//    @Test
//    public void testUpdateUserDetails() throws Exception {
//        System.out.println("updateUserDetails");
//        String userName = "";
//        String password = "";
//        String firstName = "";
//        String lastName = "";
//        String email = "";
//        String phoneNumber = "";
//        Admin instance = new Admin();
//        int expResult = 0;
//        int result = instance.updateUserDetails(userName, password, firstName, lastName, email, phoneNumber);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteUserDetails method, of class Admin.
//     */
//    @Test
//    public void testDeleteUserDetails() throws Exception {
//        System.out.println("deleteUserDetails");
//        String userName = "";
//        Admin instance = new Admin();
//        int expResult = 0;
//        int result = instance.deleteUserDetails(userName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
