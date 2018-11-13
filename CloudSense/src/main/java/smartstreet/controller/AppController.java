package smartstreet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
 
 
@Controller
@RequestMapping("/")
public class AppController {
 
    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "iotmanagerdashboard";
    }
    
    @RequestMapping(value = { "/addsensor"}, method = RequestMethod.GET)
    public String addSensor(ModelMap model) {
        return "addsensor";
    }
    
    @RequestMapping(value = { "/viewsensor"}, method = RequestMethod.GET)
    public String viewSensor(ModelMap model) {
        return "viewsensor";
    }
}