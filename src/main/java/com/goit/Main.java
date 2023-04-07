package com.goit;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CurrencyDto;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        try(InputStream stream = Main.class.getClassLoader().getResourceAsStream("data.json"))
        {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();
            CurrencyDto dto = gson.fromJson(new String(stream.readAllBytes()), CurrencyDto.class);
            System.out.println(dto);
            System.out.println("-------------------------------");

            String toJson=gson.toJson(dto);
            System.out.println(toJson);
        }

    }
}
