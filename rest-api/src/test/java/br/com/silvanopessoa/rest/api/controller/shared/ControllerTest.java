package br.com.silvanopessoa.rest.api.controller.shared;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.reflections.util.ClasspathHelper.forPackage;
import static org.reflections.util.FilterBuilder.prefix;

import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

public class ControllerTest {
	
	@Ignore
    @Test
    public void deve_anottation_rest_controller() throws Exception {
        Set<Class<?>> controllers = this.getClassesController();
        assertFalse(CollectionUtils.isEmpty(controllers));
        for (Class<?> controller : controllers) {
            if(!controller.getName().contains("Test")){
                assertTrue("A classe " + controller.getName() + " não possui a anotação RestController.", controller.isAnnotationPresent(RestController.class));
            }
        }
    }

    private Set<Class<?>> getClassesController() throws Exception {
        Reflections reflections = new Reflections(new ConfigurationBuilder().addUrls(forPackage("br.com.silvanopessoa.rest.api.controller"))
                .filterInputsBy(new FilterBuilder().exclude(prefix("br.com.silvanopessoa.rest.api.controller.shared")))
                .filterInputsBy(new FilterBuilder().include(prefix("br.com.silvanopessoa.rest.api.controller")))
                .setScanners(new SubTypesScanner(false), new ResourcesScanner()));
        return reflections.getSubTypesOf(Object.class);
    }

}
