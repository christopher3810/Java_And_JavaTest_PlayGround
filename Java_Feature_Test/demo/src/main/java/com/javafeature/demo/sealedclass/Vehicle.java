package com.javafeature.demo.sealedclass;

public sealed class Vehicle permits Sedan, SUV {
    // common methods for all Vehicle subclasses
}