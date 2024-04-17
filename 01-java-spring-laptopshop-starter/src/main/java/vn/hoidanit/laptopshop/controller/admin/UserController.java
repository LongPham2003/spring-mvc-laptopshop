package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {

        List<User> arrUser = this.userService.getAllUserByEmail("sadad");
        System.out.println(arrUser);
        String test = this.userService.handleHello();
        model.addAttribute("eric", test);
        model.addAttribute("hoidanid", "from hello with model ");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("users1", users);
        System.out.println(users);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        model.addAttribute("userdetail", this.userService.getByIdUser(id));
        model.addAttribute("id", id);
        return "admin/user/detail";
    }

    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User updateUser = this.userService.getByIdUser(id);
        model.addAttribute("newUser", updateUser);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String UpdateUser(Model model, @ModelAttribute("newUser") User hoidanit) {
        User user = this.userService.getByIdUser(hoidanit.getId());
        if (user != null) {
            user.setAddress(hoidanit.getAddress());
            user.setFullname(hoidanit.getFullname());
            user.setPhone(hoidanit.getPhone());
            user.setEmail(hoidanit.getEmail());
            this.userService.handleSaveUser(user);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String dedeleteById(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        User user = new User();
        user.setId(id);
        model.addAttribute("newUser", new User());
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String deleteUser(Model model, @ModelAttribute("newUser") User eric) {
        this.userService.deleteUser(eric.getId());
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User hoidanit) {
        this.userService.handleSaveUser(hoidanit);
        return "redirect:/admin/user";
    }

}

// @RestController
// public class UserController {
// private UserService userService ;

// public UserController(UserService userService) {
// this.userService = userService;
// }
// @GetMapping("")
// public String getHomePage() {
// return this.userService.handleHello();
// }
// }
