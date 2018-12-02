package smartstreet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import smartstreet.dao.impl.UserDaoImpl;
import smartstreet.model.User;

public class UserController {

	@Autowired
	UserDaoImpl uDaoImpl = new UserDaoImpl();	
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) throws Exception {
    	uDaoImpl.addUser(user);
        return new ModelAndView("signin");        
    }
}
