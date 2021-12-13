package io.github.bharatmane.hexagonalthis.console;

import io.github.bharatmane.hexagonalthis.domain.port.RequestUser;

public class UserResource {

    private final RequestUser requestUser;

    public UserResource(RequestUser requestUser) {
        this.requestUser = requestUser;
    }

//    @GetMapping
//    public ResponseEntity<ExampleInfo> getExamples() {
//        return ResponseEntity.ok(requestExample.getExamples());
//    }
//
//    @GetMapping("/{code}")
//    public ResponseEntity<Example> getExampleByCode(@PathVariable Long code) {
//        return ResponseEntity.ok(requestExample.getExampleByCode(code));
//    }
}