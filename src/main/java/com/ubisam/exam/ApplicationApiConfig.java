package com.ubisam.exam;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

<<<<<<< HEAD
import com.ubisam.exam.domain.Address;
import com.ubisam.exam.domain.AddressGroup;

import io.u2ware.common.data.jpa.config.EnableRestfulJpaRepositories;
=======
// import com.ubisam.exam.domain.AddressGroup;
// import io.u2ware.common.data.jpa.config.EnableRestfulJpaRepositories;
// import com.ubisam.exam.domain.Address;
>>>>>>> 0c893d8988430cc347921237be980fb47eb20eb7

@Configuration
@EnableRestfulJpaRepositories
@EnableJpaRepositories
public class ApplicationApiConfig implements RepositoryRestConfigurer{
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // /api 주소 설정
        config.setBasePath("/api");
        // id 노출 설정
<<<<<<< HEAD
        config.exposeIdsFor(Address.class, AddressGroup.class);
=======
        // config.exposeIdsFor(Address.class, AddressGroup.class);
        //
>>>>>>> 0c893d8988430cc347921237be980fb47eb20eb7
        config.setReturnBodyForPutAndPost(true);
        // CORS 설정 - 모든 주소 허용, 모든 메소드 허용, 쿠키 허용 안함, maxAge 설정
        cors.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
            .allowCredentials(false)
            .maxAge(999999);
    }
}
