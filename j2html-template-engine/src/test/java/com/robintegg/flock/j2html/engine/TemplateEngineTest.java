package com.robintegg.flock.j2html.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TemplateEngineTest {

    @Test
    void shouldOutputSomeRenderedHtml() {

        TemplateEngine engine = new TemplateEngine();

        TemplateModel model = new TemplateModel();
        model.setVariable("name","Robin");

        String renderedTemplate = engine.process("com.robintegg.flock.j2html.engine.test.templates.HomePage", model);

        Assertions.assertEquals( """
                <html>
                    <body>
                        Hello, Robin!
                    </body>
                </html>
                """, renderedTemplate);

    }

}
