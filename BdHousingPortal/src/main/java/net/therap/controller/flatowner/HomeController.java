package net.therap.controller.flatowner;


import net.therap.domain.Customer;
import net.therap.domain.FlatOwner;
import net.therap.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 5/29/12
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping({"/home.htm"})
public class HomeController {

    @Autowired
    CustomerService customerService;

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String welcomeAction(Map<String, Object> model, HttpServletRequest request) {
        List<Customer> customerList = customerService.getCustomerListByFlatOwner((FlatOwner) request.getSession().getAttribute("flatowner"));
        model.put("title", "Expected customer");
        model.put("customerlist", customerList);
        return "flatowner/home";
    }


}
