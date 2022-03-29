package com.ultralesson.training.mobile.data.mappers;

import com.google.gson.Gson;
import com.ultralesson.training.mobile.data.DataMapper;
import com.ultralesson.training.mobile.utils.PathFinder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class DesiredCapabilitiesMapper implements DataMapper {

    @Override
    public DesiredCapabilities map(String filename) {
        Gson gson = new Gson();
        try {
            Map<String, Object> jsonMap = gson.fromJson(new FileReader(PathFinder.findAbsPathFromRelativePath("capabilities", filename)), Map.class);
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            jsonMap.forEach(desiredCapabilities::setCapability);
            return desiredCapabilities;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cannot map desired capabilities");
        }
    }
}
