package com.lexsoft.fizionova.service;

import com.lexsoft.fizionova.repository.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendEmail(Employee employee) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setTo(employee.getEmail());
        messageHelper.setFrom("ambulancefizionova@gmail.com");
        messageHelper.setSubject("Dobrodošli na Fizionova");
        MimeMultipart multipart = new MimeMultipart("related");
        BodyPart messageBodyPart = new MimeBodyPart();
        BASE64Decoder decoder=new BASE64Decoder();
        String htmlText = "PCEtLSBJbmxpbmVyIEJ1aWxkIFZlcnNpb24gNDM4MGI3NzQxYmI3NTlkNmNiOTk3NTQ1ZjNhZGQyMWFkNDhmMDEwYiAtLT4NCjwhRE9DVFlQRSBodG1sIFBVQkxJQyAiLS8vVzNDLy9EVEQgSFRNTCA0LjAgVHJhbnNpdGlvbmFsLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL1RSL1JFQy1odG1sNDAvbG9vc2UuZHRkIj4NCjxodG1sPjxoZWFkPg0KPHdyYXBwZXIgY2xhc3M9ImhlYWRlciI+PGNvbnRhaW5lcj48cm93IGNsYXNzPSJjb2xsYXBzZSI+PGNvbHVtbnMgc21hbGw9IjYiPjxpbWcgc3JjPSIvaW1hZ2VzL3Jzel9maXppb19ub3ZhXy5qcGVnIj48L2NvbHVtbnM+PGNvbHVtbnMgc21hbGw9IjYiPjxwIGNsYXNzPSJ0ZXh0LXJpZ2h0IiBzdHlsZT0iY29sb3I6ICNmZmY7IHBhZGRpbmctdG9wOiAxNXB4OyI+QkFTSUM8L3A+DQogICAgICA8L2NvbHVtbnM+PC9yb3c+PC9jb250YWluZXI+PC93cmFwcGVyPjxjb250YWluZXI+PHNwYWNlciBzaXplPSIxNiI+PC9zcGFjZXI+PHJvdz48Y29sdW1ucyBzbWFsbD0iMTIiPjxwPiA8c3Ryb25nPlBvJnNjYXJvbjt0b3ZhbmkvYTwvc3Ryb25nPjxicj48L3A+DQoNCiAgICAgIDxwIGNsYXNzPSJsZWFkIj48L3A+DQogICAgICA8Y2FsbG91dCBjbGFzcz0icHJpbWFyeSI+PHA+IFVzcGUmc2Nhcm9uO25vIHN0ZSBzZSByZWdpc3Ryb3ZhbGksIG1vcmF0ZSBzYSYjMjY5O2VrYXRpIGRhIFZhbSBhZG1pbmlzdHJhdG9yIG9kb2JyaSBwcnN0dXAuIA0KICAgICAgICAgIFUgZGFsamVtIHJhZHUgbW8mIzM4MjtldGUga29yaXN0aXRpIHN2b2plIHBvZGF0a2UgKGtvcmlzbmkmIzI2OTtrbyBpbWUgaSBsb3ppbmt1KSBrYWtvIGJpc3RlIHByaXN0dXBpbGkgbmFwcmVkbmltIG9wY2lqYW1hLjwvcD4NCiAgICAgIDwvY2FsbG91dD48L2NvbHVtbnM+PC9yb3c+PHdyYXBwZXIgY2xhc3M9InNlY29uZGFyeSI+PHNwYWNlciBzaXplPSIxNiI+PC9zcGFjZXI+PHJvdz48Y29sdW1ucyBsYXJnZT0iNiI+PGg1PktvbnRha3QgOjwvaDU+DQogICAgICAgIDxwPlRlbGVmb246IDQwOC0zNDEtMDYwMDwvcD4NCiAgICAgICAgPHA+RW1haWw6IDxhIGhyZWY9ImFtYnVsYW5jZWZpemlvbm92YUBnbWFpbC5jb20mZ3Q7YW1idWxhbmNlZml6aW9ub3ZhQGdtYWlsLmNvbSZsdDsvYSZndDsmbHQ7L3AmZ3Q7JTBBJTIwJTIwJTIwJTIwJTIwJTIwJmx0Oy9jb2x1bW5zJmd0OyUwQSUyMCUyMCUyMCUyMCZsdDsvcm93Jmd0OyUwQSUyMCUyMCZsdDsvd3JhcHBlciZndDslMEEmbHQ7L2NvbnRhaW5lciZndDsiPjwvYT48L3A+PC9jb2x1bW5zPjwvcm93Pjwvd3JhcHBlcj48L2NvbnRhaW5lcj4NCjwvaGVhZD48L2h0bWw+DQo=";
        messageBodyPart.setContent(htmlText, "text/plain; charset=UTF-8");
        multipart.addBodyPart(messageBodyPart);
        messageBodyPart = new MimeBodyPart();
        DataSource file = new FileDataSource("src/main/resources/images/rsz_fizio_nova_.jpeg");

        messageBodyPart.setDataHandler(new DataHandler(file));
        messageBodyPart.setHeader("Content-ID", "<image>");
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);


        //          .replace("{{PAYMENT_METHOD}}","CASH ON DELIVERY")
        //        .replace("{{EMAIL}}","rahul.parmar@datamoulds.com");

        //messageHelper.addInline("fizionova.jpg", file);

        javaMailSender.send(message);
    }

}
