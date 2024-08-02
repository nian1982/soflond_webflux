package co.com.softlond.model.gateways;

import co.com.softlond.model.HistorialModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HistorialGateway {
    Mono<HistorialModel> create(HistorialModel historialModel);
    Mono<HistorialModel> getById(String id);
    Flux<HistorialModel> getAll();
    Mono<Void> delete(String id);
}
