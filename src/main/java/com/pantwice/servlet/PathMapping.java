package com.pantwice.servlet;

import java.util.HashMap;

public class PathMapping {

    private HashMap<String, String> classMap = new HashMap<>();

    public void addMapping(String path, String className) {
        classMap.put(path, className);
    }

    public String fetchMapping(String path) {
        return classMap.get(path);
    }

    public void clear() {
        classMap.clear();
    }

}
