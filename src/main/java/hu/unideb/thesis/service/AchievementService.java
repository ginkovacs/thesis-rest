package hu.unideb.thesis.service;

import hu.unideb.thesis.models.Achievement;
import hu.unideb.thesis.models.AchievementType;
import hu.unideb.thesis.models.Test;
import hu.unideb.thesis.models.User;
import hu.unideb.thesis.models.requests.AchievementRequest;
import hu.unideb.thesis.repository.AchievementRepository;
import hu.unideb.thesis.repository.AchievementTypeRepository;
import hu.unideb.thesis.repository.TestRepository;
import hu.unideb.thesis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AchievementService {
    private AchievementRepository achievementRepository;
    private UserRepository userRepository;
    private TestRepository testRepository;
    private AchievementTypeRepository achievementTypeRepository;
    private List<AchievementType> achievementTypeCache = new ArrayList<>();

    @Autowired
    public AchievementService(AchievementRepository achievementRepository, UserRepository userRepository,
                              TestRepository testRepository, AchievementTypeRepository achievementTypeRepository) {
        this.achievementRepository = achievementRepository;
        this.userRepository = userRepository;
        this.testRepository = testRepository;
        this.achievementTypeRepository = achievementTypeRepository;

        for (int i=1; i<4; i++) {
            AchievementType achievementType = achievementTypeRepository.getOne(i);

            achievementTypeCache.add(achievementType);
        }
    }

    public Achievement addAchievement(AchievementRequest achievementRequest) {
        User user = userRepository.findByEmail(achievementRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Email not found."));

        Test test = testRepository.getOne(achievementRequest.getTestId());

        Achievement achievement = new Achievement();
        achievement.setUser(user);
        achievement.setTest(test);
        achievement.setDate(achievementRequest.getDate());
        achievement.setTime(achievementRequest.getTime());
        achievement.setPercent(achievementRequest.getPercent());

        List<Achievement> achiList;
        try {
            achiList = achievementRepository.findAllByTestId(test.getId()).get();
        }
        catch (NoSuchElementException e) {
            achiList = new ArrayList<>();
        }

        if (achiList.isEmpty()) {
            for (int i=0; i<3; i++) {
                achievement.setAchievementType(achievementTypeCache.get(i));

                achievementRepository.save(achievement);
            }
        }
        else {
            for (Achievement achi : achiList) {
                boolean delete = false;
                if (achievement.getTime() < achi.getTime()) {
                    delete = true;
                    achievement.setAchievementType(achievementTypeCache.get(0));
                    achievementRepository.save(achievement);
                }

                if (achievement.getPercent() > achi.getPercent()) {
                    delete = true;
                    achievement.setAchievementType(achievementTypeCache.get(1));
                    achievementRepository.save(achievement);
                }

                if (delete) {
                    achievementRepository.deleteById(achi.getId());
                }
            }
        }

        return achievement;
    }

    public List<Achievement> findAll() {
        List<Achievement> achiList = achievementRepository.findAll();

        return achiList;
    }
}
