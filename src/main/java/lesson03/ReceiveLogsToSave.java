package lesson03;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by imafan on 2016-05-13.
 * 发布/订阅（Publish/Subscribe）
 */
public class ReceiveLogsToSave {
    private final static String EXCHANGE_NAME = "ex_log";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection conncetion = factory.newConnection();
        Channel channel = conncetion.createChannel();
        // 创建一个非持久的、唯一的且自动删除的队列
        String queueName = channel.queueDeclare().getQueue();
        // 为转发器指定队列，设置binding
        channel.queueBind(queueName,EXCHANGE_NAME,"");

        channel.close();
        conncetion.close();
    }
}
