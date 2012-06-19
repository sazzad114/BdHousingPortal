package net.therap.controller.anonymous;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/11/12
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */

public class WelcomeControllerTest extends TestCase {

    private WelcomeController welcomeController;

    @Before
    public void setUp() {
       welcomeController = new WelcomeController();
    }

    @Test
    public void testWelcomeAction(){
         assertEquals("anonymous/welcome", welcomeController.welcomeAction());
     }

}