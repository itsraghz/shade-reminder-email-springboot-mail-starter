package com.example.emailapp.config;

import com.example.emailapp.util.StringUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@Data
public class EmailConfig {

    /*private static EmailConfig _emailConfig = null;

    public static EmailConfig getInstance() {
        if(null==_emailConfig) {
            _emailConfig = new EmailConfig();
        }

        return _emailConfig;
    }*/

    @Value("${smtp.password}")
    public String smtpPassword;

    @Value("${mail.smtp.auth}")
    private String mailSmtpAuth;

    @Value("${mail.smtp.starttls.enable}")
    private String mailSmtpStartTlsEnable;

    @Value("${mail.smtp.host}")
    private String mailSmtpHost;

    @Value("${mail.smtp.port}")
    private String mailSmtpPort;

    public String getPassword() throws Exception {
        String password = null;

        //1. Check for the Env property
        if(StringUtil.isValid(smtpPassword)) {
            System.out.println("Env variable smtpPassword is set :: [" + smtpPassword + "]");
            return smtpPassword;
        }

        password = StringUtil.isValid(smtpPassword) ? smtpPassword :  "";

        //2. check for the System Property
        password = System.getProperty("GmailPassword");
        System.out.println("Gmail Password :: " + password);

        String gmailPasswordEnv = System.getenv("GmailPassword");
        System.out.println("gmailPasswordEnv Password :: " + gmailPasswordEnv);

        if(null==password || password.trim().length()<=0) {
            password = gmailPasswordEnv;
        }

        if(null==password || password.trim().length()<=0) {
            throw new RuntimeException("Invalid Password. Kindly check and specify a valid password on the Env Property to Java Executable");
        }

        return password;
    }

    public Properties getSMTPProperties() {
        System.out.println(" >>>>> getSMTPProperties() - ENTER");
        Properties props = new Properties();
        props.put("mail.smtp.auth", mailSmtpAuth);
        props.put("mail.smtp.starttls.enable", mailSmtpStartTlsEnable);
        props.put("mail.smtp.host", mailSmtpHost);
        props.put("mail.smtp.port", mailSmtpAuth);

        System.out.println("Properties :: " + props);
        System.out.println(" <<<< getSMTPProperties() - EXIT");
        return props;
    }
}
