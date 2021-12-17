# Kafka_producer-consumer_example
A repository for kafka producer/consumer implementation
# Prerequisite
The items below should be installed:
```
docker
maven
Java
```
# Quick Start:
* **Step 1:** Get the docker files to build your kafka cluster quickly:  
leverage the repository [astraea](https://github.com/skiptests/astraea) to build the kafka cluster:
1. `git clone https://github.com/skiptests/astraea.git`
2. `cd astraea`
3. `.sudo /docker/start_zookeeper.sh  //start zookeeper`  
**(In the script you can't use the addresses 127.0.0.1 or 127.0.1.1 for the zookeeper's ip address)**  
After that you can get a command to start the broker:  
e.g. `sudo ./docker/start_broker.sh zookeeper.connect=192.168.50.178:19227 //start the broker`  
Create a topic:  
e.g. `sudo ./docker/start_kafka_tool.sh kafka-topics.sh --create --partitions 1 --replication-factor 1 --topic test --bootstrap-server 192.168.50.178:19227 //create topic "test"`  
Verify the created topic:  
`sudo ./docker/start_kafka_tool.sh kafka-topics.sh --bootstrap-server 192.168.50.178:19227 --list`  
* **Step 2:** Build the Producer/Consumer:
Clone this repository:  
1. `git clone  https://github.com/eddie9712/Kafka_producer-consumer_example.git`  
Build it with maven:  
2. `mvn clean compile package`  
3. Launch the consumer/producer:  
Consumer:  
e.g. `java -jar ./target/1-1.0-SNAPSHOT-jar-with-dependencies.jar consumer --brokers 192.168.50.178:19227 --topic test`  
Producer:  
e.g. `java -jar ./target/1-1.0-SNAPSHOT-jar-with-dependencies.jar producer --brokers 192.168.50.178.19227 --topic test --records 1000 --recordSize 1000`  
  * **Parameters:**
    ```
    --brokers: list of brokers
    --topic: topic name of the topic we had created
    --records: number of records we send
    --recordSize: size of each record
    ```
