package com.jj

import io.gatling.core.Predef._
import org.apache.kafka.clients.producer.ProducerConfig
import scala.concurrent.duration._

import com.github.mnogu.gatling.kafka.Predef._


class ItemSimulation extends Simulation {
  val kafkaProtocol = kafka
    .topic("item")
    .properties(Map(
      ProducerConfig.BOOTSTRAP_SERVERS_CONFIG -> "c6401.ambari.apache.org:6667",
      ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringSerializer",
      ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringSerializer"
    ))

  val scn = scenario("ItemSimulation")
    .feed(tsv("data.tsv", rawSplit = true).circular)
    .exec(kafka("kafkaRequest").send[String]("${data}"))

  setUp(scn.inject(constantUsersPerSec(100) during (10 seconds)))
    .protocols(kafkaProtocol)
}
