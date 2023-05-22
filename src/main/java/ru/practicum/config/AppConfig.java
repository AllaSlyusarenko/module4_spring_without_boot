package ru.practicum.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // помечает класс как java-config для контекста приложения
@PropertySource("classpath:application.properties") //Spring, из каких файлов *.properties нужно брать настройки
//classpath: — он говорит, что файл нужно искать в самом приложении

//@PropertySource(value = "file:C:\\myapp\\myapp.properties", ignoreResourceNotFound = true) // пример для Windows
public class AppConfig {
}