package lesson02;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by imafan on 2016-05-10.
 *
 * ÏûÏ¢Ó¦´ð£¨message acknowledgments£©
 */
public class NewTask02 {

    private final static String QUEUE_NAME = "workqueue";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
    }
}
