package com.reactive.playground.sec08.client;

public class ClientError extends RuntimeException{

    public ClientError() {
        super("bad request");
    }
}
