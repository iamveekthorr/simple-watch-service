package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        WatchServiceDemo watchServiceDemo = new WatchServiceDemo();

        watchServiceDemo.registerWatchService();
        watchServiceDemo.monitor();
    }
}
