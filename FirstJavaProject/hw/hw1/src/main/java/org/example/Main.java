package org.example;

import org.example.transport.Monitor;

public class Main {
    public static void main(String[] args) {


        Computer computer = new Computer("Samsung", new Monitor("MacBook"));
        computer.start();
        computer.stop();



    }
}