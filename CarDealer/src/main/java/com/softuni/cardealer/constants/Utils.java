package com.softuni.cardealer.constants;

import com.google.gson.*;
import org.modelmapper.ModelMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public enum Utils {
    ;
    public static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static final Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (jsonElement, type, jsonSerializationContext) -> new JsonPrimitive(jsonElement.format(DateTimeFormatter.ISO_LOCAL_DATE)))
            .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (jsonElement, type, jsonDeserializationContext) -> LocalDateTime.parse(jsonElement.getAsJsonPrimitive().getAsString()))
            .setPrettyPrinting()
            .create();

    public static void writeJsonIntoFile(List<?> objects, Path filePath) throws IOException {
        final FileWriter fileWriter = new FileWriter(filePath.toFile());

        GSON.toJson(objects, fileWriter);

        fileWriter.flush();
        fileWriter.close();
    }
}
