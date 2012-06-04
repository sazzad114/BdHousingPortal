package net.therap.controller;


import net.therap.domain.FlatOwner;
import net.therap.service.FlatOwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 5/31/12
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/flatownerreg.htm")
public class FlatOwnerRegController {

    @Autowired
    FlatOwnerService flatOwnerService;

    public FlatOwnerService getFlatOwnerService() {
        return flatOwnerService;
    }

    public void setFlatOwnerService(FlatOwnerService flatOwnerService) {
        this.flatOwnerService = flatOwnerService;
    }

    private static final Logger log = LoggerFactory.getLogger(FlatOwnerRegController.class);

    @RequestMapping(method = RequestMethod.GET)
    String flatOwnerRegAction(Map<String, Object> model) {

        model.put("flatOwner", new FlatOwner());
        return "flatownerreg";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveFlatOwnerAction(@Valid FlatOwner flatOwner,BindingResult bindingResult) {

        if(flatOwnerService.isEmailExists(flatOwner.getUser().getEmail()) == true){
            bindingResult.rejectValue("user.email","email.exists");
        }

        if(!flatOwner.getUser().getPassword().equals(flatOwner.getUser().getConfirmPassword())){
           bindingResult.rejectValue("user.confirmPassword","password.mismatch");
        }



        if (bindingResult.hasErrors()) {

            return "flatownerreg";
        }
        else {
             flatOwnerService.saveFlatOwner(flatOwner);
             return "welcome";
        }
    }


}
