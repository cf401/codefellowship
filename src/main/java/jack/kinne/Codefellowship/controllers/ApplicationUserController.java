package jack.kinne.Codefellowship.controllers;

import jack.kinne.Codefellowship.models.ApplicationUser;
import jack.kinne.Codefellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ApplicationUserController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @PostMapping("/users")
    public RedirectView createUser(String username, String password, String fullname) {
        ApplicationUser newUser = new ApplicationUser(username,
                // bcrypt handles hashing/salting
                encoder.encode(password),
                fullname);
        applicationUserRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/profile");
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/profile/{id}")
    public String getOneProfile(@PathVariable long id, Model m) {
        ApplicationUser u = applicationUserRepository.findById(id).get();
        m.addAttribute("user", u);
        return "profile";
    }

    @GetMapping("/profile")
    public String getProfile(Principal p, Model m) {
        ApplicationUser u = applicationUserRepository.findByUsername(p.getName());
        m.addAttribute("user", u);
        return "profile";
    }

    @GetMapping("/profiles")
    public String getAllProfiles(Model m) {
        List<ApplicationUser> users = applicationUserRepository.findAll();
        m.addAttribute("users", users);
        return "profiles";
    }
}
