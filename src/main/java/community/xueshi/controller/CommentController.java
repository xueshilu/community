package community.xueshi.controller;

import community.xueshi.dto.CommentDTO;
import community.xueshi.dto.ResultDTO;
import community.xueshi.exception.CustomizeErrorCode;
import community.xueshi.mapper.CommentMapper;
import community.xueshi.model.Comment;
import community.xueshi.model.User;
import community.xueshi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
//        if (user.getDisable() != null && user.getDisable() == 1) {
//            return ResultDTO.errorOf(CustomizeErrorCode.USER_DISABLE);
//        }
//        if (commentCreateDTO == null || StringUtils.isBlank(commentCreateDTO.getContent())) {
//            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
//        }
//        if (questionRateLimiter.reachLimit(user.getId())) {
//            return ResultDTO.errorOf(CustomizeErrorCode.RATE_LIMIT);
//        }

        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setParentType(commentDTO.getParentType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommenter(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }


}
