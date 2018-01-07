package app.fetch;

import app.gui.Main;
import app.gui.MainController;
import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.Singleton;
import com.google.inject.binder.AnnotatedBindingBuilder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.FIELD, ElementType.PARAMETER})
//@BindingAnnotation
//@interface RepoUrl {}
@Singleton
public class RepositoryModule extends AbstractModule {

//    private String url;
//
//    public RepositoryModule(String url){
//        this.url=url;
//    }

    @Override
    protected void configure() {

      //  bindConstant().annotatedWith(RepoUrl.class).to(url);
        bind(RepoDownloader.class).to(GitDownloader.class);
//        AnnotatedBindingBuilder<MainController> bind = bind(MainController.class);


    }
}
