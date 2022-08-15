package ivandjoh.online.user.service.Impl;

import ivandjoh.online.user.entity.UserMicro;
import ivandjoh.online.user.exception.BadRequestException;
import ivandjoh.online.user.exception.NotFoundException;
import ivandjoh.online.user.repository.UserRepository;
import ivandjoh.online.user.service.UserService;
import ivandjoh.online.user.valueobjects.Department;
import ivandjoh.online.user.valueobjects.ResponseTemplateValueObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


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

    @Override
    public ResponseTemplateValueObject getUserWithDepartment(Long userId) {

        ResponseTemplateValueObject vo = new ResponseTemplateValueObject();
        UserMicro userMicro = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found!"));

        Department department =
                restTemplate.getForObject(
                        "http://localhost:8080/api/v1/department/" + userMicro.getDepartmentId(),
                        Department.class);
        vo.setUser(userMicro);
        vo.setDepartment(department);

        return vo;
    }
}
