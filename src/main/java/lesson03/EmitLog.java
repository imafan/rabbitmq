package lesson03;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by imafan on 2016-05-11.
 */
public class EmitLog {

    private final static String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception{

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare();


        channel.close();
        connection.close();
    }
}
