package org.ghxiao.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerDemo {

    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class
                //        "org.apache.kafka.common.serialization.StringSerializer"
        );
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class
                //        "org.apache.kafka.common.serialization.StringSerializer"
        );
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        String k = "mykey1";
        String v = "myvalue";
        ProducerRecord<String, String> record =
                new ProducerRecord<String, String>("my-topic", k, v); // (1) producer.send(record);

        for (int value = 0 ; value < 10; value++){

            producer.send(new ProducerRecord<>("my-topic", "key", String.valueOf(value)), (recordMetadata, e) -> {
                if (e != null) {
                    e.printStackTrace();
                } else {
                    System.out.println("Message String = " + record.value() + ", Offset = "
                            + recordMetadata.offset());
                }
            });

            Thread.sleep(1000);
        }


        //producer.send(record);

        producer.close();

    }

}
