package community.xueshi.service;

import community.xueshi.dto.PaginationDTO;
import community.xueshi.dto.QuestionDTO;
import community.xueshi.mapper.QuestionMapper;
import community.xueshi.mapper.UserMapper;
import community.xueshi.model.Question;
import community.xueshi.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();

        int totalPage = (int) Math.ceil((double) totalCount / size);
        if(page < 1) page = 1;
        if(page > totalPage) page = totalPage;

        paginationDTO.setPagination(totalPage, page);

        Integer offset = size*(page-1);
        List<Question> questions = questionMapper.list(offset, size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);

        return paginationDTO;
    }

    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.countByUserId(userId);

        int totalPage = (int) Math.ceil((double) totalCount / size);
        if(page < 1) page = 1;
        if(page > totalPage) page = totalPage;

        paginationDTO.setPagination(totalPage, page);

        Integer offset = size*(page-1);
        List<Question> questions = questionMapper.listByUserId(userId, offset, size);
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);

        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        Question question = questionMapper.getById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if(question.getId() == null){
            question.setGmt_create(System.currentTimeMillis());
            question.setGmt_modified(question.getGmt_create());
            questionMapper.create(question);
        }
        else{
            question.setGmt_create(System.currentTimeMillis());
            question.setGmt_modified(question.getGmt_create());
            questionMapper.update(question);
        }
    }
}
