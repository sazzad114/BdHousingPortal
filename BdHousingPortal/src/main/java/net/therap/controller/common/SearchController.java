package net.therap.controller.common;

import net.therap.controller.anonymous.FlatOwnerRegController;
import net.therap.dao.AreaDao;
import net.therap.domain.Area;
import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import net.therap.domain.Flat;
import net.therap.service.CriteriaService;
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
    AreaDao areaDao;
    public AreaDao getAreaDao() {
        return areaDao;
    }

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }
    @Autowired
    CriteriaService criteriaService;

    public CriteriaService getCriteriaService() {
        return criteriaService;
    }

    public void setCriteriaService(CriteriaService criteriaService) {
        this.criteriaService = criteriaService;
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
        return "common/flatsearch";
    }
    @RequestMapping(value = "/flatsearch.htm",method = RequestMethod.POST)
    String searchFlatPostAction(@Valid Criteria criteria,BindingResult bindingResult, Map<String,Object> model){

        if(bindingResult.hasErrors()){
            return "common/flatsearch";
        }
        else {
            List<Flat> flatList = criteriaService.getFlatListByCriteria(criteria);
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
        return "common/customersearch";
    }
    @RequestMapping(value = "/customersearch.htm",method = RequestMethod.POST)
    String searchCustomerPostAction(@Valid Criteria criteria,BindingResult bindingResult, Map<String,Object> model){

        if(bindingResult.hasErrors()){
            return "common/cusomersearch";
        }
        else {
            List<Customer> customerList = criteriaService.getCustomerListByCriteria(criteria);
            model.put("customerlist",customerList);
            return "common/customersearch";
        }
    }

}
