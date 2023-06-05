package com.robintegg.flock.j2html.engine;

import j2html.Config;
import j2html.rendering.IndentedHtml;
import j2html.tags.Renderable;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;

@Slf4j
public class TemplateEngine {

    public String process(String templateName, TemplateModel model) {
        StringWriter writer = new StringWriter();
        process(templateName, model, writer);
        return writer.toString();
    }

    public void process(String templateName, TemplateModel model, Writer writer) {

        try {
            // must have template, context, writer

            // prepare context?


            // resolve template

            // build data model

            // call the thing to apply the function

            Template template = resolveTemplate(templateName);

            // use template to flush
            Renderable renderable = template.render(model);

            renderable.render(IndentedHtml.into(writer, Config.defaults()));

            try {
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException("Error occured during flush");
            }

        } catch (IOException e) {
            log.error("{}", e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            log.error("{}", e.getMessage(), e);
            throw e;
        }

    }

    private Template resolveTemplate(String templateName) {
        try {
            return (Template) Class.forName(templateName).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
