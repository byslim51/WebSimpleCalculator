package org.example.calculator.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.example.calculator.controller.IndexController;

@Controller
public class NumAndActionController {

    public void addNum(char numOrAction) {
        if (!IndexController.getNumbers_actions().isEmpty()) {
            char lastAction = IndexController.getNumbers_actions().get(IndexController.getNumbers_actions().size() - 1);
            if (Character.isDigit(lastAction)) { // если последний симв цифра
                IndexController.getNumbers_actions().add(numOrAction);
            } else {  // если последний симв действие
                if (!Character.isDigit(numOrAction)) {
                    IndexController.getNumbers_actions().remove(IndexController.getNumbers_actions().get(IndexController.getNumbers_actions().size() - 1));
                    IndexController.getNumbers_actions().add(numOrAction);
                } else {
                    IndexController.getNumbers_actions().add(numOrAction);
                }
            }
        } else {
            IndexController.getNumbers_actions().add(numOrAction);
        }

    }

    @GetMapping("/one")
    public String one(Model model, HttpServletRequest request) {
        addNum('1');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/two")
    public String two(Model model, HttpServletRequest request) {
        addNum('2');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/three")
    public String three(Model model, HttpServletRequest request) {
        addNum('3');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/four")
    public String four(Model model, HttpServletRequest request) {
        addNum('4');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/five")
    public String five(Model model, HttpServletRequest request) {
        addNum('5');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/six")
    public String six(Model model, HttpServletRequest request) {
        addNum('6');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/seven")
    public String seven(Model model, HttpServletRequest request) {
        addNum('7');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/eight")
    public String eight(Model model, HttpServletRequest request) {
        addNum('8');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/nine")
    public String nine(Model model, HttpServletRequest request) {
        addNum('9');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/zero")
    public String zero(Model model, HttpServletRequest request) {
        addNum('0');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/multiply")
    public String multiply(Model model, HttpServletRequest request) {
        addNum('*');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/divide")
    public String divide(Model model, HttpServletRequest request) {
        addNum('/');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/plus")
    public String plus(Model model, HttpServletRequest request) {
        addNum('+');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/minus")
    public String minus(Model model, HttpServletRequest request) {
        addNum('-');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/fractional")
    public String fractional(Model model, HttpServletRequest request) {
        addNum('.');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/delete")
    public String delete(Model model, HttpServletRequest request) {
        if (!IndexController.getNumbers_actions().isEmpty()) {
            IndexController.getNumbers_actions().remove(IndexController.getNumbers_actions().size() - 1);
        }
        return "redirect:/enterNumbers";
    }
}
