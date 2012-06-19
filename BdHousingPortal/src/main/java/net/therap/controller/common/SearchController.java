package net.therap.controller.common;

import net.therap.controller.anonymous.FlatOwnerRegController;
import net.therap.dao.AreaDao;
import net.therap.domain.Area;
import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import net.therap.domain.Flat;
import net.therap.service.CriteriaService;
import net.therap.service.CustomerService;
import net.therap.service.FlatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/11/12
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.*/


@Controller
@SessionAttributes({"criteria","arealist","numberofbeds"})
public class SearchController {

    private static final Logger log = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FlatService flatService;

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public FlatService getFlatService() {
        return flatService;
    }

    public void setFlatService(FlatService flatService) {
        this.flatService = flatService;
    }

    @Autowired
    AreaDao areaDao;
    public AreaDao getAreaDao() {
        return areaDao;
    }

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    @RequestMapping(value = "/flatsearch.htm",method = RequestMethod.GET)
    String searchFlatGetAction(Map<String,Object> model){
        Criteria criteria = new Criteria();
        List<Area> areaList = areaDao.getAreaList();
        List<Integer> numberOfBeds = new ArrayList<Integer>();
        for(int i=1;i<=10;i++)
        {
            numberOfBeds.add(i);
        }
        model.put("criteria",criteria);
        model.put("arealist",areaList);
        model.put("numberofbeds",numberOfBeds);
        model.put("title","Search Flat");
        return "common/flatsearch";
    }

    @RequestMapping(value = "/flatsearch.htm",method = RequestMethod.POST)
    String searchFlatPostAction(@Valid Criteria criteria,BindingResult bindingResult, Map<String,Object> model){

        model.put("title","Search Flat");
        if(bindingResult.hasErrors()){
            return "common/flatsearch";
        }
        else {
            List<Flat> flatList = flatService.getFlatListByCriteria(criteria);
            model.put("flatlist",flatList);
            return "common/flatsearch";
        }
    }


    @RequestMapping(value = "/customersearch.htm",method = RequestMethod.GET)
    String searchCustomerGetAction(Map<String,Object> model){
        Criteria criteria = new Criteria();
        List<Area> areaList = areaDao.getAreaList();
        List<Integer> numberOfBeds = new ArrayList<Integer>();
        for(int i=1;i<=10;i++)
        {
            numberOfBeds.add(i);
        }
        model.put("criteria",criteria);
        model.put("arealist",areaList);
        model.put("numberofbeds",numberOfBeds);
        model.put("title","Search Customer");
        return "common/customersearch";
    }

    @RequestMapping(value = "/customersearch.htm",method = RequestMethod.POST)
    String searchCustomerPostAction(@Valid Criteria criteria,BindingResult bindingResult, Map<String,Object> model){

        model.put("title","Search Customer");
        if(bindingResult.hasErrors()){
            return "common/customersearch";
        }
        else {
            List<Customer> customerList = customerService.getCustomerListByCriteria(criteria);
            model.put("customerlist",customerList);
            return "common/customersearch";
        }
    }
}
