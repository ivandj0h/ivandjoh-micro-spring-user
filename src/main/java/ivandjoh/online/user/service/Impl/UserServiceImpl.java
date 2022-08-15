package ivandjoh.online.user.service.Impl;

import ivandjoh.online.user.entity.UserMicro;
import ivandjoh.online.user.exception.BadRequestException;
import ivandjoh.online.user.exception.NotFoundException;
import ivandjoh.online.user.repository.UserRepository;
import ivandjoh.online.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserMicro addNewUser(UserMicro user) {
        try {
            if (user == null) {
                throw new NotFoundException("User is empty!");
            }
            log.info("Add New User - {}", user);
            return userRepository.save(user);
        } catch (Exception e) {
            throw new BadRequestException("Bad Request!");
        }
    }
}
