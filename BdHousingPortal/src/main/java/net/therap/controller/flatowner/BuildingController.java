package net.therap.controller.flatowner;

import net.therap.domain.Building;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/6/12
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/building")
public class BuildingController {




    @RequestMapping(value = "/create.htm",method = RequestMethod.GET)
    String createBuildingGetAction(Map<String, Object> model){
        model.put("building",new Building());
        model.put("title","Building details :");
        return "flatowner/createbuilding";
    }
   /* @RequestMapping(value = "/create.htm",method = RequestMethod.POST)
    String createBuildingPostAction(@Valid Building building,BindingResult bindingResult,HttpServletRequest request){

        return "flatowner/createbuilding";
    }
*/
}
