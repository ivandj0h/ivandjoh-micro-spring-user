package ivandjoh.online.user.service;

import ivandjoh.online.user.entity.UserMicro;
import ivandjoh.online.user.valueobjects.ResponseTemplateValueObject;

public interface UserService {
    UserMicro addNewUser(UserMicro user);

    ResponseTemplateValueObject getUserWithDepartment(Long userId);
}
