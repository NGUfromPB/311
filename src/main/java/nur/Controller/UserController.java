package nur.Controller;
import nur.models.User;
import nur.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class UserController {
    private final UserServ userServ;

    @Autowired()
    public UserController(UserServ userServ) {
        this.userServ = userServ;
    }
    @GetMapping("/")
    public String users(Model model) {
        model.addAttribute("users", userServ.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser (@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userServ.findById(id));
        return "user";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user")  User user) {

        return "new";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") User user) {
        userServ.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userServ.removeUser(id);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute(userServ.findById(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid User user,@PathVariable("id") long id) {
        user.setUserId(id);
        userServ.addUser(user);
        return "redirect:/";
    }
}
