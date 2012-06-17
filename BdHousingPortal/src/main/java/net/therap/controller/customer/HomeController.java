package net.therap.controller.customer;


import net.therap.domain.Customer;
import net.therap.domain.Flat;
import net.therap.service.CriteriaService;
import net.therap.service.CustomerService;
import net.therap.service.FlatOwnerService;
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
    CriteriaService criteriaService;

    public CriteriaService getService() {
        return criteriaService;
    }

    public void setService(CriteriaService service) {
        this.criteriaService = service;
    }

    public FlatOwnerService getFlatOwnerService() {
        return flatOwnerService;
    }

    public void setFlatOwnerService(FlatOwnerService flatOwnerService) {
        this.flatOwnerService = flatOwnerService;
    }

    @Autowired
    private FlatOwnerService flatOwnerService;

    @RequestMapping(method = RequestMethod.GET)
    public String welcomeAction(Map<String,Object> model, HttpServletRequest request){

        List<Flat> flatList = criteriaService.getFlatListByCustomer(((Customer)request.getSession().getAttribute("customer")));
        model.put("flatlist",flatList);
        model.put("title","Your expected flats");
        return "customer/home";
    }


}
