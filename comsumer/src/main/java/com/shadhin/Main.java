package com.shadhin;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(8080));
        channel.configureBlocking(false);

        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("Consumer is running...");
        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                if (key.isReadable()) {
                    DatagramChannel datagramChannel = (DatagramChannel) key.channel();
                    InetSocketAddress senderAddress = (InetSocketAddress) datagramChannel.receive(buffer);
                    buffer.flip();
                    String message = new String(buffer.array(), 0, buffer.limit());
                    buffer.clear();

                    System.out.println("Received from " + senderAddress + ": " + message);

                    // Process the received message as needed
                }

                keyIterator.remove();
            }
        }
    }
}