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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
 * Date: 6/5/12
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/customerprofile")
public class CustomerProfileController {

    private static final Logger log = LoggerFactory.getLogger(CustomerProfileController.class);

    @Autowired
    CustomerService customerService;

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/view.htm", method = RequestMethod.GET)
    String profileViewAction(Map<String, Object> model, HttpServletRequest request) {
        model.put("customer", request.getSession().getAttribute("customer"));
        return "customer/customerdetailsview";
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));


    }

    @ModelAttribute("customer")
    Customer getCustomer(HttpServletRequest request){

        return (Customer)request.getSession().getAttribute("customer");
    }

    @RequestMapping(value = "/edit.htm", method = RequestMethod.GET)
    String profileEditGetAction(Map<String, Object> model, HttpServletRequest request) {
        //model.put("customer",(Customer)request.getSession().getAttribute("customer"));
        model.put("title", "Customer Profile edit Form");
        log.debug("####" + "InMethodGet" + ((Customer) request.getSession().getAttribute("customer")).getCustomerId());
        return "customer/customeredit";
    }

    @RequestMapping(value = "/edit.htm", method = RequestMethod.POST)
    String profileEditPostAction(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, HttpServletRequest request, Map<String, Object> model) {

        if (bindingResult.hasErrors()) {


            model.put("customer", customer);
            model.put("title", "Customer Profile edit Form");
            return "customer/customeredit";

        } else {
             log.debug("####" + "InMethodPost"+customer.getCustomerId());
            //customer.setUser(((Customer) request.getSession().getAttribute("customer")).getUser());
            customerService.saveCustomer(customer);
            request.getSession().setAttribute("customer", customer);
            return "customer/customerdetailsview";

        }

    }

}
