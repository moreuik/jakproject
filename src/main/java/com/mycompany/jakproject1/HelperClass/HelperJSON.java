/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jakproject1.HelperClass;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 *
 * @author apexb
 */
public class HelperJSON {
    public static Gson getSerializer() {
        GsonBuilder builder = new GsonBuilder()
            .setLenient()
            .setPrettyPrinting()
            .serializeNulls()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.create();
    }
}
