package com.robintegg.flock.j2html.engine;

import com.robintegg.flock.j2html.engine.test.templates.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TemplateEngineTest {

    @Test
    void shouldRenderOutputFromTemplateWithFullPathReference() {

        TemplateEngine engine = new TemplateEngine();

        TemplateModel model = new TemplateModel();
        model.setVariable("name","Robin");

        String renderedTemplate = engine.process(HomePage.class.getName(), model);

        Assertions.assertEquals( """
                <html>
                    <body>
                        Hello, Robin!
                    </body>
                </html>
                """, renderedTemplate);

    }

    @Test
    void shouldRenderOutputFromTemplateWithBasePackage() {

        TemplateEngine engine = new TemplateEngine();
        engine.setBasePackage(HomePage.class.getPackageName());

        TemplateModel model = new TemplateModel();
        model.setVariable("name","Robin");

        String renderedTemplate = engine.process(HomePage.class.getSimpleName(), model);

        Assertions.assertEquals( """
                <html>
                    <body>
                        Hello, Robin!
                    </body>
                </html>
                """, renderedTemplate);

    }

}
