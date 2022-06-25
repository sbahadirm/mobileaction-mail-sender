package com.mobileaction.mailsender.mailsender.mail;

import lombok.Data;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Data
public class MailSendRequestDto {

    private String emailAddress;
    private String subject;
    private String body;
}
