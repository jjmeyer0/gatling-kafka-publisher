This project can be used to work send data to a Kafka topic. It is
used in to test and the following project:

https://github.com/jjmeyer0/spark-streaming-example

## To Run Simulation

```bash
mvn gatling:execute
```

## Creating Topic

This project by default sends messages to the item topic. The following command will create this topic. 
This assumes you have followed this link to setup a cluster (https://cwiki.apache.org/confluence/display/AMBARI/Quick+Start+Guide).
```bash
$ /usr/hdp/current/kafka-broker/bin/kafka-topics.sh --create --zookeeper c6401.ambari.apache.org:2181 --replication-factor 1 --partitions 1 --topic item
```

All dummy data was generated using: https://www.mockaroo.com/

Please See:
1. http://gatling.io/#/
2. https://github.com/mnogu/gatling-kafka