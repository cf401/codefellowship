package jack.kinne.Codefellowship.controllers;

import jack.kinne.Codefellowship.models.ApplicationUser;
import jack.kinne.Codefellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/")
    public String getRoot(Principal p, Model m) {
        if(p!=null) {
            m.addAttribute("activeUser", p);
            ApplicationUser u = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("user", u);
        }
        return "root";
    }

    @GetMapping("/signup")
    public String getSignup() {
        return "registration";
    }
}
