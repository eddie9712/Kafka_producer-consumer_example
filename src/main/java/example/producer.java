package example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.*;

public class producer {
    public static void main(String[] args) throws InterruptedException{
	if (!args[1].equals("--brokers"))                                      //parser
	    throw new IllegalArgumentException("Wrong argument: " + args[1]);
	int k = 2;                                                             //index of the arguments
	String brokers = args[k];
	if (!args[k+1].equals("--topic"))
		throw new IllegalArgumentException("Wrong argument: " + args[k+1]);
	k++;
	String topic_name = args[k+1];
	k += 2;
	if (!args[k].equals("--records"))
            throw new IllegalArgumentException("Wrong argument" + args[k]);
	int record_numbers = Integer.parseInt(args[k+1]);
        k += 2;
        if (!args[k].equals("--recordSize"))
	    throw new IllegalArgumentException("Wrong argument" + args[k]);
	int recordsize = Integer.parseInt(args[k+1]);
	Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String,String> producer = new KafkaProducer<String,String>(props);
	for (int j=0; j< record_numbers; ++j)  //produce record_numbers of records
	{
             String key = "key-"+Integer.toString(j);
	     String value = "value-"+Integer.toString(j);
	     for(int i=0; i< recordsize; ++i)
	         value += '\0';
	     ProducerRecord<String,String> my_record;
	     my_record = new ProducerRecord<String,String>(topic_name,0,key, value);
	     producer.send(my_record);
             Thread.sleep(1L);
	}
        producer.close();
    }
}
