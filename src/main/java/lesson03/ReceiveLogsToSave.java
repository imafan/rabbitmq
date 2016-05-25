package lesson03;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by imafan on 2016-05-13.
 * ����/���ģ�Publish/Subscribe��
 */
public class ReceiveLogsToSave {
    private final static String EXCHANGE_NAME = "ex_log";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection conncetion = factory.newConnection();
        Channel channel = conncetion.createChannel();
        // ����һ���ǳ־õġ�Ψһ�����Զ�ɾ���Ķ���
        String queueName = channel.queueDeclare().getQueue();
        // Ϊת����ָ�����У�����binding
        channel.queueBind(queueName,EXCHANGE_NAME,"");

        channel.close();
        conncetion.close();
    }
}
