package org.example.calculator.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    static List<Character> numbers_actions = new ArrayList<>();
    static double result;

    @GetMapping("/enterNumbers")
    public String enterNumbers(Model model, HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        for (char nums : numbers_actions) {
            sb.append(nums);
        }
        model.addAttribute("num", sb);
        return "index";
    }

    @GetMapping("/")
    public String getIndex(Model model, HttpServletRequest request) {
        return "index.html";
    }

    @GetMapping("/result")
    public String result(Model model, HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        double number = 0;
        result = 0;
        char lastAction = '+';

        for (char num_action_list : numbers_actions) {
            if (Character.isDigit(num_action_list)) {
                sb.append(num_action_list);
            } else {
                if (sb.length() > 0) {
                    number = Double.parseDouble(sb.toString());
                    sb.setLength(0);
                }

                switch (lastAction) {
                    case '+':
                        result += number;
                        break;
                    case '-':
                        result -= number;
                        break;
                    case '*':
                        result *= number;
                        break;
                    case '/':
                        if (number != 0) {
                            result /= number;
                        } else {
                            model.addAttribute("num", "Ошибка: делить на ноль нельзя");
                            numbers_actions.clear();
                            return "index";
                        }
                        break;
                }

                lastAction = num_action_list;
            }
        }

        if (sb.length() > 0) {
            number = Double.parseDouble(sb.toString());
            switch (lastAction) {
                case '+':
                    result += number;
                    break;
                case '-':
                    result -= number;
                    break;
                case '*':
                    result *= number;
                    break;
                case '/':
                    if (number != 0) {
                        result /= number;
                    } else {
                        model.addAttribute("num", "Ошибка: деление на ноль");
                        numbers_actions.clear();
                        return "index";
                    }
                    break;
            }
        }

        model.addAttribute("num", result);
        numbers_actions.clear();
        return "index";
    }

    public static List<Character> getNumbers_actions() {
        return numbers_actions;
    }

    public static void setNumbers_actions(List<Character> numbers_actions) {
        IndexController.numbers_actions = numbers_actions;
    }
}

