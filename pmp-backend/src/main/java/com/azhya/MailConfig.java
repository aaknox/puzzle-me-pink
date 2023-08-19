package com.azhya;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import dev.ditsche.mailo.config.MailoConfig;
import dev.ditsche.mailo.config.SmtpConfig;
import dev.ditsche.mailo.provider.MailProvider;
import dev.ditsche.mailo.provider.SmtpMailProvider;

@Configuration
public class MailConfig {
	
	public MailConfig() {
        MailoConfig config = MailoConfig.get();
        config.setTemplateDirectory("./mails/");
        config.setMjmlAppId(System.getenv("PMP_MJML_ID"));
        config.setMjmlAppSecret(System.getenv("PMP_MJML_SECRET"));
    }

	@Bean
    public MailProvider mailProvider() {
        SmtpConfig config = new SmtpConfig();
        config.setHost("smtp.gmail.com");
        config.setUsername(System.getenv("PMP_SPRING_MAIL_USERNAME"));
        config.setPassword(System.getenv("PMP_SPRING_MAIL_PASSWORD"));
        config.setPort(587);

        return new SmtpMailProvider(config);
    }
}
