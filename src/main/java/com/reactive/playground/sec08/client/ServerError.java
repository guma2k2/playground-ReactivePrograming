package com.reactive.playground.sec08.client;

public class ServerError extends RuntimeException{

    public ServerError() {
        super("server error");
    }
}
