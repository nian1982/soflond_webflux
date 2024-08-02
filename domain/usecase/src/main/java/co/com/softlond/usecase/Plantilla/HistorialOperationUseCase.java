package co.com.softlond.usecase.Plantilla;


import org.springframework.stereotype.Service;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.gateways.HistorialGateway;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HistorialOperationUseCase {

     private final HistorialGateway historialGateway;

    public HistorialOperationUseCase(HistorialGateway historialGateway) {
        this.historialGateway = historialGateway;
    }

    public Mono<HistorialModel> savePlantilla(HistorialModel historialModel) {
        /* lOGICA DE NEGOCIO */
        return historialGateway.create(historialModel);
    }

    public Flux<HistorialModel> getAll(){
        return historialGateway.getAll();
    }
}
