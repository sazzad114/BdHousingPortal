package net.therap.controller.anonymous;

import junit.framework.TestCase;
import net.therap.controller.common.FlatController;
import net.therap.domain.Customer;
import net.therap.exception.ApplicationException;
import net.therap.service.BuildingService;
import net.therap.service.CustomerService;
import net.therap.service.FlatService;
import net.therap.service.UserService;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/19/12
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class FlatControllerTest {

    BuildingService buildingService;
    FlatService flatService;
    HttpServletRequest request;
    HttpSession httpSession;
    FlatController flatController;

    @Before
    public void setUp(){

      buildingService = EasyMock.createMock(BuildingService.class);
      flatService = EasyMock.createMock(FlatService.class);
      request= EasyMock.createMock(HttpServletRequest.class);
      httpSession = EasyMock.createMock(HttpSession.class);
      flatController = new FlatController();
    }


    @Test(expected = ApplicationException.class)
    public void testCreateFlatGetActionParam(){

        EasyMock.expect(request.getParameter("buildingid")).andReturn(null).times(1);
        EasyMock.replay(request);
        flatController.createFlatGetAction(new HashMap<String,Object>(),request);
    }


}
