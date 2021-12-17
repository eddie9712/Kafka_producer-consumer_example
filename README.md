# Kafka_producer-consumer_example
A repository for kafka producer/consumer  implementation
# Prerequisite
The items below should be installed:
```
docker
maven
Java
```
# Quick Start:
* **Step 1:** Get the docker file to build your kafka cluster quickly:  
leverage the repository [astraea](https://github.com/skiptests/astraea) to build the kafka cluster:
1. `git clone https://github.com/skiptests/astraea.git`
2. `cd astraea`
3. `./docker/start_zookeeper.sh`  
**(In the script you can't use the addresses 127.0.0.1 or 127.0.1.1 for the zookeeper's ip address)**  
After that you can get a command to start the broker:  
e.g. `./docker/start_broker.sh zookeeper.connect=192.168.50.178:19227`
