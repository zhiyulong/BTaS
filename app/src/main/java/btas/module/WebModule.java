package btas.module;

import org.apache.catalina.servlets.DefaultServlet;

import com.google.inject.name.Names;
import com.google.inject.servlet.ServletModule;

public class WebModule extends ServletModule {
    @Override
    protected void configureServlets() {
      serve("/*").with(DefaultServlet.class);
      bindConstant().annotatedWith(Names.named("webapp.basedir")).to("../btas-react/build/");
    }
  }
