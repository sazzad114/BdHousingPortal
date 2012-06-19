package net.therap.controller.common;

import net.therap.domain.Building;
import net.therap.domain.Flat;
import net.therap.domain.FlatOwner;
import net.therap.exception.ApplicationException;
import net.therap.service.BuildingService;
import net.therap.service.FlatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/7/12
 * Time: 5:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@SessionAttributes({"flat", "floorlist"})
@RequestMapping(value = "/flat")
public class FlatController {

    private static final Logger log = LoggerFactory.getLogger(FlatController.class);
    @Autowired
    private BuildingService buildingService;

    @Autowired
    private FlatService flatService;

    public BuildingService getBuildingService() {
        return buildingService;
    }

    public void setBuildingService(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    public FlatService getFlatService() {
        return flatService;
    }

    public void setFlatService(FlatService flatService) {
        this.flatService = flatService;
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.GET)
    public String createFlatGetAction(Map<String, Object> model, HttpServletRequest request) {


        if (request.getParameter("buildingid") == null || !request.getParameter("buildingid").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        FlatOwner flatowner = (FlatOwner) request.getSession().getAttribute("flatowner");
        Building building = buildingService.getBuildingById(flatowner, Long.valueOf(request.getParameter("buildingid")));

        if (building == null) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        Flat flat = new Flat();
        flat.setBuilding(building);
        model.put("flat", flat);
        model.put("title", "Create Flat :");

        List<Integer> floorList = new ArrayList<Integer>();
        for (int i = 1; i <= building.getNumberOfFloors(); i++) {
            floorList.add(i);
        }
        model.put("floorlist", floorList);
        return "common/createflat";
    }

    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
    public String createFlatPostAction(@Valid Flat flat, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "common/createflat";
        } else {

            try {
                flatService.saveFlat(flat);
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return "redirect:/own/home.htm";
        }

    }

    @RequestMapping(value = "/view.htm", method = RequestMethod.GET)
    public String viewFlatGetAction(Map<String, Object> model, HttpServletRequest request) {

        if (request.getParameter("flatid") == null || !request.getParameter("flatid").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

//        long flatId = ServletRequestUtils.getLongParameter(request,"flatId",-1);
        Flat flat = flatService.getFlatById(Long.valueOf(request.getParameter("flatid")));
        if (flat == null) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }
        model.put("flat", flat);
        model.put("title", "Flat Details");
        return "common/viewflat";

    }

    @RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
    public String deleteFlatGetAction(Map<String, Object> model, HttpServletRequest request) {

        if (request.getParameter("flatid") == null || !request.getParameter("flatid").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        FlatOwner flatOwner = (FlatOwner) request.getSession().getAttribute("flatowner");
        boolean isDeleted = flatService.deleteFlatById(flatOwner, Long.valueOf(request.getParameter("flatid")));


        if (isDeleted == false) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }
        return "redirect:/own/building/buildinglist.htm";
    }


}
