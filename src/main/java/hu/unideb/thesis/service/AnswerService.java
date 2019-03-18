package hu.unideb.thesis.service;

import hu.unideb.thesis.models.Answer;
import hu.unideb.thesis.models.Question;
import hu.unideb.thesis.models.requests.AnswerRequest;
import hu.unideb.thesis.repository.AnswerRepository;
import hu.unideb.thesis.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public Answer addAnswer(AnswerRequest answer, Integer questionId) {
        Question question = questionRepository.getOne(questionId);

        Answer ans = new Answer();
        ans.setAnswer(answer.getAnswer());
        ans.setRight(answer.getRightAnswer());
        ans.setQuestion(question);

        answerRepository.save(ans);

        return ans;
    }

    public void deleteAnswer(Integer answerId) {
        answerRepository.deleteById(answerId);
    }

    public void updateAnswer(Integer answerId, AnswerRequest toAnswer) {
        Answer fromAnswer = answerRepository.getOne(answerId);

        if (toAnswer.getAnswer() != null) {
            fromAnswer.setAnswer(toAnswer.getAnswer());
        }

        if (toAnswer.getRightAnswer() != null) {
            fromAnswer.setRight(toAnswer.getRightAnswer());
        }

        answerRepository.save(fromAnswer);
    }

    public Answer findAnswer(Integer answerId) {
        return answerRepository.findById(answerId)
                .orElseThrow(() -> new RuntimeException("No answer found"));
    }

    public List<Answer> findAllAnswer() {
        return answerRepository.findAll();
    }
}
