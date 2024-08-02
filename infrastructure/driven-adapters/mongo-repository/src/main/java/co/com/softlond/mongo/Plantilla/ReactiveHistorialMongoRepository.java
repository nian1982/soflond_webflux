package co.com.softlond.mongo.Plantilla;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import co.com.softlond.model.HistorialModel;

public interface ReactiveHistorialMongoRepository extends ReactiveMongoRepository<HistorialModel, String> {

}
