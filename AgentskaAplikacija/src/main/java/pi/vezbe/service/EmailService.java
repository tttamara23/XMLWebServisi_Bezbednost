package pi.vezbe.service;

import pi.vezbe.model.Korisnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;


    private String password;
    /*
     * Koriscenje klase za ocitavanje vrednosti iz application.properties fajla
     */
    @Autowired
    private Environment env;

    private SimpleMailMessage mail = new SimpleMailMessage();
    /*
     * Anotacija za oznacavanje asinhronog zadatka
     * Vise informacija na: https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#scheduling
     */
    @Async
    public void sendNotificaitionAsync(Korisnik user) throws MailException, InterruptedException {

        //Simulacija duze aktivnosti da bi se uocila razlika
        Thread.sleep(10000);
        System.out.println("Slanje emaila...");


        javaMailSender.send(mail);

        System.out.println("Email poslat!");


    }

    public void sendNotificaitionSync(Korisnik user) throws MailException, InterruptedException {

        //Simulacija duze aktivnosti da bi se uocila razlika
        Thread.sleep(10000);
        System.out.println("Slanje emaila...");


        javaMailSender.send(mail);

        System.out.println("Email poslat!");
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SimpleMailMessage getMail() {
        return mail;
    }

    public void setMail(SimpleMailMessage mail) {
        this.mail = mail;
    }

    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }
}