package com.robintegg.flock.j2html.engine.test.templates;

import com.robintegg.flock.j2html.engine.Template;
import com.robintegg.flock.j2html.engine.TemplateModel;
import j2html.TagCreator;
import j2html.tags.Renderable;

public class HomePage implements Template {

    @Override
    public Renderable render(TemplateModel model) {

        return TagCreator.html(
                TagCreator.body(
                        "Hello, " + (String)model.getVariable("name") + "!"
                )
        );

    }

}
