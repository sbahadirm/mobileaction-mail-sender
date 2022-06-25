package com.mobileaction.mailsender.mailsender.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mail-sender")
public class MailController {

    private final MailService mailService;

    @PostMapping
    public boolean sendMail(@RequestBody MailSendRequestDto mailSendRequestDto){

        return mailService.sendMail(mailSendRequestDto);
    }
}
