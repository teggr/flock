package com.robintegg.flock.j2html.engine;

import j2html.tags.Renderable;

public interface Template {

    Renderable render(TemplateModel model);

}
