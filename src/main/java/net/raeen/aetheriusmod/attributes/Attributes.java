package net.raeen.aetheriusmod.attributes;

import java.util.HashMap;
import java.util.Map;

public class Attributes {
    private Map<String, Integer> attributes;

    public Attributes() {
        attributes = new HashMap<>();
    }

    public void setAttribute(String key, int value) {
        attributes.put(key, value);
    }

    public int getAttribute(String key) {
        return attributes.getOrDefault(key, 0);
    }

    public Map<String, Integer> getAllAttributes() {
        return attributes;
    }
}
