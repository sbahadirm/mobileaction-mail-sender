package com.mobileaction.mailsender.mailsender.kafka.consumer;

import com.mobileaction.mailsender.mailsender.mail.MailSendRequestDto;
import com.mobileaction.mailsender.mailsender.mail.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaListenerService {

    private final MailService mailService;

    @KafkaListener(
            topics = "${interprobe.kafka.topic}",
            groupId = "${interprobe.kafka.group-id}"
    )
    public void listen(@Payload MailSendRequestDto mailSendRequestDto){

        mailService.sendMail(mailSendRequestDto);

        log.info("Message received by consumer... " + mailSendRequestDto);

    }

}
