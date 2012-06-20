package net.therap.controller.anonymous;

import junit.framework.TestCase;
import net.therap.domain.Customer;
import net.therap.service.CustomerService;
import net.therap.service.UserService;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/11/12
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerRegControllerTest extends TestCase {

    CustomerRegController customerRegController;
    Customer customer;
    CustomerService customerService;
    Errors bindingResult;
    UserService userService;

    @Before
    public void setUp() {
        customerRegController = new CustomerRegController();
        customerService = EasyMock.createMock(CustomerService.class);
        userService = EasyMock.createMock(UserService.class);
        customer = new Customer();
        bindingResult = EasyMock.createMock(BindingResult.class);
        customerRegController.setCustomerService(customerService);
        customerRegController.setUserService(userService);
    }

    @Test
    public void testFlatOwnerRegAction() {
        Map<String, Object> model = new HashMap<String, Object>();
        assertEquals("anonymous/customerreg", customerRegController.customerRegAction(model));
        assertNotNull(model.get("customer"));
        assertNotNull(model.get("title"));
    }

    @Test
    public void testSaveFlatOwnerAction_NoBindingError() {

        EasyMock.expect(userService.isEmailExists("sazzad14@yahoo.com")).andReturn(false);
        EasyMock.expect(bindingResult.hasErrors()).andReturn(false);
        EasyMock.replay(userService);
        EasyMock.replay(bindingResult);
        customer.getUser().setEmail("sazzad14@yahoo.com");
        customer.getUser().setPassword("1234");
        customer.getUser().setConfirmPassword("1234");
        String actualView = customerRegController.saveFlatOwnerAction(customer, (BindingResult)bindingResult);
        assertEquals("redirect:/app/login.htm", actualView);
    }

    @Test
    public void testSaveFlatOwnerAction_WithBindingError() {
        EasyMock.expect(userService.isEmailExists("sazzad14@yahoo.com")).andReturn(false);
        EasyMock.expect(bindingResult.hasErrors()).andReturn(true);
        EasyMock.replay(userService);
        EasyMock.replay(bindingResult);
        customer.getUser().setEmail("sazzad14@yahoo.com");
        customer.getUser().setPassword("1234");
        customer.getUser().setConfirmPassword("1234");
        String actualView = customerRegController.saveFlatOwnerAction(customer,(BindingResult)bindingResult);
        assertEquals("anonymous/customerreg", actualView);
    }

    @Test
    public void testSaveFlatOwnerAction_emailExists(){
        EasyMock.expect(userService.isEmailExists("sazzad14@yahoo.com")).andReturn(true);
        EasyMock.expect(bindingResult.hasErrors()).andReturn(true).times(2);
        bindingResult.rejectValue("user.email","email.exists");
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(userService);
        EasyMock.replay(bindingResult);
        customer.getUser().setEmail("sazzad14@yahoo.com");
        customer.getUser().setPassword("1234");
        customer.getUser().setConfirmPassword("1234");
        String actualView = customerRegController.saveFlatOwnerAction(customer,(BindingResult)bindingResult);
        assertEquals("anonymous/customerreg", actualView);
    }

    @Test
    public void testSaveFlatOwnerAction_mismatchPassword(){
        EasyMock.expect(userService.isEmailExists("sazzad14@yahoo.com")).andReturn(false);
        EasyMock.expect(bindingResult.hasErrors()).andReturn(true).times(1);
        bindingResult.rejectValue("user.confirmPassword", "password.mismatch");
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(userService);
        EasyMock.replay(bindingResult);
        customer.getUser().setEmail("sazzad14@yahoo.com");
        customer.getUser().setPassword("123");
        customer.getUser().setConfirmPassword("1234");
        String actualView = customerRegController.saveFlatOwnerAction(customer,(BindingResult)bindingResult);
        assertEquals("anonymous/customerreg", actualView);
    }

     @Test
    public void testSaveFlatOwnerAction_emailExistsAndMismatchPassword(){
        EasyMock.expect(userService.isEmailExists("sazzad14@yahoo.com")).andReturn(false);
        EasyMock.expect(bindingResult.hasErrors()).andReturn(true).times(2);
        bindingResult.rejectValue("user.email","email.exists");
        EasyMock.expectLastCall().times(1);
        bindingResult.rejectValue("user.confirmPassword", "password.mismatch");
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(userService);
        EasyMock.replay(bindingResult);
        customer.getUser().setEmail("sazzad14@yahoo.com");
        customer.getUser().setPassword("123");
        customer.getUser().setConfirmPassword("1234");
        String actualView = customerRegController.saveFlatOwnerAction(customer,(BindingResult)bindingResult);
        assertEquals("anonymous/customerreg", actualView);
    }
}
