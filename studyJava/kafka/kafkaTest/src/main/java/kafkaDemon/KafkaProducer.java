package kafkademon;

import java.util.Properties;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.javaapi.producer.Producer;

public class KafkaProducer extends Thread {
	private final Producer<Integer, String> producer;
	private final String topic;
	private final Properties props = new Properties();
	
	public KafkaProducer(String topic) {
		props.put("serializer.class", "kafka.serializer.StringEncoder");	//配置value的序列化
		props.put("metadata.broker.list", "10.77.96.122:9092");
		producer = new Producer<Integer, String>(new ProducerConfig(props));
		this.topic = topic;
	}
	
	@Override
	public void run() {
		int messageNo = 1;
		while(true) {
			String messageStr = new String("Message_" + messageNo);
			System.out.println("Send: " + messageStr);
			producer.send(new KeyedMessage<Integer, String>(topic, messageStr));
			messageNo++;
			
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
