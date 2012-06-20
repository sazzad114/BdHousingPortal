package net.therap.service;

import junit.framework.TestCase;
import net.therap.dao.CustomerDao;
import net.therap.dao.FlatOwnerDao;
import net.therap.dao.UserDao;
import net.therap.domain.Customer;
import net.therap.domain.FlatOwner;
import net.therap.domain.User;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/19/12
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceTest extends TestCase{
    private UserServiceImpl userService;
    private UserDao userDao;
    private FlatOwnerDao flatOwnerDao;
    private CustomerDao customerDao;

    @Before
    public void setUp(){
        userService = new UserServiceImpl();
        userDao = EasyMock.createMock(UserDao.class);
        flatOwnerDao = EasyMock.createMock(FlatOwnerDao.class);
        customerDao = EasyMock.createMock(CustomerDao.class);
        userService.setUserDao(userDao);
        userService.setFlatOwnerDao(flatOwnerDao);
        userService.setCustomerDao(customerDao);
    }

    @Test
    public void testGetUserByEmailAndPass_returnsFlatOwner(){
            User user = new User();
            user.setEmail("ashraf@yahoo.com");
            user.setUserType(User.FLATOWNERTYPE);
            user.setPassword("12345");
            EasyMock.expect(userDao.getUserByEmail("ashraf@yahoo.com")).andReturn(user);
            EasyMock.replay(userDao);
            FlatOwner flatOwner = new FlatOwner();
            EasyMock.expect(flatOwnerDao.getFlatOwnerByUser(user)).andReturn(flatOwner);
            EasyMock.replay(flatOwnerDao);
            Object typedUser = userService.getUserByEmailAndPass("ashraf@yahoo.com","12345");
            TestCase.assertEquals(typedUser instanceof FlatOwner, true);
    }

    @Test
    public void testGetUserByEmailAndPass_returnsCustomer(){
            User user = new User();
            user.setEmail("ashraf@yahoo.com");
            user.setUserType(User.CUSTOMERTYPE);
            user.setPassword("12345");
            EasyMock.expect(userDao.getUserByEmail("ashraf@yahoo.com")).andReturn(user);
            EasyMock.replay(userDao);
            Customer customer = new Customer();
            EasyMock.expect(customerDao.getCustomerByUser(user)).andReturn(customer);
            EasyMock.replay(customerDao);
            Object typedUser = userService.getUserByEmailAndPass("ashraf@yahoo.com","12345");
            TestCase.assertEquals(typedUser instanceof Customer, true);
    }

      @Test
    public void testGetUserByEmailAndPass_returnsNull(){

            EasyMock.expect(userDao.getUserByEmail("ashraf@yahoo.com")).andReturn(null);
            EasyMock.replay(userDao);
            Object typedUser = userService.getUserByEmailAndPass("ashraf@yahoo.com","12345");
            TestCase.assertNull(typedUser);
    }

    @Test
    public void testGetUserByEmailAndPass_passwordMismatch(){
            User user = new User();
            user.setEmail("ashraf@yahoo.com");
            user.setUserType(User.CUSTOMERTYPE);
            user.setPassword("12345");
            EasyMock.expect(userDao.getUserByEmail("ashraf@yahoo.com")).andReturn(user);
            EasyMock.replay(userDao);
            Customer customer = new Customer();
            EasyMock.expect(customerDao.getCustomerByUser(user)).andReturn(customer);
            EasyMock.replay(customerDao);
            Object typedUser = userService.getUserByEmailAndPass("ashraf@yahoo.com","2345");
            TestCase.assertNull(typedUser);
    }

}
