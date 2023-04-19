package web.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Метод, указывающий на класс конфигурации
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // Указание конфигурационного класса
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                SpringConfig.class
        };
    }

    // Данный метод указывает url, на котором будет базироваться приложение
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // Метод запускается при старте приложения
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);

        // Решение проблемы с вводом кириллицы в формах
        aServletContext.setRequestCharacterEncoding("UTF-8");
    }

    // Метод добавляет фильтр для hidden поля _method в HTTP POST-запросах
    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }

}