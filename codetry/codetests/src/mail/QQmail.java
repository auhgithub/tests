package mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class QQmail {

    /**
     * 使用QQ邮箱IMAP/SMTP的实现发送电子邮件
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            send();
        }
    }

    private static void send() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.smtp.port", "587");//使用465或587端口
        props.put("mail.smtp.auth", "true");//设置使用验证
        props.put("mail.smtp.starttls.enable", "true");//使用 STARTTLS安全连接
        try {
            PopupAuthenticator auth = new PopupAuthenticator();
            Session session = Session.getInstance(props, auth);
            session.setDebug(true);//打印Debug信息
            MimeMessage message = new MimeMessage(session);
            Address addressFrom = new InternetAddress(PopupAuthenticator.mailuser + "@qq.com", "");//第一个参数为发送方电子邮箱地址；第二个参数为发送方邮箱地址的标签
            Address addressTo = new InternetAddress("1214646998@qq.com", "");//第一个参数为接收方电子邮箱地址；第二个参数为接收方邮箱地址的标签
            message.setSubject("来自机器人");
            message.setText("http://www.cnblogs.com/AndroidJotting/p/5024124.html");
            message.setFrom(addressFrom);
            message.addRecipient(Message.RecipientType.TO, addressTo);
            message.saveChanges();
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.qq.com", PopupAuthenticator.mailuser, PopupAuthenticator.password);
            transport.send(message);
            transport.close();
            System.out.println("发送成功");
        }
        catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("发送失败");
        }
    }
}

class PopupAuthenticator extends Authenticator {
    public static final String mailuser = "1205431157";//发送方邮箱'@'符号前的内容:1453296946@qq.com

    public static final String password = "errndnnvjbwzgdce";//成功开启IMAP/SMTP服务，在第三方客户端登录时，腾讯提供的密码。注意不是邮箱密码

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(mailuser, password);
    }
}
