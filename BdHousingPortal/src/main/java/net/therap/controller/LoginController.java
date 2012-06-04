package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/4/12
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginController {

     @Autowired
     UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value ="/login.htm" ,method = RequestMethod.POST)
     void loginAction(@Valid User user){
       /* if (userService.isEmailExists(flatOwner.getUser().getEmail()) == true) {
            bindingResult.rejectValue("user.email", "email.exists");
        }

        if (bindingResult.hasErrors()) {

            return "flatownerreg";
        } else {
            flatOwner.getUser().setUserType(User.FLATOWNERTYPE);
            flatOwnerService.saveFlatOwner(flatOwner);
            return "welcome";
        }
*/
     }

}
