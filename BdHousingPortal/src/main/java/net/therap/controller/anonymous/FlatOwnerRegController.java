package net.therap.controller.anonymous;


import net.therap.domain.FlatOwner;
import net.therap.domain.User;
import net.therap.service.FlatOwnerService;
import net.therap.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private static final Logger log = LoggerFactory.getLogger(FlatOwnerRegController.class);

    @Autowired
    private FlatOwnerService flatOwnerService;

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public FlatOwnerService getFlatOwnerService() {
        return flatOwnerService;
    }

    public void setFlatOwnerService(FlatOwnerService flatOwnerService) {
        this.flatOwnerService = flatOwnerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String flatOwnerRegAction(Map<String, Object> model) {
        model.put("title", "Flat Owner Registration Form");
        model.put("flatOwner", new FlatOwner());
        return "anonymous/flatownerreg";
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveFlatOwnerAction(@Valid FlatOwner flatOwner, BindingResult bindingResult) {

        if (userService.isEmailExists(flatOwner.getUser().getEmail()) == true) {
            bindingResult.rejectValue("user.email", "email.exists");
        }

        if (!flatOwner.getUser().getPassword().equals(flatOwner.getUser().getConfirmPassword())) {
            bindingResult.rejectValue("user.confirmPassword", "password.mismatch");
        }

        if (bindingResult.hasErrors()) {
            return "anonymous/flatownerreg";
        } else {
            flatOwner.getUser().setUserType(User.FLATOWNERTYPE);
            flatOwnerService.saveFlatOwner(flatOwner);
            return "redirect:/app/login.htm";
        }

    }

}
