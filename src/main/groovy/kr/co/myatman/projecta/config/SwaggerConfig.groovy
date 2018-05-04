package kr.co.myatman.projecta.config

import com.google.common.base.Predicate
import kr.co.myatman.projecta.account.LoginUser
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.service.VendorExtension
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(LoginUser.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage('kr.co.myatman.projecta.web'))
                .paths(paths())
                .build()
                .apiInfo(apiInfo())
    }

    static Predicate<String> paths() {
        return com.google.common.base.Predicates.or(
                springfox.documentation.builders.PathSelectors.ant("/v1/**")
        )
    }

    static ApiInfo apiInfo() {
        new ApiInfo('DEMO API', 'DEMO API 문서입니다.', '1.0', '',
                new Contact('demo', 'https://spoved.org', 'hello@crazyguys.me'),
                '', '', new ArrayList<VendorExtension>())
    }
}
