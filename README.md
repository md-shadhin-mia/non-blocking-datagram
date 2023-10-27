
# Non-blocking Datagram Producer and Consumer

This repository contains two Java programs for non-blocking Datagram communication, one for the producer (sender) and the other for the consumer (receiver). These programs demonstrate how to send and receive messages using DatagramChannel and non-blocking I/O.

## Contents
1. [Requirements](#requirements)
2. [Usage](#usage)
    - [NonBlockingDatagramProducer](#nonblockingdatagramproducer)
    - [NonBlockingDatagramConsumer](#nonblockingdatagramconsumer)
3. [License](#license)

## Requirements

- Java Development Kit (JDK) 8 or higher

## Usage

### NonBlockingDatagramProducer

The `NonBlockingDatagramProducer` program is a sender that sends messages to a remote host.

#### Running the Producer

1. Open a terminal.
2. Compile the `NonBlockingDatagramProducer` program:

    ```sh
    javac NonBlockingDatagramProducer.java
    ```

3. Run the producer program:

    ```sh
    java NonBlockingDatagramProducer
    ```

The producer will continuously send messages to the specified remote host (default: "localhost" on port 8080). You can modify the message content and destination address in the code as needed.

### NonBlockingDatagramConsumer

The `NonBlockingDatagramConsumer` program is a receiver that listens for incoming messages and processes them.

#### Running the Consumer

1. Open another terminal.
2. Compile the `NonBlockingDatagramConsumer` program:

    ```sh
    javac NonBlockingDatagramConsumer.java
    ```

3. Run the consumer program:

    ```sh
    java NonBlockingDatagramConsumer
    ```

The consumer will listen for incoming messages on port 8080. It uses non-blocking I/O to receive and process messages from the producer.

## License

This code is provided under the MIT License. See the [LICENSE](LICENSE) file for details.  
