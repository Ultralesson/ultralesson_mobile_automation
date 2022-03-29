package com.ultralesson.training.mobile.data.mappers;

import com.google.gson.Gson;
import com.testvagrant.ekam.devicemanager.models.DeviceFilters;
import com.ultralesson.training.mobile.data.DataMapper;
import com.ultralesson.training.mobile.utils.PathFinder;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DeviceFiltersMapper implements DataMapper {

    public DeviceFilters map(String fileName) {
        Gson gson = new Gson();
        try {
           return gson.fromJson(new FileReader(PathFinder.findAbsPathFromRelativePath("filters", fileName)),
                   DeviceFilters.class);
        } catch (FileNotFoundException e) {
            return new DeviceFilters();
        }
    }
}
