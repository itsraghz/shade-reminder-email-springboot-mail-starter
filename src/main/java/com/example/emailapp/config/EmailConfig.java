package com.example.emailapp.config;

import com.example.emailapp.util.StringUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Configuration
@Data
//@PropertySource(value="classpath:application.properties", name="app.props")
public class EmailConfig {

    /*@Autowired
    Environment env;*/

    @Value("${smtp.code}")
    public String smtpPassword;

    @Value("${mail.smtp.auth}")
    private String mailSmtpAuth;

    @Value("${mail.smtp.starttls.enable}")
    private String mailSmtpStartTlsEnable;

    @Value("${mail.smtp.host}")
    private String mailSmtpHost;

    @Value("${mail.smtp.port}")
    private String mailSmtpPort;

    @Value("${smtp.user}")
    private String smtpUser;

    @Value("${mail.from}")
    private String mailFrom;

    @Value("${mail.to}")
    private String mailTo;

    @Value("${mail.cc}")
    private String mailCc;

    @Value("${mail.subject}")
    private String mailSubject;

    @Value("${mail.body}")
    private String mailBody;

    @Value("${mail.contentType}")
    private String mailContentType;


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

    public Session getMailSession() throws Exception {
        Properties props = getSMTPProperties();

        final String user = getSmtpUser();
        final String password = getPassword();

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        return session;
    }

    public void printAllEnvVars() {
        System.out.println(" >>>>> printAllEnvVars() - ENTER");
        System.getenv().forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        System.out.println("-----------------------");

        /*AbstractEnvironment ae = (AbstractEnvironment) env;
        org.springframework.core.env.PropertySource source =
                ae.getPropertySources().get("app.props");
        Properties props = (Properties)source.getSource();

        for(Object key : props.keySet()){
            System.out.println(props.get(key));
        }
        System.out.println("-----------------------");*/

        System.out.println(" <<<<< printAllEnvVars() - EXIT");
    }

     {
        printAllEnvVars();
    }
}
