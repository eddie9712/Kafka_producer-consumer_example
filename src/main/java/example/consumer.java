package example;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.Arrays;
import java.util.Properties;

public class consumer {
    public static void main(String[] args) throws InterruptedException{
        if (!args[1].equals("--brokers")) 
		throw new IllegalArgumentException("Wrong argument" + args[1]);
	String brokers = args[2];
	if (!args[3].equals("--topic"))
             throw new IllegalArgumentException("Wrong argument" + args[3]);
	String topic_name = args[4];
	System.out.printf("brokers :%s, topic:%s", brokers, topic_name);
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
	props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group");
        KafkaConsumer consumer = new KafkaConsumer(props);
        consumer.subscribe(Arrays.asList(topic_name));
	while (true){
	  ConsumerRecords<String,String> records = consumer.poll(10);
	  if(records.count() == 0)
	  {
	  }else{
		  for(ConsumerRecord<String,String> record: records){
			  System.out.printf("Received %s: %s\n", record.key(), record.value());}
	  }
	}
    }
}
