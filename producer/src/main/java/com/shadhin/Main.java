package com.shadhin;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Main {
    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        InetSocketAddress serverAddress = new InetSocketAddress("localhost", 8080);

        String message = "Hello, Datagram!";

        int i = 0;
        while (true) {
            ByteBuffer buffer = ByteBuffer.wrap((i+"."+message).getBytes());
            channel.send(buffer, serverAddress);
            System.out.println("Sent: " + (i+"."+message));
            i++;

            // Sleep for a while to simulate production
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}