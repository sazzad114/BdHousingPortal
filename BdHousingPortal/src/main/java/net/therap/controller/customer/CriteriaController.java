package net.therap.controller.customer;

import net.therap.dao.AreaDao;
import net.therap.domain.Area;
import net.therap.domain.Criteria;
import net.therap.domain.Customer;
import net.therap.exception.ApplicationException;
import net.therap.service.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/11/12
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/criteria")
@SessionAttributes({"criteria", "arealist"})
public class CriteriaController {

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

    @RequestMapping(value = "/create.htm", method = RequestMethod.GET)
    String createCriteriaGetAction(Map<String, Object> model) {
        Criteria criteria = new Criteria();
        List<Area> areaList = areaDao.getAreaList();
        List<Integer> numberOfBeds = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            numberOfBeds.add(i);
        }
        model.put("criteria", criteria);
        model.put("arealist", areaList);
        model.put("numberofbeds", numberOfBeds);
        return "customer/createcriteria";
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
    String createCriteriaPostAction(@Valid Criteria criteria, BindingResult bindingResult, HttpServletRequest request, Map<String, Object> model) {
        if (bindingResult.hasErrors()) {
            List<Integer> numberOfBeds = new ArrayList<Integer>();
            for (int i = 1; i <= 10; i++) {
                numberOfBeds.add(i);
            }
            model.put("numberofbeds", numberOfBeds);
            return "customer/createcriteria";
        } else {
            criteriaService.saveCriteriaForCustomer(criteria, (Customer) request.getSession().getAttribute("customer"));
            return "redirect:/cus/criteria/view.htm";
        }
    }

    @RequestMapping(value = "/view.htm", method = RequestMethod.GET)
    String viewCriteriaAction(Map<String, Object> model, HttpServletRequest request) {


        model.put("criterialist", ((Customer) request.getSession().getAttribute("customer")).getCriteriaList());
        model.put("title", "Criteria list");
        return "customer/viewcriteria";
    }

    @RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
    String deleteCriteriaAction(HttpServletRequest request) {

        if (request.getParameter("criteriaid") == null) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        long criteriaId = Long.valueOf(request.getParameter("criteriaid"));
        boolean deleted = criteriaService.deleteCriteriaById((Customer) request.getSession().getAttribute("customer"), criteriaId);
        if (deleted == false) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }
        return "redirect:/cus/criteria/view.htm";
    }


}
