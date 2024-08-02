package co.com.softlond.mongo.Plantilla;

import org.springframework.stereotype.Component;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.gateways.HistorialGateway;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// @Service
@Component
public class HistorialGatewayImpl implements HistorialGateway {

    private final ReactiveHistorialMongoRepository historialMongoRepository;

    public HistorialGatewayImpl(ReactiveHistorialMongoRepository historialMongoRepository){
        this.historialMongoRepository = historialMongoRepository;
    }

    @Override
    public Mono<HistorialModel> create(HistorialModel historialModel) {
        return historialMongoRepository.save(historialModel);
    }

    @Override
    public Mono<HistorialModel> getById(String id) {
        return historialMongoRepository.findById(id);
    }

    @Override
    public Flux<HistorialModel> getAll() {
        return historialMongoRepository.findAll();
    }

    @Override
    public Mono<Void> delete(String id) {
        return historialMongoRepository.deleteById(id);
    }

}
