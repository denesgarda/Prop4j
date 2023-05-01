package com.denesgarda.Prop4j;

import com.denesgarda.Prop4j.lang.KeyValueMismatchException;
import com.denesgarda.Prop4j.lang.OperationFailedException;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Objects;

public class Properties {
    private String path;

    public Properties(String path) {
        this.path = path;
    }

    public Properties setPath(String path) {
        this.path = path;
        return this;
    }

    public static Properties returnObject(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            return new Properties(path);
        } else {
            boolean successful = file.createNewFile();
            if (successful) {
                return new Properties(path);
            } else {
                throw new OperationFailedException("Failed to create properties file.");
            }
        }
    }

    public String getPath() {
        return this.path;
    }

    public boolean exists() {
        File file = new File(this.path);
        return file.exists();
    }

    public String getProperty(String key) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        String result = properties.getProperty(key);
        fileInputStream.close();
        return result;
    }

    public String getDefault(String key, String defaultValue) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.getPath());
        properties.load(fileInputStream);
        String result = properties.getProperty(key);
        fileInputStream.close();
        if (result == null) {
            this.setProperty(key, defaultValue);
            return defaultValue;
        }
        return result;
    }

    public Properties setProperty(String key, String value) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        properties.setProperty(key, value);
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, "");
        fileInputStream.close();
        fileOutputStream.close();
        return this;
    }

    public Properties setProperty(String key, String value, String comment) throws IOException {
        java.util.Properties properties = new java.util.Properties();
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
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        for (int i = 0; i < keys.length; i++) {
            result[i] = properties.getProperty(keys[i]);
        }
        fileInputStream.close();
        return result;
    }

    public Properties setProperties(@NotNull String[] keys, @NotNull String[] values) throws IOException {
        if (keys.length != values.length) {
            throw new KeyValueMismatchException("The number of keys does not match the number of values");
        }
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        for (int i = 0; i < keys.length; i++) {
            properties.put(keys[i], values[i]);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, "");
        fileInputStream.close();
        fileOutputStream.close();
        return this;
    }

    public Properties setProperties(@NotNull String[] keys, @NotNull String[] values, String comment) throws IOException {
        if (keys.length != values.length) {
            throw new KeyValueMismatchException("The number of keys does not match the number of values");
        }
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        for (int i = 0; i < keys.length; i++) {
            properties.put(keys[i], values[i]);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, comment);
        fileInputStream.close();
        fileOutputStream.close();
        return this;
    }

    public Properties removeProperty(String key) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        properties.remove(key);
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, "");
        fileInputStream.close();
        fileOutputStream.close();
        return this;
    }

    public Properties removeProperty(String key, String comment) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        properties.remove(key);
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, comment);
        fileInputStream.close();
        fileOutputStream.close();
        return this;
    }

    public Properties removeProperties(String[] keys) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        for (String key : keys) {
            properties.remove(key);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, "");
        fileInputStream.close();
        fileOutputStream.close();
        return this;
    }

    public Properties removeProperties(String[] keys, String comment) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        for (String key : keys) {
            properties.remove(key);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, comment);
        fileInputStream.close();
        fileOutputStream.close();
        return this;
    }

    public Properties clear() throws IOException {
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        properties.clear();
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, "");
        fileInputStream.close();
        fileOutputStream.close();
        return this;
    }

    public boolean contains(String value) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        boolean result = properties.contains(value);
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, "");
        fileInputStream.close();
        fileOutputStream.close();
        return result;
    }

    public boolean containsValue(String value) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        boolean result = properties.containsValue(value);
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, "");
        fileInputStream.close();
        fileOutputStream.close();
        return result;
    }

    public boolean containsKey(String key) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        FileInputStream fileInputStream = new FileInputStream(this.path);
        properties.load(fileInputStream);
        boolean result = properties.containsKey(key);
        FileOutputStream fileOutputStream = new FileOutputStream(this.path);
        properties.store(fileOutputStream, "");
        fileInputStream.close();
        fileOutputStream.close();
        return result;
    }

    public File getAsFile() {
        return new File(this.path);
    }

    public boolean delete() {
        return new File(this.path).delete();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Properties that = (Properties) o;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }
}
