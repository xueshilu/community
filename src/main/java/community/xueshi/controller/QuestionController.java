package community.xueshi.controller;

import community.xueshi.dto.QuestionDTO;
import community.xueshi.mapper.QuestionExtMapper;
import community.xueshi.model.User;
import community.xueshi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model,
                           HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        QuestionDTO questionDTO = questionService.getById(id);
        questionService.incView(id);
        questionDTO.setUser(user);
        model.addAttribute("question", questionDTO);


        return "question";
    }
}
