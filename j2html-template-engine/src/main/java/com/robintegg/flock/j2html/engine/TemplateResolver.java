package com.robintegg.flock.j2html.engine;

import java.util.function.Function;

public interface TemplateResolver {

    String getName();

    Integer getOrder();

    // Function<> resolveTemplate(String template);

}
