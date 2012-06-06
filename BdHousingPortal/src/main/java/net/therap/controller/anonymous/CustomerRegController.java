package net.therap.controller.anonymous;


import net.therap.domain.Customer;
import net.therap.domain.FlatOwner;
import net.therap.domain.User;
import net.therap.service.CustomerService;
import net.therap.service.FlatOwnerService;
import net.therap.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 5/31/12
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/customerreg.htm")
public class CustomerRegController {

    private static final Logger log = LoggerFactory.getLogger(FlatOwnerRegController.class);

    @Autowired
    CustomerService customerService;

    @Autowired
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    String flatOwnerRegAction(Map<String, Object> model) {

        model.put("customer", new Customer());
        model.put("title","Customer Registration Form");
        return "anonymous/customerreg";

    }

    @InitBinder
    protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));


    }


    @RequestMapping(method = RequestMethod.POST)
    public String saveFlatOwnerAction(@Valid Customer customer, BindingResult bindingResult) {

        if (userService.isEmailExists(customer.getUser().getEmail()) == true) {
            bindingResult.rejectValue("user.email", "email.exists");
        }

        if (!customer.getUser().getPassword().equals(customer.getUser().getConfirmPassword())) {
            bindingResult.rejectValue("user.confirmPassword", "password.mismatch");
        }


        if (bindingResult.hasErrors()) {

            return "anonymous/customerreg";
        } else {
            customer.getUser().setUserType(User.CUSTOMERTYPE);
            customerService.saveCustomer(customer);
            return "redirect:/app/login.htm";
        }
    }


}
