package com.oshop.email;

import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {
	
	@Autowired
    private JavaMailSender javaMailSender;

	public void sendmail(String name, String email) throws AddressException, MessagingException, IOException {
		 MimeMessage msg = javaMailSender.createMimeMessage();
		 
	        // true = multipart message
	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	        helper.setTo(email);

	        helper.setSubject("Testing from Spring Boot");

	        // default = text/plain
	        //helper.setText("Check attachment for image!");

	        // true = text/html
	        helper.setText(htmlMsg(name, email), true);

//	        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

	        javaMailSender.send(msg);
		}

	private String htmlMsg(String name, String email) {
		String html = "<!DOCTYPE html\r\n" + 
				"    PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"\r\n" + 
				"    style=\"width:100%;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\r\n" + 
				"    <meta name=\"x-apple-disable-message-reformatting\">\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"    <meta content=\"telephone=no\" name=\"format-detection\">\r\n" + 
				"    <title>New email template 2021-02-11</title>\r\n" + 
				"    <!--[if (mso 16)]><style type=\"text/css\">     a {text-decoration: none;}     </style><![endif]-->\r\n" + 
				"    <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]-->\r\n" + 
				"    <!--[if gte mso 9]><xml> <o:OfficeDocumentSettings> <o:AllowPNG></o:AllowPNG> <o:PixelsPerInch>96</o:PixelsPerInch> </o:OfficeDocumentSettings> </xml><![endif]-->\r\n" + 
				"    <!--[if !mso]><!-- -->\r\n" + 
				"    <link href=\"New%20email%20template%202021-02-11_files/css.css\" rel=\"stylesheet\">\r\n" + 
				"    <!--<![endif]-->\r\n" + 
				"    <style type=\"text/css\">\r\n" + 
				"        #outlook a {\r\n" + 
				"            padding: 0;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        .ExternalClass {\r\n" + 
				"            width: 100%;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        .ExternalClass,\r\n" + 
				"        .ExternalClass p,\r\n" + 
				"        .ExternalClass span,\r\n" + 
				"        .ExternalClass font,\r\n" + 
				"        .ExternalClass td,\r\n" + 
				"        .ExternalClass div {\r\n" + 
				"            line-height: 100%;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        .es-button {\r\n" + 
				"            mso-style-priority: 100 !important;\r\n" + 
				"            text-decoration: none !important;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        a[x-apple-data-detectors] {\r\n" + 
				"            color: inherit !important;\r\n" + 
				"            text-decoration: none !important;\r\n" + 
				"            font-size: inherit !important;\r\n" + 
				"            font-family: inherit !important;\r\n" + 
				"            font-weight: inherit !important;\r\n" + 
				"            line-height: inherit !important;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        .es-desk-hidden {\r\n" + 
				"            display: none;\r\n" + 
				"            float: left;\r\n" + 
				"            overflow: hidden;\r\n" + 
				"            width: 0;\r\n" + 
				"            max-height: 0;\r\n" + 
				"            line-height: 0;\r\n" + 
				"            mso-hide: all;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        @media only screen and (max-width:600px) {\r\n" + 
				"\r\n" + 
				"            p,\r\n" + 
				"            ul li,\r\n" + 
				"            ol li,\r\n" + 
				"            a {\r\n" + 
				"                font-size: 16px !important;\r\n" + 
				"                line-height: 150% !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            h1 {\r\n" + 
				"                font-size: 32px !important;\r\n" + 
				"                text-align: center;\r\n" + 
				"                line-height: 120% !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            h2 {\r\n" + 
				"                font-size: 26px !important;\r\n" + 
				"                text-align: center;\r\n" + 
				"                line-height: 120% !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            h3 {\r\n" + 
				"                font-size: 20px !important;\r\n" + 
				"                text-align: center;\r\n" + 
				"                line-height: 120% !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            h1 a {\r\n" + 
				"                font-size: 32px !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            h2 a {\r\n" + 
				"                font-size: 26px !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            h3 a {\r\n" + 
				"                font-size: 20px !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-menu td a {\r\n" + 
				"                font-size: 16px !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-header-body p,\r\n" + 
				"            .es-header-body ul li,\r\n" + 
				"            .es-header-body ol li,\r\n" + 
				"            .es-header-body a {\r\n" + 
				"                font-size: 16px !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-footer-body p,\r\n" + 
				"            .es-footer-body ul li,\r\n" + 
				"            .es-footer-body ol li,\r\n" + 
				"            .es-footer-body a {\r\n" + 
				"                font-size: 16px !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-infoblock p,\r\n" + 
				"            .es-infoblock ul li,\r\n" + 
				"            .es-infoblock ol li,\r\n" + 
				"            .es-infoblock a {\r\n" + 
				"                font-size: 12px !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            *[class=\"gmail-fix\"] {\r\n" + 
				"                display: none !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-m-txt-c,\r\n" + 
				"            .es-m-txt-c h1,\r\n" + 
				"            .es-m-txt-c h2,\r\n" + 
				"            .es-m-txt-c h3 {\r\n" + 
				"                text-align: center !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-m-txt-r,\r\n" + 
				"            .es-m-txt-r h1,\r\n" + 
				"            .es-m-txt-r h2,\r\n" + 
				"            .es-m-txt-r h3 {\r\n" + 
				"                text-align: right !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-m-txt-l,\r\n" + 
				"            .es-m-txt-l h1,\r\n" + 
				"            .es-m-txt-l h2,\r\n" + 
				"            .es-m-txt-l h3 {\r\n" + 
				"                text-align: left !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-m-txt-r img,\r\n" + 
				"            .es-m-txt-c img,\r\n" + 
				"            .es-m-txt-l img {\r\n" + 
				"                display: inline !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-button-border {\r\n" + 
				"                display: inline-block !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-btn-fw {\r\n" + 
				"                border-width: 10px 0px !important;\r\n" + 
				"                text-align: center !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-adaptive table,\r\n" + 
				"            .es-btn-fw,\r\n" + 
				"            .es-btn-fw-brdr,\r\n" + 
				"            .es-left,\r\n" + 
				"            .es-right {\r\n" + 
				"                width: 100% !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-content table,\r\n" + 
				"            .es-header table,\r\n" + 
				"            .es-footer table,\r\n" + 
				"            .es-content,\r\n" + 
				"            .es-footer,\r\n" + 
				"            .es-header {\r\n" + 
				"                width: 100% !important;\r\n" + 
				"                max-width: 600px !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-adapt-td {\r\n" + 
				"                display: block !important;\r\n" + 
				"                width: 100% !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .adapt-img {\r\n" + 
				"                width: 100% !important;\r\n" + 
				"                height: auto !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-m-p0 {\r\n" + 
				"                padding: 0px !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-m-p0r {\r\n" + 
				"                padding-right: 0px !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-m-p0l {\r\n" + 
				"                padding-left: 0px !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-m-p0t {\r\n" + 
				"                padding-top: 0px !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-m-p0b {\r\n" + 
				"                padding-bottom: 0 !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-m-p20b {\r\n" + 
				"                padding-bottom: 20px !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-mobile-hidden,\r\n" + 
				"            .es-hidden {\r\n" + 
				"                display: none !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            tr.es-desk-hidden,\r\n" + 
				"            td.es-desk-hidden,\r\n" + 
				"            table.es-desk-hidden {\r\n" + 
				"                width: auto !important;\r\n" + 
				"                overflow: visible !important;\r\n" + 
				"                float: none !important;\r\n" + 
				"                max-height: inherit !important;\r\n" + 
				"                line-height: inherit !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            tr.es-desk-hidden {\r\n" + 
				"                display: table-row !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            table.es-desk-hidden {\r\n" + 
				"                display: table !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            td.es-desk-menu-hidden {\r\n" + 
				"                display: table-cell !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            .es-menu td {\r\n" + 
				"                width: 1% !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            table.es-table-not-adapt,\r\n" + 
				"            .esd-block-html table {\r\n" + 
				"                width: auto !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            table.es-social {\r\n" + 
				"                display: inline-block !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            table.es-social td {\r\n" + 
				"                display: inline-block !important\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"            a.es-button,\r\n" + 
				"            button.es-button {\r\n" + 
				"                font-size: 16px !important;\r\n" + 
				"                display: inline-block !important;\r\n" + 
				"                border-width: 15px 30px 15px 30px !important\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    </style>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body\r\n" + 
				"    style=\"width:100%;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\"\r\n" + 
				"    data-new-gr-c-s-check-loaded=\"8.869.0\" data-gr-ext-installed=\"\">\r\n" + 
				"    <div class=\"es-wrapper-color\" style=\"background-color:#EEEEEE\">\r\n" + 
				"        <!--[if gte mso 9]><v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\"> <v:fill type=\"tile\" color=\"#eeeeee\"></v:fill> </v:background><![endif]-->\r\n" + 
				"        <table class=\"es-wrapper\"\r\n" + 
				"            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top\"\r\n" + 
				"            width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"            <tbody>\r\n" + 
				"                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                    <td style=\"padding:0;Margin:0\" valign=\"top\">\r\n" + 
				"                        <table class=\"es-content\"\r\n" + 
				"                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"\r\n" + 
				"                            cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
				"                            <tbody>\r\n" + 
				"                                <tr style=\"border-collapse:collapse\"></tr>\r\n" + 
				"                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                    <td style=\"padding:0;Margin:0\" align=\"center\">\r\n" + 
				"                                        <table class=\"es-content-body\"\r\n" + 
				"                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"\r\n" + 
				"                                            cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
				"                                            <tbody>\r\n" + 
				"                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                    <td style=\"Margin:0;padding-left:10px;padding-right:10px;padding-top:15px;padding-bottom:15px\"\r\n" + 
				"                                                        align=\"left\">\r\n" + 
				"                                                        <!--[if mso]><table style=\"width:580px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:282px\" valign=\"top\"><![endif]-->\r\n" + 
				"                                                        <table class=\"es-left\"\r\n" + 
				"                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\"\r\n" + 
				"                                                            cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n" + 
				"                                                            <tbody>\r\n" + 
				"                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                    <td style=\"padding:0;Margin:0;width:282px\"\r\n" + 
				"                                                                        align=\"left\">\r\n" + 
				"                                                                        <table role=\"presentation\"\r\n" + 
				"                                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                                            width=\"100%\" cellspacing=\"0\"\r\n" + 
				"                                                                            cellpadding=\"0\">\r\n" + 
				"                                                                            <tbody>\r\n" + 
				"                                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                    <td class=\"es-infoblock es-m-txt-c\"\r\n" + 
				"                                                                                        style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"\r\n" + 
				"                                                                                        align=\"left\">\r\n" + 
				"                                                                                        <p\r\n" + 
				"                                                                                            style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:14px;color:#CCCCCC\">\r\n" + 
				"                                                                                            Put your preheader text\r\n" + 
				"                                                                                            here<br></p>\r\n" + 
				"                                                                                    </td>\r\n" + 
				"                                                                                </tr>\r\n" + 
				"                                                                            </tbody>\r\n" + 
				"                                                                        </table>\r\n" + 
				"                                                                    </td>\r\n" + 
				"                                                                </tr>\r\n" + 
				"                                                            </tbody>\r\n" + 
				"                                                        </table>\r\n" + 
				"                                                        <!--[if mso]></td><td style=\"width:20px\"></td>\r\n" + 
				"<td style=\"width:278px\" valign=\"top\"><![endif]-->\r\n" + 
				"                                                        <table class=\"es-right\"\r\n" + 
				"                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\"\r\n" + 
				"                                                            cellspacing=\"0\" cellpadding=\"0\" align=\"right\">\r\n" + 
				"                                                            <tbody>\r\n" + 
				"                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                    <td style=\"padding:0;Margin:0;width:278px\"\r\n" + 
				"                                                                        align=\"left\">\r\n" + 
				"                                                                        <table role=\"presentation\"\r\n" + 
				"                                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                                            width=\"100%\" cellspacing=\"0\"\r\n" + 
				"                                                                            cellpadding=\"0\">\r\n" + 
				"                                                                            <tbody>\r\n" + 
				"                                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                    <td class=\"es-infoblock es-m-txt-c\"\r\n" + 
				"                                                                                        style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"\r\n" + 
				"                                                                                        align=\"right\">\r\n" + 
				"                                                                                        <p\r\n" + 
				"                                                                                            style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:14px;color:#CCCCCC\">\r\n" + 
				"                                                                                            <a href=\"https://viewstripo.email/\"\r\n" + 
				"                                                                                                target=\"_blank\"\r\n" + 
				"                                                                                                class=\"view\"\r\n" + 
				"                                                                                                style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#CCCCCC\">View\r\n" + 
				"                                                                                                in browser</a></p>\r\n" + 
				"                                                                                    </td>\r\n" + 
				"                                                                                </tr>\r\n" + 
				"                                                                            </tbody>\r\n" + 
				"                                                                        </table>\r\n" + 
				"                                                                    </td>\r\n" + 
				"                                                                </tr>\r\n" + 
				"                                                            </tbody>\r\n" + 
				"                                                        </table>\r\n" + 
				"                                                        <!--[if mso]></td></tr></table><![endif]-->\r\n" + 
				"                                                    </td>\r\n" + 
				"                                                </tr>\r\n" + 
				"                                            </tbody>\r\n" + 
				"                                        </table>\r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                        <table class=\"es-content\"\r\n" + 
				"                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"\r\n" + 
				"                            cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
				"                            <tbody>\r\n" + 
				"                                <tr style=\"border-collapse:collapse\"></tr>\r\n" + 
				"                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                    <td style=\"padding:0;Margin:0\" align=\"center\">\r\n" + 
				"                                        <table class=\"es-header-body\"\r\n" + 
				"                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#044767;width:600px\"\r\n" + 
				"                                            cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#044767\" align=\"center\">\r\n" + 
				"                                            <tbody>\r\n" + 
				"                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                    <td style=\"Margin:0;padding-top:35px;padding-bottom:35px;padding-left:35px;padding-right:35px\"\r\n" + 
				"                                                        align=\"left\">\r\n" + 
				"                                                        <!--[if mso]><table style=\"width:530px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:340px\" valign=\"top\"><![endif]-->\r\n" + 
				"                                                        <table class=\"es-left\"\r\n" + 
				"                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\"\r\n" + 
				"                                                            cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n" + 
				"                                                            <tbody>\r\n" + 
				"                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                    <td class=\"es-m-p0r es-m-p20b\"\r\n" + 
				"                                                                        style=\"padding:0;Margin:0;width:340px\"\r\n" + 
				"                                                                        valign=\"top\" align=\"center\">\r\n" + 
				"                                                                        <table role=\"presentation\"\r\n" + 
				"                                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                                            width=\"100%\" cellspacing=\"0\"\r\n" + 
				"                                                                            cellpadding=\"0\">\r\n" + 
				"                                                                            <tbody>\r\n" + 
				"                                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                    <td class=\"es-m-txt-c\"\r\n" + 
				"                                                                                        style=\"padding:0;Margin:0\"\r\n" + 
				"                                                                                        align=\"left\">\r\n" + 
				"                                                                                        <h1\r\n" + 
				"                                                                                            style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:36px;font-style:normal;font-weight:bold;color:#FFFFFF\">\r\n" + 
				"                                                                                            OShop</h1>\r\n" + 
				"                                                                                    </td>\r\n" + 
				"                                                                                </tr>\r\n" + 
				"                                                                            </tbody>\r\n" + 
				"                                                                        </table>\r\n" + 
				"                                                                    </td>\r\n" + 
				"                                                                </tr>\r\n" + 
				"                                                            </tbody>\r\n" + 
				"                                                        </table>\r\n" + 
				"                                                        <!--[if mso]></td><td style=\"width:20px\"></td>\r\n" + 
				"<td style=\"width:170px\" valign=\"top\"><![endif]-->\r\n" + 
				"                                                        \r\n" + 
				"                                                        <!--[if mso]></td></tr></table><![endif]-->\r\n" + 
				"                                                    </td>\r\n" + 
				"                                                </tr>\r\n" + 
				"                                            </tbody>\r\n" + 
				"                                        </table>\r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                        <table class=\"es-content\"\r\n" + 
				"                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"\r\n" + 
				"                            cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
				"                            <tbody>\r\n" + 
				"                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                    <td style=\"padding:0;Margin:0\" align=\"center\">\r\n" + 
				"                                        <table class=\"es-content-body\"\r\n" + 
				"                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\"\r\n" + 
				"                                            cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\">\r\n" + 
				"                                            <tbody>\r\n" + 
				"                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                    <td style=\"padding:0;Margin:0;padding-left:35px;padding-right:35px;padding-top:40px\"\r\n" + 
				"                                                        align=\"left\">\r\n" + 
				"                                                        <table\r\n" + 
				"                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                            width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"                                                            <tbody>\r\n" + 
				"                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                    <td style=\"padding:0;Margin:0;width:530px\"\r\n" + 
				"                                                                        valign=\"top\" align=\"center\">\r\n" + 
				"                                                                        <table role=\"presentation\"\r\n" + 
				"                                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                                            width=\"100%\" cellspacing=\"0\"\r\n" + 
				"                                                                            cellpadding=\"0\">\r\n" + 
				"                                                                            <tbody>\r\n" + 
				"                                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                    <td class=\"es-m-txt-l\"\r\n" + 
				"                                                                                        style=\"padding:0;Margin:0;padding-top:15px\"\r\n" + 
				"                                                                                        align=\"left\">\r\n" + 
				"                                                                                        <h3\r\n" + 
				"                                                                                            style=\"Margin:0;line-height:22px;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:18px;font-style:normal;font-weight:bold;color:#333333\">\r\n" + 
				"                                                                                            Hello "
				+ name + ","
				+ "</h3>\r\n" + 
				"                                                                                    </td>\r\n" + 
				"                                                                                </tr>\r\n" + 
				"                                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                    <td style=\"padding:0;Margin:0;padding-bottom:10px;padding-top:15px\"\r\n" + 
				"                                                                                        align=\"left\">\r\n" + 
				"                                                                                        <p\r\n" + 
				"                                                                                            style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:16px;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:24px;color:#777777\">\r\n" + 
				"                                                                                            Welcome\r\n" + 
				"                                                                                            to Organic Shop and thanks\r\n" + 
				"                                                                                            for signing up! You're one\r\n" + 
				"                                                                                            step closer to\r\n" + 
				"                                                                                            purchasing the nutritious\r\n" + 
				"                                                                                            and healthy food that we\r\n" + 
				"                                                                                            have to offer.</p>\r\n" + 
				"                                                                                    </td>\r\n" + 
				"                                                                                </tr>\r\n" + 
				"                                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                    <td style=\"padding:0;Margin:0\"\r\n" + 
				"                                                                                        align=\"left\">\r\n" + 
				"                                                                                        <p\r\n" + 
				"                                                                                            style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:15px;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:23px;color:#333333\">\r\n" + 
				"                                                                                            <strong>Username</strong>:\r\n" + 
				"                                                                                            "
				+ email
				+ "</p>\r\n" + 
				"                                                                                    </td>\r\n" + 
				"                                                                                </tr>\r\n" + 
				"                                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                    <td style=\"padding:0;Margin:0;padding-bottom:15px;padding-top:20px;font-size:0\"\r\n" + 
				"                                                                                        align=\"center\">\r\n" + 
				"                                                                                        <table role=\"presentation\"\r\n" + 
				"                                                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                                                            width=\"100%\" height=\"100%\"\r\n" + 
				"                                                                                            cellspacing=\"0\"\r\n" + 
				"                                                                                            cellpadding=\"0\" border=\"0\">\r\n" + 
				"                                                                                            <tbody>\r\n" + 
				"                                                                                                <tr\r\n" + 
				"                                                                                                    style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                                    <td\r\n" + 
				"                                                                                                        style=\"padding:0;Margin:0;border-bottom:3px solid #EEEEEE;background:#FFFFFF none repeat scroll 0% 0%;height:1px;width:100%;margin:0px\">\r\n" + 
				"                                                                                                    </td>\r\n" + 
				"                                                                                                </tr>\r\n" + 
				"                                                                                            </tbody>\r\n" + 
				"                                                                                        </table>\r\n" + 
				"                                                                                    </td>\r\n" + 
				"                                                                                </tr>\r\n" + 
				"                                                                            </tbody>\r\n" + 
				"                                                                        </table>\r\n" + 
				"                                                                    </td>\r\n" + 
				"                                                                </tr>\r\n" + 
				"                                                            </tbody>\r\n" + 
				"                                                        </table>\r\n" + 
				"                                                    </td>\r\n" + 
				"                                                </tr>\r\n" + 
				"                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                    <td style=\"padding:0;Margin:0\" align=\"left\">\r\n" + 
				"                                                        <table\r\n" + 
				"                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                            width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"                                                            <tbody>\r\n" + 
				"                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                    <td style=\"padding:0;Margin:0;width:600px\"\r\n" + 
				"                                                                        valign=\"top\" align=\"center\">\r\n" + 
				"                                                                        <table role=\"presentation\"\r\n" + 
				"                                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                                            width=\"100%\" cellspacing=\"0\"\r\n" + 
				"                                                                            cellpadding=\"0\">\r\n" + 
				"                                                                            <tbody>\r\n" + 
				"                                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                    <td style=\"padding:0;Margin:0;padding-bottom:15px;padding-top:30px\"\r\n" + 
				"                                                                                        align=\"center\"><span\r\n" + 
				"                                                                                            class=\"es-button-border\"\r\n" + 
				"                                                                                            style=\"border-style:solid;border-color:transparent;background:#EF6220 none repeat scroll 0% 0%;border-width:0px;display:inline-block;border-radius:5px;width:auto\"><a\r\n" + 
				"                                                                                                href=\"https://192.168.2.13:4200/\"\r\n" + 
				"                                                                                                class=\"es-button\"\r\n" + 
				"                                                                                                target=\"_blank\"\r\n" + 
				"                                                                                                style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:18px;color:#FFFFFF;border-style:solid;border-color:#EF6220;border-width:15px 30px;display:inline-block;background:#EF6220 none repeat scroll 0% 0%;border-radius:5px;font-weight:normal;font-style:normal;line-height:22px;width:auto;text-align:center\">Start\r\n" + 
				"                                                                                                shopping</a></span></td>\r\n" + 
				"                                                                                </tr>\r\n" + 
				"                                                                            </tbody>\r\n" + 
				"                                                                        </table>\r\n" + 
				"                                                                    </td>\r\n" + 
				"                                                                </tr>\r\n" + 
				"                                                            </tbody>\r\n" + 
				"                                                        </table>\r\n" + 
				"                                                    </td>\r\n" + 
				"                                                </tr>\r\n" + 
				"                                            </tbody>\r\n" + 
				"                                        </table>\r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                        <table class=\"es-footer\"\r\n" + 
				"                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\"\r\n" + 
				"                            cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
				"                            <tbody>\r\n" + 
				"                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                    <td style=\"padding:0;Margin:0\" align=\"center\">\r\n" + 
				"                                        <table class=\"es-footer-body\"\r\n" + 
				"                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\"\r\n" + 
				"                                            cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
				"                                            <tbody>\r\n" + 
				"                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                    <td style=\"Margin:0;padding-top:35px;padding-left:35px;padding-right:35px;padding-bottom:40px\"\r\n" + 
				"                                                        align=\"left\">\r\n" + 
				"                                                        <table\r\n" + 
				"                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                            width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"                                                            <tbody>\r\n" + 
				"                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                    <td style=\"padding:0;Margin:0;width:530px\"\r\n" + 
				"                                                                        valign=\"top\" align=\"center\">\r\n" + 
				"                                                                        <table role=\"presentation\"\r\n" + 
				"                                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                                            width=\"100%\" cellspacing=\"0\"\r\n" + 
				"                                                                            cellpadding=\"0\">\r\n" + 
				"                                                                            <tbody>\r\n" + 
				"                                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                    <td style=\"padding:0;Margin:0;padding-bottom:15px;font-size:0\"\r\n" + 
				"                                                                                        align=\"center\"><img\r\n" + 
				"                                                                                            src=\"New%20email%20template%202021-02-11_files/12331522050090454.png\"\r\n" + 
				"                                                                                            alt=\"Beretun logo\"\r\n" + 
				"                                                                                            style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"\r\n" + 
				"                                                                                            title=\"Beretun logo\"\r\n" + 
				"                                                                                            width=\"37\" height=\"37\"></td>\r\n" + 
				"                                                                                </tr>\r\n" + 
				"                                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                    <td style=\"padding:0;Margin:0;padding-bottom:35px\"\r\n" + 
				"                                                                                        align=\"center\">\r\n" + 
				"                                                                                        <p\r\n" + 
				"                                                                                            style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#333333\">\r\n" + 
				"                                                                                            <strong>675 Massachusetts\r\n" + 
				"                                                                                                Avenue </strong></p>\r\n" + 
				"                                                                                        <p\r\n" + 
				"                                                                                            style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#333333\">\r\n" + 
				"                                                                                            <strong>Cambridge, MA\r\n" + 
				"                                                                                                02139</strong></p>\r\n" + 
				"                                                                                    </td>\r\n" + 
				"                                                                                </tr>\r\n" + 
				"                                                                            </tbody>\r\n" + 
				"                                                                        </table>\r\n" + 
				"                                                                    </td>\r\n" + 
				"                                                                </tr>\r\n" + 
				"                                                            </tbody>\r\n" + 
				"                                                        </table>\r\n" + 
				"                                                    </td>\r\n" + 
				"                                                </tr>\r\n" + 
				"                                            </tbody>\r\n" + 
				"                                        </table>\r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                        <table class=\"es-content\"\r\n" + 
				"                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"\r\n" + 
				"                            cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
				"                            <tbody>\r\n" + 
				"                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                    <td style=\"padding:0;Margin:0\" align=\"center\">\r\n" + 
				"                                        <table class=\"es-content-body\"\r\n" + 
				"                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\"\r\n" + 
				"                                            cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\">\r\n" + 
				"                                            <tbody>\r\n" + 
				"                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                    <td style=\"padding:0;Margin:0;padding-top:15px;padding-left:35px;padding-right:35px\"\r\n" + 
				"                                                        align=\"left\">\r\n" + 
				"                                                        <table\r\n" + 
				"                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                            width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"                                                            <tbody>\r\n" + 
				"                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                    <td style=\"padding:0;Margin:0;width:530px\"\r\n" + 
				"                                                                        valign=\"top\" align=\"center\">\r\n" + 
				"                                                                        <table role=\"presentation\"\r\n" + 
				"                                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                                            width=\"100%\" cellspacing=\"0\"\r\n" + 
				"                                                                            cellpadding=\"0\">\r\n" + 
				"                                                                            <tbody>\r\n" + 
				"                                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                    <td style=\"padding:0;Margin:0;font-size:0\"\r\n" + 
				"                                                                                        align=\"center\"><img\r\n" + 
				"                                                                                            src=\"New%20email%20template%202021-02-11_files/18501522065897895.png\"\r\n" + 
				"                                                                                            alt=\"\"\r\n" + 
				"                                                                                            style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"\r\n" + 
				"                                                                                            width=\"46\" height=\"22\"></td>\r\n" + 
				"                                                                                </tr>\r\n" + 
				"                                                                            </tbody>\r\n" + 
				"                                                                        </table>\r\n" + 
				"                                                                    </td>\r\n" + 
				"                                                                </tr>\r\n" + 
				"                                                            </tbody>\r\n" + 
				"                                                        </table>\r\n" + 
				"                                                    </td>\r\n" + 
				"                                                </tr>\r\n" + 
				"                                            </tbody>\r\n" + 
				"                                        </table>\r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                        <table class=\"es-content\"\r\n" + 
				"                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"\r\n" + 
				"                            cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
				"                            <tbody>\r\n" + 
				"                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                    <td style=\"padding:0;Margin:0\" align=\"center\">\r\n" + 
				"                                        <table class=\"es-content-body\"\r\n" + 
				"                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#1B9BA3;width:600px;border-bottom:10px solid #48AFB5\"\r\n" + 
				"                                            cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#1b9ba3\" align=\"center\">\r\n" + 
				"                                            <tbody>\r\n" + 
				"                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                    <td style=\"padding:0;Margin:0\" align=\"left\">\r\n" + 
				"                                                        <table\r\n" + 
				"                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                            width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"                                                            <tbody>\r\n" + 
				"                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                    <td style=\"padding:0;Margin:0;width:600px\"\r\n" + 
				"                                                                        valign=\"top\" align=\"center\">\r\n" + 
				"                                                                        <table role=\"presentation\"\r\n" + 
				"                                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                                            width=\"100%\" cellspacing=\"0\"\r\n" + 
				"                                                                            cellpadding=\"0\">\r\n" + 
				"                                                                            <tbody>\r\n" + 
				"                                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                    <td style=\"padding:0;Margin:0\">\r\n" + 
				"                                                                                        <table class=\"es-menu\"\r\n" + 
				"                                                                                            role=\"presentation\"\r\n" + 
				"                                                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                                                            width=\"40%\" cellspacing=\"0\"\r\n" + 
				"                                                                                            cellpadding=\"0\"\r\n" + 
				"                                                                                            align=\"center\">\r\n" + 
				"                                                                                            <tbody>\r\n" + 
				"                                                                                                <tr class=\"links-images-top\"\r\n" + 
				"                                                                                                    style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                                    <td style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:35px;padding-bottom:30px;border:0\"\r\n" + 
				"                                                                                                        id=\"esd-menu-id-0\"\r\n" + 
				"                                                                                                        width=\"25.00%\"\r\n" + 
				"                                                                                                        bgcolor=\"transparent\"\r\n" + 
				"                                                                                                        align=\"center\">\r\n" + 
				"                                                                                                        <a target=\"_blank\"\r\n" + 
				"                                                                                                            style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:20px;text-decoration:none;display:block;color:#FFFFFF\"\r\n" + 
				"                                                                                                            href=\"\"><img\r\n" + 
				"                                                                                                                src=\"New%20email%20template%202021-02-11_files/60961522067175378.png\"\r\n" + 
				"                                                                                                                alt=\"\"\r\n" + 
				"                                                                                                                title=\"\"\r\n" + 
				"                                                                                                                style=\"display:inline-block !important;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;padding-bottom:5px\"\r\n" + 
				"                                                                                                                width=\"33\"\r\n" + 
				"                                                                                                                height=\"27\"\r\n" + 
				"                                                                                                                align=\"absmiddle\"><br></a>\r\n" + 
				"                                                                                                    </td>\r\n" + 
				"                                                                                                    <td style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:35px;padding-bottom:30px;border:0\"\r\n" + 
				"                                                                                                        id=\"esd-menu-id-1\"\r\n" + 
				"                                                                                                        esdev-border-color=\"#000000\"\r\n" + 
				"                                                                                                        width=\"25.00%\"\r\n" + 
				"                                                                                                        bgcolor=\"transparent\"\r\n" + 
				"                                                                                                        align=\"center\">\r\n" + 
				"                                                                                                        <a target=\"_blank\"\r\n" + 
				"                                                                                                            style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:20px;text-decoration:none;display:block;color:#FFFFFF\"\r\n" + 
				"                                                                                                            href=\"\"><img\r\n" + 
				"                                                                                                                src=\"New%20email%20template%202021-02-11_files/72681522067183042.png\"\r\n" + 
				"                                                                                                                alt=\"\"\r\n" + 
				"                                                                                                                title=\"\"\r\n" + 
				"                                                                                                                style=\"display:inline-block !important;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;padding-bottom:5px\"\r\n" + 
				"                                                                                                                width=\"33\"\r\n" + 
				"                                                                                                                height=\"27\"\r\n" + 
				"                                                                                                                align=\"absmiddle\"><br></a>\r\n" + 
				"                                                                                                    </td>\r\n" + 
				"                                                                                                    <td style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:35px;padding-bottom:30px;border:0\"\r\n" + 
				"                                                                                                        id=\"esd-menu-id-2\"\r\n" + 
				"                                                                                                        esdev-border-color=\"#000000\"\r\n" + 
				"                                                                                                        width=\"25.00%\"\r\n" + 
				"                                                                                                        bgcolor=\"transparent\"\r\n" + 
				"                                                                                                        align=\"center\">\r\n" + 
				"                                                                                                        <a target=\"_blank\"\r\n" + 
				"                                                                                                            style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:20px;text-decoration:none;display:block;color:#FFFFFF\"\r\n" + 
				"                                                                                                            href=\"\"><img\r\n" + 
				"                                                                                                                src=\"New%20email%20template%202021-02-11_files/76121522068412489.jpg\"\r\n" + 
				"                                                                                                                alt=\"\"\r\n" + 
				"                                                                                                                title=\"\"\r\n" + 
				"                                                                                                                style=\"display:inline-block !important;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;padding-bottom:5px\"\r\n" + 
				"                                                                                                                width=\"33\"\r\n" + 
				"                                                                                                                height=\"27\"\r\n" + 
				"                                                                                                                align=\"absmiddle\"><br></a>\r\n" + 
				"                                                                                                    </td>\r\n" + 
				"                                                                                                    <td style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:35px;padding-bottom:30px;border:0\"\r\n" + 
				"                                                                                                        id=\"esd-menu-id-3\"\r\n" + 
				"                                                                                                        esdev-border-color=\"#000000\"\r\n" + 
				"                                                                                                        width=\"25.00%\"\r\n" + 
				"                                                                                                        bgcolor=\"transparent\"\r\n" + 
				"                                                                                                        align=\"center\">\r\n" + 
				"                                                                                                        <a target=\"_blank\"\r\n" + 
				"                                                                                                            style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:20px;text-decoration:none;display:block;color:#FFFFFF\"\r\n" + 
				"                                                                                                            href=\"\"><img\r\n" + 
				"                                                                                                                src=\"New%20email%20template%202021-02-11_files/12411522072775563.jpg\"\r\n" + 
				"                                                                                                                alt=\"\"\r\n" + 
				"                                                                                                                title=\"\"\r\n" + 
				"                                                                                                                style=\"display:inline-block !important;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;padding-bottom:5px\"\r\n" + 
				"                                                                                                                width=\"50\"\r\n" + 
				"                                                                                                                height=\"27\"\r\n" + 
				"                                                                                                                align=\"absmiddle\"><br></a>\r\n" + 
				"                                                                                                    </td>\r\n" + 
				"                                                                                                </tr>\r\n" + 
				"                                                                                            </tbody>\r\n" + 
				"                                                                                        </table>\r\n" + 
				"                                                                                    </td>\r\n" + 
				"                                                                                </tr>\r\n" + 
				"                                                                            </tbody>\r\n" + 
				"                                                                        </table>\r\n" + 
				"                                                                    </td>\r\n" + 
				"                                                                </tr>\r\n" + 
				"                                                            </tbody>\r\n" + 
				"                                                        </table>\r\n" + 
				"                                                    </td>\r\n" + 
				"                                                </tr>\r\n" + 
				"                                            </tbody>\r\n" + 
				"                                        </table>\r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                        <table class=\"es-content\"\r\n" + 
				"                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"\r\n" + 
				"                            cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
				"                            <tbody>\r\n" + 
				"                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                    <td style=\"padding:0;Margin:0\" align=\"center\">\r\n" + 
				"                                        <table class=\"es-content-body\"\r\n" + 
				"                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"\r\n" + 
				"                                            cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
				"                                            <tbody>\r\n" + 
				"                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                    <td style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px\"\r\n" + 
				"                                                        align=\"left\">\r\n" + 
				"                                                        <table\r\n" + 
				"                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                            width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"                                                            <tbody>\r\n" + 
				"                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                    <td style=\"padding:0;Margin:0;width:560px\"\r\n" + 
				"                                                                        valign=\"top\" align=\"center\">\r\n" + 
				"                                                                        <table\r\n" + 
				"                                                                            style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"\r\n" + 
				"                                                                            width=\"100%\" cellspacing=\"0\"\r\n" + 
				"                                                                            cellpadding=\"0\">\r\n" + 
				"                                                                            <tbody>\r\n" + 
				"                                                                                <tr style=\"border-collapse:collapse\">\r\n" + 
				"                                                                                    <td style=\"padding:0;Margin:0;display:none\"\r\n" + 
				"                                                                                        align=\"center\"></td>\r\n" + 
				"                                                                                </tr>\r\n" + 
				"                                                                            </tbody>\r\n" + 
				"                                                                        </table>\r\n" + 
				"                                                                    </td>\r\n" + 
				"                                                                </tr>\r\n" + 
				"                                                            </tbody>\r\n" + 
				"                                                        </table>\r\n" + 
				"                                                    </td>\r\n" + 
				"                                                </tr>\r\n" + 
				"                                            </tbody>\r\n" + 
				"                                        </table>\r\n" + 
				"                                    </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                            </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                    </td>\r\n" + 
				"                </tr>\r\n" + 
				"            </tbody>\r\n" + 
				"        </table>\r\n" + 
				"    </div>\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>";
				
				return html;
	}
}
