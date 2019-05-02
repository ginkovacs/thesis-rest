package hu.unideb.thesis.service;

import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import hu.unideb.thesis.models.Course;
import hu.unideb.thesis.models.Files;
import hu.unideb.thesis.models.Question;
import hu.unideb.thesis.repository.CourseRepository;
import hu.unideb.thesis.repository.FileRepository;
import hu.unideb.thesis.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;


@Service
public class FileStorageService {

    public static final String FOLDER_ID = "10tH6Xb5saghZFKVvU2qITbLck0OkjHnB";

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private QuestionRepository questionRepository;

    //!
    private File saveFileToDrive(MultipartFile file, Drive service) throws IOException {

        File body = new File();

        body.setName(file.getOriginalFilename());
        body.setParents(Collections.singletonList(FOLDER_ID));

        InputStreamContent fileContent = new InputStreamContent(file.getContentType(), file.getInputStream());

        return service.files().create(body, fileContent)
                .setFields("id, parents, webContentLink, webViewLink, name")
                .execute();
    }
    //!

    public Files storeFileToCourse(MultipartFile file, Drive service, Integer courseId) throws IOException {
        File saved = saveFileToDrive(file, service);
        Files fileToServer = new Files();
        Course course = courseRepository.getOne(courseId);

        fileToServer.setFileName(saved.getName());
        fileToServer.setLinkToServer(saved.getWebContentLink());
        fileToServer.setCourse(course);
        fileToServer.setType(file.getContentType());

        fileRepository.save(fileToServer);

        return fileToServer;
    }

    public Files storeFileToQuestion(MultipartFile file, Drive service, Integer questionId) throws IOException {
        File saved = saveFileToDrive(file, service);
        Files fileToServer = new Files();

        Question question = questionRepository.getOne(questionId);

        fileToServer.setFileName(saved.getName());
        fileToServer.setLinkToServer(saved.getWebContentLink());
        fileToServer.setQuestion(question);
        fileToServer.setType(file.getContentType());

        fileRepository.save(fileToServer);

        return fileToServer;
    }

    public List<Files> findAll(Integer courseId) {
        Optional<List<Files>> fileList = fileRepository.findAllByCourseId(courseId);

        return fileList.orElseGet(ArrayList::new);
    }
}
