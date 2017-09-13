package me.anna.demo;


import com.google.common.collect.Lists;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;

@Controller
public class MainController {


    @Autowired
    public EmailService emailService;


    public void sendEmailWithoutTemplate() {

        final Email email;
        try {
            email = DefaultEmail.builder()
                    // DOES NOT MATTER what you put in .from address.. it ignores it and uses what is in properties file
                    // this may work depending on the email server config that is being used
                    // the from NAME does get used though
                    .from(new InternetAddress("myemail@me.com", "My Personal Email Address"))
                    .to(Lists.newArrayList(
                            new InternetAddress("anyone@anywhere.net", "Send to Somebody that does not exists"),
                            new InternetAddress("titus@de-rerum.natura", "Send to Somebody2 that does not exists"),
                            new InternetAddress("one-thousand@emails.com", "Can send as many emails as I want")))
                    .subject("Sending it from inside the Java web app:)")
                    .body("I am testing out Spring's Java email service, and would like to see how it works:)")
                    .encoding("UTF-8").build();

            // conveniently, .send will put a nice INFO message in the console output when it sends
            emailService.send(email);

        } catch (UnsupportedEncodingException e) {
            System.out.println("caught an unsupported encoding exception");
            e.printStackTrace();
        }

    }

}