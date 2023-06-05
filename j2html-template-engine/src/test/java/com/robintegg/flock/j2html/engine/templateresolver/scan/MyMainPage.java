package com.robintegg.flock.j2html.engine.templateresolver.scan;

import j2html.TagCreator;
import j2html.tags.DomContent;

public class MyMainPage {

    public DomContent main() {

        return TagCreator.html(
                TagCreator.body(
                        "hello world"
                )
        );

    }

}
