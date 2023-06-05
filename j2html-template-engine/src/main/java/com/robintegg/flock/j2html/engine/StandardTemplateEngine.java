package com.robintegg.flock.j2html.engine;

import com.robintegg.flock.j2html.engine.templateresolver.StandardClasspathTemplateResolver;
import j2html.Config;
import j2html.rendering.IndentedHtml;
import j2html.tags.Renderable;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class StandardTemplateEngine implements TemplateEngine {

    private final List<TemplateResolver> templateResolvers = new ArrayList<TemplateResolver>();

    public StandardTemplateEngine() {
        setTemplateResolver(new StandardClasspathTemplateResolver());
    }

    public void setTemplateResolvers(final List<TemplateResolver> templateResolvers) {
        this.templateResolvers.clear();
        for (final TemplateResolver templateResolver : templateResolvers) {
            addTemplateResolver(templateResolver);
        }
        Collections.sort(templateResolvers, Comparator.comparing(TemplateResolver::getOrder));
    }

    public void addTemplateResolver(final TemplateResolver templateResolver) {
        this.templateResolvers.add(templateResolver);
        Collections.sort(templateResolvers, Comparator.comparing(TemplateResolver::getOrder));
    }

    public void setTemplateResolver(final TemplateResolver templateResolver) {
        this.templateResolvers.clear();
        this.templateResolvers.add(templateResolver);
        Collections.sort(templateResolvers, Comparator.comparing(TemplateResolver::getOrder));
    }

    public String process(String templateName, TemplateModel model) {
        // TODO: fast string writer impl?
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

            // use template to flush
            Renderable renderable = null; // wrapper over a function or constructor

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

}
