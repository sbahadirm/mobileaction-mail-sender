package com.mobileaction.mailsender.mailsender.rabbit;

import com.mobileaction.mailsender.mailsender.mail.MailSendRequestDto;
import com.mobileaction.mailsender.mailsender.mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Component
@RequiredArgsConstructor
public class RabbitMQConsumer {

    private final MailService mailService;

    @RabbitListener(queues = "${mobileaction.rabbitmq.mail.queue}")
    public void sendMail(MailSendRequestDto mailSendRequestDto){

        System.out.println("MAIL SEND: " + mailSendRequestDto);
        mailService.sendMail(mailSendRequestDto);
    }
}
