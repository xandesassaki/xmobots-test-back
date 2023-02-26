package org.xmobots.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.xmobots.DTO.AerodromesList;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

public class JsonUtils {
    public static AerodromesList readJsonFileForAerodromes (String filename) throws IOException {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filename)){
            Type aerodromesType = new TypeToken<AerodromesList>(){}.getType();
            return gson.fromJson(reader, aerodromesType);
        }
    }
}
