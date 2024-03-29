package com.ultralesson.training.mobile.data.mappers;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.ultralesson.training.mobile.data.DataMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Objects;

public class JSONDataMapper implements DataMapper {

    @Override
    public <T> T map(String file, String key, Class<T> tClass) {
        Gson gson = new Gson();
        try {
            Map<String, LinkedTreeMap> jsonMap = gson.fromJson(new FileReader(file), Map.class);
            LinkedTreeMap jsonElement = jsonMap.get(key);
            if(Objects.isNull(jsonElement)) throw new FileNotFoundException();
            return gson.fromJson(jsonElement.toString(), tClass);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(String.format("Failed to find a data for key %s in file %s or filepath %s itself is wrong", key, file, file));
        }

    }

    @Override
    public <T> T map(String filename, Class<T> tClass) {
        throw new UnsupportedOperationException();
    }
}
