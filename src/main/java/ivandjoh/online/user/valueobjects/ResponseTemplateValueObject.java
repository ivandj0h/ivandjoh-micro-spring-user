package ivandjoh.online.user.valueobjects;

import ivandjoh.online.user.entity.UserMicro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateValueObject {

    private UserMicro user;
    private Department department;
}
