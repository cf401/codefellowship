package jack.kinne.Codefellowship.controllers;

import jack.kinne.Codefellowship.models.ApplicationUser;
import jack.kinne.Codefellowship.models.ApplicationUserRepository;
import jack.kinne.Codefellowship.models.Post;
import jack.kinne.Codefellowship.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class PostController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;

    @PostMapping("/createPost")
    public RedirectView createPost(String body, Principal p, Model m) {
        ApplicationUser u = applicationUserRepository.findByUsername(p.getName());
        m.addAttribute("user", u);

        Post newPost = new Post(body, u);
        postRepository.save(newPost);

        m.addAttribute("post", newPost);

        return new RedirectView("/profile");
    }

    @PostMapping("/subscribe")
    public RedirectView subscribe(String subTo, Principal p, Model m){

        ApplicationUser me = applicationUserRepository.findByUsername(p.getName());
        ApplicationUser subbing = applicationUserRepository.findByUsername(subTo);

        m.addAttribute("user", me);

        //add users to list
        me.addSubTo(subbing);
        //add reverse
        subbing.addSubBy(me);
        
        //Post newPost = new Post(body, u);
        //postRepository.save(newPost);

        return new RedirectView( "/profiles");
    }
}
