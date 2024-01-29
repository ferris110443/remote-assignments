package org.yplinq.assignments.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * WebController class for handling API requests and add cookies .
 */
@Controller
public class WebController {


    @GetMapping("/myName")
    public String getMyName(@CookieValue(name = "userNameCookie", defaultValue = "Guest") String userCookie, Model model) {
        System.out.println("userNameCookie: " + userCookie);
        model.addAttribute("userName", userCookie); // pass to view for rendering
        return( userCookie.equals("Guest")? "trackName" : "myName");

//        if (userCookie.equals("Guest")) {
//            return "trackName"; // user submit wait extracting req para
//        } else {
//            return "myName";
//        }
    }


    @GetMapping("/trackName{trackName}")
    public String setUserCookie(HttpServletResponse response, @RequestParam(name = "name") String username) { //bind "name" req para from trackName to username
        if ((username != null) && (!username.isEmpty())) {
            System.out.println(username);
            Cookie cookie = new Cookie("userNameCookie", username);
            response.addCookie(cookie);
        }
        return "redirect:/myName";
    }


}