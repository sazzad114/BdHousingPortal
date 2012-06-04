package net.therap.controller;


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
public class WelcomeController{

    public FlatOwnerService getFlatOwnerService() {
        return flatOwnerService;
    }

    public void setFlatOwnerService(FlatOwnerService flatOwnerService) {
        this.flatOwnerService = flatOwnerService;
    }

    @Autowired

    private FlatOwnerService flatOwnerService;

    @RequestMapping(method = RequestMethod.GET)
    public String welcomeAction(){

       /* FlatOwner flatOwner = new FlatOwner();
        flatOwner.setFlatOwnerName("habahashmat");
        flatOwner.getUser().setUserType(2);
        flatOwner.getUser().setEmail("ashraf@yahoo.com");
        flatOwner.getUser().setPassword("123456789");
        flatOwnerService.saveFlatOwner(flatOwner);*/
        return "welcome";
    }


}
