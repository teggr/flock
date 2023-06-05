package com.robintegg.flock.j2html.engine;

import java.io.Writer;

public interface TemplateEngine {

    String process(String templateName, TemplateModel model);

    void process(String templateName, TemplateModel model, Writer writer);

}
