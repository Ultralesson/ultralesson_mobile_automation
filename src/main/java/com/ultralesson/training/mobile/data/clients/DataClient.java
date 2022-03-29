package com.ultralesson.training.mobile.data.clients;

import com.ultralesson.training.mobile.data.DataMapper;
import com.ultralesson.training.mobile.data.mappers.JSONDataMapper;

import java.util.Objects;

public abstract class DataClient {

    protected DataMapper dataMapper;
    public DataClient() {
        dataMapper = new JSONDataMapper();
    }

    protected String getFilePath(String relativePath) {
        return Objects.requireNonNull(this.getClass()
                        .getClassLoader()
                        .getResource(String.format("data_sets/%s",relativePath)))
                .getPath();
    }

}
