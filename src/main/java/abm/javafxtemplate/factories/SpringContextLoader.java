package abm.javafxtemplate.factories;

import abm.javafxtemplate.config.AppProperties;
import abm.javafxtemplate.config.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class SpringContextLoader {

    private static AnnotationConfigApplicationContext context = null;

    public static AnnotationConfigApplicationContext getInstance() {
        context = Optional.ofNullable(context).orElse(getContext());
        return context;
    }

    private static AnnotationConfigApplicationContext getContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AppProperties.class);
        applicationContext.register(ApplicationConfig.class);
        applicationContext.refresh();
        return applicationContext;
    }


}
