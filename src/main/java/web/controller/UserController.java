package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService service;


    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {

        return "redirect:users";
    }


    @GetMapping("/users")
    public String showUsers(Model model) {

        model.addAttribute("users", service.listUsers());
        return "users";
    }

    @GetMapping("/add")
    public String addUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "add";
    }

    @PostMapping("/input")
    public String inputUser(@ModelAttribute("user") User user) {

        service.addUser(user);
        return "redirect:users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {

        model.addAttribute("editable_user", service.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("editable_user") User user, @PathVariable("id") Long id) {

        service.editUser(id, user);
        return "redirect:users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {

        service.deleteUser(id);
        return "redirect:users";
    }


}
