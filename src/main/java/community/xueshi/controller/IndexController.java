package community.xueshi.controller;

import community.xueshi.dto.QuestionDTO;
import community.xueshi.mapper.QuestionMapper;
import community.xueshi.mapper.UserMapper;
import community.xueshi.model.Question;
import community.xueshi.model.User;
import community.xueshi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0)
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user != null){
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }

        List<QuestionDTO> questions = questionService.list();
        model.addAttribute("questions", questions);
        return "index";
    }
}
