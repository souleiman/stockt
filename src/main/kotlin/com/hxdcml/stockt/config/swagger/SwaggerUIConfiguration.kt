package com.hxdcml.stockt.config.swagger

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.UiConfiguration
import springfox.documentation.swagger.web.UiConfigurationBuilder
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerUIConfiguration {
    @Value("\${application.basePackage}")
    private lateinit var basePackage: String

    @Value("\${application.version}")
    private lateinit var version: String

    @Value("\${application.title}")
    private lateinit var title: String

    @Value("\${application.description}")
    private lateinit var description: String

    @Value("\${application.contact.name}")
    private lateinit var name: String

    @Value("\${application.contact.url}")
    private lateinit var url: String

    @Value("\${application.contact.email}")
    private lateinit var email: String

    @Bean
    fun docket(api: ApiInfo): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(api)
            .select()
            .apis(RequestHandlerSelectors.basePackage(basePackage))
            .paths(PathSelectors.any())
            .build()
    }

    @Bean
    fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .contact(Contact(name, url, email))
            .title(title)
            .description(description)
            .version(version)
            .build()
    }

    @Bean
    fun uiConfiguration(): UiConfiguration {
        return UiConfigurationBuilder.builder()
            .displayRequestDuration(true)
            .build()
    }
}