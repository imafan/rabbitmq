package lesson02;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by imafan on 2016-05-10.
 *
 * Message durability消息持久化
 */
public class NewTask_durability {

    private final static String QUEUE_NAME = "workqueue_durability";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 声明队列
        boolean durable = true;// 1、设置队列持久化
        channel.queueDeclare(QUEUE_NAME,durable,false,false,null);

        for(int i = 0; i <= 10; i++){
            String dots = "";
            for (int j = 0; j <= i; j++)
            {
                dots += ".";
            }
            String message = "helloworld" + dots+dots.length();
            // MessageProperties 2、设置消息持久化
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        //关闭频道和资源
        channel.close();
        connection.close();
    }
}
