package com.ultralesson.training.mobile.models;

import com.github.javafaker.Faker;

public abstract class Model {
    protected Faker faker;
    public Model() {
        faker = new Faker();
    }
}
