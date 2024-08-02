package co.com.softlond.api.Plantilla;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HIstorialRoutesRest {

    @Bean
    public RouterFunction<ServerResponse> historialRoutes(HistorialHandler historialHandler) {
        return route(POST("/api/historial/save"), historialHandler::saveHistorial);
        // return route(POST("/api/plantilla/save"), historialHandler::savePlantilla);
    }
}
