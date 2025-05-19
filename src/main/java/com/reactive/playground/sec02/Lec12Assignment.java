package com.reactive.playground.sec02;

import com.reactive.playground.common.Util;
import com.reactive.playground.sec02.assignment.FileService;
import com.reactive.playground.sec02.assignment.FileServiceImpl;
import com.reactive.playground.sec02.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec12Assignment {
    private static final Logger log = LoggerFactory.getLogger(Lec12Assignment.class);

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        fileService.write("file.txt", "This is a test file")
                .subscribe(Util.subscriber());
        fileService.read("file.txt").subscribe(Util.subscriber());

        fileService.delete("file.txt").subscribe(Util.subscriber());
    }

}
