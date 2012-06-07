package net.therap.controller.common;

import net.therap.domain.Building;
import net.therap.domain.Flat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/7/12
 * Time: 5:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/flat")
public class FlatController {

    @RequestMapping(value = "/create.htm")
    public String createFlatAction(Map<String, Object> model){
        model.put("flat",new Flat());
        model.put("title","Create Flat :");
        return "common/createflat";
    }
}
