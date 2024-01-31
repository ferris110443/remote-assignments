package org.yplinq.assignments.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController class for handling API requests and providing server responses
 */
@RestController
public class APIController {

    @GetMapping("/")
    public String Home() {
        return "Hello, My Server!";
    }

    @GetMapping("/data")
    public String getNumber(@RequestParam(name = "number", required = false) String userInput) {
        System.out.println("userInput :" + userInput);
        if (userInput.isEmpty()) {
            System.out.println("Lack of Parameter");
            return "Lack of Parameter";
        }

        try {
            long num = Long.parseLong(userInput); //parseInt fail will throw error before continue, keep in try statement
            if (num > 0) {
                return sumOfSeq(num).toString();
            } else {
                System.out.println("Wrong Parameter");
                return "Wrong Parameter";
            }

        } catch (Exception e) {
            System.out.println("Wrong Parameter");
            return "Wrong Parameter";
        }
    }


    /**
     * Add up all the number from 1 to the number. Return the result
     *
     * @param num : the num you want to addup from 1 ,
     * @return sum of (1+2+3+...+num)
     */
    public Long sumOfSeq(long num) {
        return num * (num + 1) / 2;
    }

}



