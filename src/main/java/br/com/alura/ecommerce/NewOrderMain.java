package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;


public class NewOrderMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var dispatcher = new KafkaDispatcher();
        for (var i = 0; i < 100; i++) {
            var key = UUID.randomUUID().toString();
            var value = key + ",13321154121,1313132,1313232232";
            dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);
            var email = "Thank you for order! We are processing your order";
            dispatcher.send("ECOMMERCE_NEW_EMAIL", key, email);

        }
    }


}
