package org.yplinq.assignment3.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.yplinq.assignment3.entity.UserInformation;
import org.yplinq.assignment3.repository.UserInformationRepository;

import java.util.List;


/**
 * Handling all controller
 */
@Controller
public class UserController {

    @Autowired
    private UserInformationRepository userInformationRepository;

    @GetMapping("/home")
    public String homeController() {
        return "home";
    }


    /**
     * Handle userSignup success and fail condition
     *
     * @param email:   userEmail
     * @param password : userPassword
     * @param model    :String class for passing data to view
     * @param response : pass in function to set up cookie
     * @return : successfully signIn redirect memberPage ,if signIn fail return home
     */
    @PostMapping("/signIn")
    public String signInController(@RequestParam(name = "userSignInEmail") String email, @RequestParam(name = "userSignInPassword") String password, Model model, HttpServletResponse response) {
        List<UserInformation> userEmailList = userInformationRepository.findByEmail(email);
        if (userEmailList.isEmpty()) {
            model.addAttribute("alertMessage", "Account doesn't exist, please sign up");
            return "home";
        }

        String userEmail = userEmailList.get(0).getEmail();
        String userPassword = userEmailList.get(0).getPassword();
        if (userEmail.equals(email) && userPassword.equals(password)) {
            setCookie(response, email);
            model.addAttribute("userEmail", email);
            return "redirect:/memberPage";
        } else {
            model.addAttribute("alertMessage", "Password is wrong");
            return "home";
        }

    }

    /**
     * Handle userSignup , save Email and password to SQL database
     *
     * @param email:   userEmail
     * @param password : userPassword
     * @param model    :String class for passing data to view
     * @param response : pass in function to set up cookie
     * @return : successfully signup redirect memberPage ,if signup fail return home
     */
    @PostMapping("/signUp")
    public String signUpController(@RequestParam(name = "userSignUpEmail") String email, @RequestParam(name = "userSignUpPassword") String password, Model model, HttpServletResponse response) {
        List<UserInformation> userEmailList = userInformationRepository.findByEmail(email);
        if (userEmailList.isEmpty()) {
            UserInformation user = new UserInformation();
            user.setEmail(email);
            user.setPassword(password);
            userInformationRepository.save(user);
            setCookie(response, email);
            return "redirect:/memberPage";
        } else {
            model.addAttribute("alertMessage", "The email has been registered");
            return "home";
        }
    }

    /**
     * Login in/ SignUp successfully render memberPage
     *
     * @param model:     String class for passing data to view
     * @param userEmail: fetch userEmail from cookie for rendering in view
     * @return: return login page memberPage
     */
    @GetMapping("/memberPage")
    public String memberPageController(Model model, @CookieValue(value = "Email") String userEmail) {
        System.out.println("email: " + userEmail);
        model.addAttribute("successLoginMessage", "Login successfully");
        model.addAttribute("userEmail", userEmail);
        return "memberPage";
    }

    /**
     * Render all user email / password in response body, findAll() return iterable
     *
     * @return: return list of userInformation in a JSON format
     */
    @GetMapping("/all")
    @ResponseBody // return value should be written to response body , not treated as view
    public Iterable<UserInformation> getAllUsers() {
        return userInformationRepository.findAll();
    }


    /**
     * Restore userEmail in cookie for memberPage fetching userEmail
     *
     * @param response: response to client browser
     * @param email:    email on cookie value
     */
    void setCookie(HttpServletResponse response, String email) {
        Cookie cookie = new Cookie("Email", email);
        response.addCookie(cookie);
    }


}


