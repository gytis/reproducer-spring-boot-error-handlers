package com.example.springbootempty;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
public class DummyController {

    @GetMapping(path = "json", produces = APPLICATION_JSON_VALUE)
    public Error jsonError() {
        throw new RuntimeException("json");
    }

    @GetMapping(path = "xml", produces = APPLICATION_XML_VALUE)
    public Error xmlError() {
        throw new RuntimeException("xml");
    }
}
