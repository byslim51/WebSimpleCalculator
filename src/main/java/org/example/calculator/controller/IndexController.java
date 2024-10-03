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

    @GetMapping("/one")
    public String one(Model model, HttpServletRequest request) {
        numbers_actions.add('1');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/two")
    public String two(Model model, HttpServletRequest request) {
        numbers_actions.add('2');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/three")
    public String three(Model model, HttpServletRequest request) {
        numbers_actions.add('3');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/four")
    public String four(Model model, HttpServletRequest request) {
        numbers_actions.add('4');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/five")
    public String five(Model model, HttpServletRequest request) {
        numbers_actions.add('5');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/six")
    public String six(Model model, HttpServletRequest request) {
        numbers_actions.add('6');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/seven")
    public String seven(Model model, HttpServletRequest request) {
        numbers_actions.add('7');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/eight")
    public String eight(Model model, HttpServletRequest request) {
        numbers_actions.add('8');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/nine")
    public String nine(Model model, HttpServletRequest request) {
        numbers_actions.add('9');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/zero")
    public String zero(Model model, HttpServletRequest request) {
        numbers_actions.add('0');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/multiply")
    public String multiply(Model model, HttpServletRequest request) {
        numbers_actions.add('*');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/divide")
    public String divide(Model model, HttpServletRequest request) {
        numbers_actions.add('/');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/plus")
    public String plus(Model model, HttpServletRequest request) {
        numbers_actions.add('+');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/minus")
    public String minus(Model model, HttpServletRequest request) {
        numbers_actions.add('-');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/fractional")
    public String fractional(Model model, HttpServletRequest request) {
        numbers_actions.add('.');
        return "redirect:/enterNumbers";
    }

    @GetMapping("/delete")
    public String delete(Model model, HttpServletRequest request) {
        if (!numbers_actions.isEmpty()) {
            numbers_actions.remove(numbers_actions.size() - 1);
        }
        return "redirect:/enterNumbers";
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
}

