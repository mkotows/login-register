package pl.coderslab.taskplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.taskplanner.model.UserRegistration;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("registration", "user", new UserRegistration());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegister(@ModelAttribute("user") UserRegistration userRegistrationObject) {

        // authorities to be granted
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        String encodedPassword = bCryptPasswordEncoder.encode(userRegistrationObject.getPassword());

        User user = new User(userRegistrationObject.getUsername(), encodedPassword, authorities);
        jdbcUserDetailsManager.createUser(user);
        return new ModelAndView("redirect:/welcome");
    }

}
