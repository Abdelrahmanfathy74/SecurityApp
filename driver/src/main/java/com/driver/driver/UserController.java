package com.driver.driver;
import com.driver.driver.model.User;
import com.driver.driver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {

        user.setName(user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(user.getRoles());
        user.setPhone_number(user.getPhone_number());
        user.setEmail(user.getEmail());
        userService.save(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

}
