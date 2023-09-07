package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.User;
import ra.model.service.IUserService;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

      @GetMapping("/")
    public ModelAndView getRegister() {
        return new ModelAndView("/register","user",new User());
    }
    @GetMapping("/result")
    public String result(){
          return "/result";
    }

    @PostMapping("/register")
    public String doRegister(@Validated @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "/register";
        }
        return "redirect:/result";
    }

}
