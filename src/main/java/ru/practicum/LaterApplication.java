package ru.practicum;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class LaterApplication {
    private static final int PORT = 8080;

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.getConnector().setPort(PORT);

        // то самое "приложение" или "контекст" с пустым путём
        Context tomcatContext = tomcat.addContext("", null);

        // создаём контекст
        AnnotationConfigWebApplicationContext applicationContext =
                new AnnotationConfigWebApplicationContext();
        applicationContext.setServletContext(tomcatContext.getServletContext()); //задаёт ServletContext
        applicationContext.scan("ru.practicum"); //контекст будет искать бины в пакете ru.practicum
        applicationContext.refresh(); //загружает Spring-контекст


        // добавляем диспетчер запросов
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext); //В конструктор DispatcherServlet передаётся applicationContext

        // класс Wrapper позволяет задать дополнительные настройки для сервлета
        Wrapper dispatcherWrapper =
                Tomcat.addServlet(tomcatContext, "dispatcher", dispatcherServlet);

        // addMapping() сопоставляет URL-путь с сервлетом
        dispatcherWrapper.addMapping("/"); //сервлет будет обрабатывать все пути, начиная с корневого
        dispatcherWrapper.setLoadOnStartup(1); //сервлет будет инициализирован при запуске контейнера, а не при первом запросе

        tomcat.start();
    }
}