package net.therap.controller.common;

import net.therap.domain.Customer;
import net.therap.domain.FlatOwner;
import net.therap.exception.ApplicationException;
import net.therap.service.CustomerService;
import net.therap.service.FlatOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/11/12
 * Time: 9:51 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ProfileViewController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FlatOwnerService flatOwnerService;

    public FlatOwnerService getFlatOwnerService() {
        return flatOwnerService;
    }

    public void setFlatOwnerService(FlatOwnerService flatOwnerService) {
        this.flatOwnerService = flatOwnerService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/viewcusprofile.htm", method = RequestMethod.GET)
    public String viewCustomerProfile(Map<String, Object> model, HttpServletRequest request) {

        if (request.getParameter("customerid") == null || !request.getParameter("customerid").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        Customer customer = customerService.getCustomerById(Long.valueOf(request.getParameter("customerid")));
        if (customer == null) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        model.put("customer", customer);
        model.put("title", "Customer Profile :");
        return "common/viewcustomer";
    }

    @RequestMapping(value = "/viewownerprofile.htm", method = RequestMethod.GET)
    public String viewFlatOwnerProfile(Map<String, Object> model, HttpServletRequest request) {

        if (request.getParameter("flatownerid") == null || !request.getParameter("flatownerid").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        FlatOwner flatOwner = flatOwnerService.getFlatOwnerById(Long.valueOf(request.getParameter("flatownerid")));
        if (flatOwner == null) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        model.put("flatowner", flatOwner);
        model.put("title", "Flat Owner Profile :");
        return "common/viewflatowner";

    }

}
