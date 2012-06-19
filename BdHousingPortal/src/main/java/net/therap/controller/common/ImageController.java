package net.therap.controller.common;

import net.therap.exception.ApplicationException;
import net.therap.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/13/12
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    FlatService flatService;

    public FlatService getFlatService() {
        return flatService;
    }

    public void setFlatService(FlatService flatService) {
        this.flatService = flatService;
    }

    @RequestMapping(value = "/flatimage.htm", method = RequestMethod.GET)
    void getFlatImageAction(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("flatid") == null || !request.getParameter("flatid").matches("[0-9]+")) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

        try {
            byte[] imageBytes = flatService.getImageData(Long.valueOf(request.getParameter("flatid")));

            response.setContentType("image/jpg");
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(imageBytes);
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            throw new ApplicationException(" You are trying to access Illegal resource...");
        }

    }
}
