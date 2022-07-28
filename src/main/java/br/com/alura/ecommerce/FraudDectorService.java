package br.com.alura.ecommerce;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class FraudDectorService {

    public static void main(String[] args) throws InterruptedException {
        var fraudService = new FraudDectorService();
        var service = new KafkaService("ECOMMERCE_SEND_EMAIL", "ECOMMERCE_NEW_ORDER", fraudService::parse);

        service.run();
    }

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("-----------------------------");
        System.out.println("Processing new order. checkinf for fraud");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order processed");


    }


}
