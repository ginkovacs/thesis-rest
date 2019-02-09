package hu.unideb.thesis.service;

import hu.unideb.thesis.models.User;
import hu.unideb.thesis.models.UserReg;
import hu.unideb.thesis.repository.LoginRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    private boolean checkUsername (String email) {
        return loginRepository.existsById(email);
    }

    public void register (UserReg userreg) {
        Assert.hasLength(userreg.getEmail(), "Missing email.");
        Assert.hasLength(userreg.getUsername(), "Missing username.");

        if(userreg.getEmail().length()>256) {
            throw new RuntimeException("email too long");
        }

        if (checkUsername(userreg.getEmail())) {
            throw new RuntimeException("Email already exists.");
        }

        if(userreg.getUsername().length()>45) {
            throw new RuntimeException("username too long");
        }

        Range<Integer> range = Range.between(5, 45);
        if (!range.contains(userreg.getPassword().length())) {
            throw new RuntimeException("Password must be between 5 and 45 characters.");
        }

        userreg.setPassword(DigestUtils.sha256Hex(userreg.getPassword()));

        loginRepository.save(userreg);
    }

    public void login (User user) {
        Assert.hasLength(user.getEmail(), "Missing email.");

    }

}

