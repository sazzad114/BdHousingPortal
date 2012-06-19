package net.therap.controller.anonymous;


import net.therap.service.FlatOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 5/29/12
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping({"/welcome.htm"})
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String welcomeAction() {
        return "anonymous/welcome";
    }


}
