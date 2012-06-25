package net.therap.controller.customer;


import net.therap.domain.Customer;
import net.therap.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/5/12
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@SessionAttributes("customer")
@RequestMapping(value = "/customerprofile")
public class CustomerProfileController{

    private static final Logger log = LoggerFactory.getLogger(CustomerProfileController.class);

    @Autowired
    private CustomerService customerService;

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/view.htm", method = RequestMethod.GET)
    public String profileViewAction(Map<String, Object> model, HttpServletRequest request) {
        model.put("customer", request.getSession().getAttribute("customer"));
        return "customer/customerdetailsview";
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
    }

    @RequestMapping(value = "/edit.htm", method = RequestMethod.GET)
    public String profileEditGetAction(Map<String, Object> model, HttpServletRequest request) {

        Customer customer =  customerService.getCustomerById(((Customer)request.getSession().getAttribute("customer")).getCustomerId());
        model.put("customer",customer);
        model.put("title", "Customer Profile edit Form");
        //log.debug("####" + "InMethodGet" + ((Customer) request.getSession().getAttribute("customer")).getCustomerId());
        return "customer/customeredit";

    }

    @RequestMapping(value = "/edit.htm", method = RequestMethod.POST)
    public String profileEditPostAction(@Valid Customer customer, BindingResult bindingResult, HttpServletRequest request, Map<String, Object> model) {

        log.debug(customer.getCustomerName()+"@@@@@"+customer.getVersion());

        if (bindingResult.hasErrors()) {
            model.put("customer", customer);
            model.put("title", "Customer Profile edit Form");
            return "customer/customeredit";
        } else {
            customerService.updateCustomer(customer);
            request.getSession().setAttribute("customer", customer);
            return "redirect:/cus/customerprofile/view.htm";
        }

    }

}
