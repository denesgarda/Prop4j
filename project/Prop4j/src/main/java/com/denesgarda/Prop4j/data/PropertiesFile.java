package com.denesgarda.Prop4j.data;

import com.denesgarda.Prop4j.lang.KeyValueMatchException;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class PropertiesFile {
    private String path;

    public PropertiesFile(String path) {
        this.path = path;
    }

    public PropertiesFile setPath(String path) {
        this.path = path;
        return this;
    }
    public String getPath() {
        return this.path;
    }

    public boolean exists() {
        File file = new File(this.path);
        return file.exists();
    }

    public String getProperty(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        String result = properties.getProperty(key);
        fileInputStream.close();
        return result;
    }

    public PropertiesFile setProperty(String key, String value) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        properties.setProperty(key, value);
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, "");
        fileInputStream.close();
        fileOutputStream.close();
        return this;
    }
    public PropertiesFile setProperty(String key, String value, String comment) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        properties.setProperty(key, value);
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, comment);
        fileInputStream.close();
        fileOutputStream.close();
        return this;
    }

    public String[] getProperties(String[] keys) throws IOException {
        String[] result = new String[keys.length];
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        for(int i = 0; i < keys.length; i++) {
            result[i] = properties.getProperty(keys[i]);
        }
        fileInputStream.close();
        return result;
    }

    public PropertiesFile setProperties(@NotNull String[] keys, @NotNull String[] values) throws IOException {
        if(keys.length != values.length) {
            throw new KeyValueMatchException("The number of keys does not match the number of values");
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        for(int i = 0; i < keys.length; i++) {
            properties.put(keys[i], values[i]);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, "");
        fileInputStream.close();
        fileOutputStream.close();
        return this;
    }
    public PropertiesFile setProperties(@NotNull String[] keys, @NotNull String[] values, String comment) throws IOException {
        if(keys.length != values.length) {
            throw new KeyValueMatchException("The number of keys does not match the number of values");
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        for(int i = 0; i < keys.length; i++) {
            properties.put(keys[i], values[i]);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, comment);
        fileInputStream.close();
        fileOutputStream.close();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertiesFile that = (PropertiesFile) o;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }
}
