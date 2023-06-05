package com.robintegg.flock.j2html.engine;

import java.util.HashMap;
import java.util.Map;

public class TemplateModel {
    private final Map<String, Object> variables = new HashMap<>();

    public void setVariable(String name, Object value) {
        this.variables.put(name, value);
    }

    public Object getVariable(String name) {
        return this.variables.get(name);
    }
}
