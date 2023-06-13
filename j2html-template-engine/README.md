# J2Html Template Engine

```xml
<dependency>
    <group>com.robintegg.flock</group>
    <artefact>j2html-template-engine</artefact>
</dependency>
```

```java
import com.robintegg.flock.j2html.*;

var templateResolver = new StandardClasspathTemplateResolver();

var engine = new StandardTemplateEngine();
engine.addTemplateResolver(templateResolver);

var model = new TemplateModel();
model.addVariable("name", "robin");

var output = engine.process( "Helloworld", TemplateModel model);
```