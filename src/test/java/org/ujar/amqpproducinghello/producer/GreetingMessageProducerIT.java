package org.ujar.amqpproducinghello.producer;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import java.util.concurrent.TimeUnit;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.ujar.amqpproducinghello.consumer.GreetingMessageConsumer;
import org.ujar.amqpproducinghello.model.Greeting;

@SpringBootTest
class GreetingMessageProducerIT {

  private final GreetingMessageProducer producer;
  private final GreetingMessageConsumer consumer;

  @Autowired
  public GreetingMessageProducerIT(GreetingMessageProducer producer, GreetingMessageConsumer consumer) {
    this.producer = producer;
    this.consumer = consumer;
  }

  @Test
  void shouldConsumeMessage() throws InterruptedException {
    final var greeting = new Greeting("Hello, World!");
    producer.send(greeting);

    boolean messageConsumed = consumer.getLatch().await(10, TimeUnit.SECONDS);
    assertThat(messageConsumed).isTrue();
    MatcherAssert.assertThat(consumer.getPayload(), containsString(greeting.toString()));
    consumer.resetLatch();
  }
}
