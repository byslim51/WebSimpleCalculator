package org.example.calculator.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NumAndActionController {

    public void checkLastActionAndAddNum(char numOrAction) {
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

    @GetMapping("/add/{num}")
    public String add(@PathVariable("num")char cr, HttpServletRequest request) {
        if (cr == 'd') { // divide
            checkLastActionAndAddNum('/');
        } else if(cr == 'm') { // minus
            checkLastActionAndAddNum('-');
        } else if (cr == 'u') { // multiply
            checkLastActionAndAddNum('*');
        } else if (cr == 'p') { // plus
            checkLastActionAndAddNum('+');
        } else if (cr == 'f') { // fractional
            checkLastActionAndAddNum('.');
        } else {
            checkLastActionAndAddNum(cr);
        }
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
