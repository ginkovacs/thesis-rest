package hu.unideb.thesis.service;

import hu.unideb.thesis.models.Answer;
import hu.unideb.thesis.models.Question;
import hu.unideb.thesis.models.Test;
import hu.unideb.thesis.models.requests.AnswerRequest;
import hu.unideb.thesis.models.requests.QuestionRequest;
import hu.unideb.thesis.repository.QuestionRepository;
import hu.unideb.thesis.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static hu.unideb.thesis.util.Converter.requestToAnswerList;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TestRepository testRepository;

    public Question addQuestion(String question, List<AnswerRequest> answerList, Integer testId) {
        Test test = testRepository.getOne(testId);

        if (answerList.stream()
                .filter(AnswerRequest::getRightAnswer)
                .count() > 1) {
            throw new RuntimeException("too many right answers");
        }

        Question quest = new Question();

        List<Answer> ans = requestToAnswerList(answerList, quest);

        quest.setQuestion(question);
        quest.setAnswers(ans);
        quest.setTest(test);

        questionRepository.save(quest);

        return quest;
    }

    public void deleteQuestion(Integer questionId) {
        questionRepository.deleteById(questionId);
    }

    public void updateQuestion(Integer questionId, QuestionRequest toQuestion) {
        Question fromQuestion = questionRepository.getOne(questionId);

        if (toQuestion.getQuestion() != null) {
            fromQuestion.setQuestion(toQuestion.getQuestion());
        }

        if (toQuestion.getAnswers() != null) {
            fromQuestion.setAnswers(requestToAnswerList(toQuestion.getAnswers(), fromQuestion));
        }

        questionRepository.save(fromQuestion);
    }

    public Question findQuestion(Integer questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("No question found"));
    }

    public List<Question> findAllQuestion(Integer testId) {
        Optional<List<Question>> questionList = questionRepository.findAllByTestId(testId);

        return questionList.orElseGet(ArrayList::new);
    }


}
