package pers.xiaoming.springboot.ssm.api;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import pers.xiaoming.springboot.ssm.exception.exceptionmapper.BadRequestExceptionMapper;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(StudentResource.class);

        // Exception mapper also register here
        register(BadRequestExceptionMapper.class);
    }
}
