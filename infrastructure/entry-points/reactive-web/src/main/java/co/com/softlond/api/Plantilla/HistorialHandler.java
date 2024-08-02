package co.com.softlond.api.Plantilla;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.usecase.Plantilla.HistorialOperationUseCase;
import reactor.core.publisher.Mono;

@Service
public class HistorialHandler {

    private final HistorialOperationUseCase historialOperationUseCase;

    public HistorialHandler(HistorialOperationUseCase historialOperationUseCase){
        this.historialOperationUseCase = historialOperationUseCase;
    }

    public Mono<ServerResponse> saveHistorial(ServerRequest request) {
        return request.bodyToMono(HistorialModel.class)
                .flatMap(historialOperationUseCase::savePlantilla)
                .flatMap(historial -> ServerResponse.ok().bodyValue(historial))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }


}
