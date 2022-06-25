package com.mobileaction.mailsender.mailsender.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mail-sender")
public class MailController {

    private final MailService mailService;

    @Value("${spring.mail.username}")
    private String mailUsername;

    @PostMapping
    public boolean sendMail(@RequestBody MailSendRequestDto mailSendRequestDto){
        return mailService.sendMail(mailSendRequestDto);
    }

    @GetMapping("/mail-address")
    public String getMailAddress(){

        return mailUsername + "@gmail.com";
    }

    @GetMapping("/mail-send-request-dto")
    public MailSendRequestDto getMailSendRequestDto(){
        return MailSendRequestDto.builder()
                .emailAddress("sbahadirm@gmail.com")
                .subject("Rest Template Test")
                .body("Body")
                .build();
    }
}
