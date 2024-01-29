package org.yplinq.assignments.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController class for handling API requests and providing server responses
 */
@RestController
public class APIController {

    @GetMapping("/")
    public String Home(){
        return "Hello, My Server!";
    }

    @GetMapping("/data")
    public String getNumber(@RequestParam(name = "number",required = false) String xyz){
        System.out.println(xyz);

        if (xyz == null) {
            return "Lack of Parameter";
        }
        try {
            int num = Integer.parseInt(xyz); //parseInt fail will throw error before continue,所以要放在try 裡面
            return (num>0?sumOfSeq(num).toString():"Wrong Parameter" );
        } catch (Exception e) {
            return "Wrong Parameter";
        }

    }

    /**
     * Add up all the number from 1 to the number. Return the result
     * @param num : the num you want to addup from 1 ,
     * @return sum of (1+2+3+...+num)
     */
    private Integer sumOfSeq(int num){
        int sumOfNum=0;
        for(int i=0;i<=num;i++){
            sumOfNum+=i;
        }
        return sumOfNum;
    }

}



