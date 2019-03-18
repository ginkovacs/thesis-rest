package hu.unideb.thesis.util;

import hu.unideb.thesis.models.Answer;
import hu.unideb.thesis.models.Question;
import hu.unideb.thesis.models.Test;
import hu.unideb.thesis.models.requests.AnswerRequest;
import hu.unideb.thesis.models.requests.QuestionRequest;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static List<Answer> requestToAnswerList(List<AnswerRequest> request, Question question) {
        return request.stream()
                .map(a -> {
                    Answer ans = new Answer();
                    ans.setAnswer(a.getAnswer());
                    ans.setRight(a.getRightAnswer());
                    ans.setQuestion(question);

                    return ans;
                })
                .collect(Collectors.toList());
    }

    public static List<Question> requestToQuestionList(List<QuestionRequest> request, Test test) {
        return request.stream()
                .map(q -> {
                    Question question = new Question();
                    question.setQuestion(q.getQuestion());
                    question.setAnswers(requestToAnswerList(q.getAnswers(), question));
                    question.setTest(test);

                    return question;
                })
                .collect(Collectors.toList());
    }
}
