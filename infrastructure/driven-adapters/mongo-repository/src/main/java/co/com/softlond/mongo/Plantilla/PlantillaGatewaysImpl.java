package co.com.softlond.mongo.Plantilla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gateways.PlantillaGateways;
import reactor.core.publisher.Mono;

// @Repository
@Service
public class PlantillaGatewaysImpl implements PlantillaGateways {    

    @Autowired
    private ReactivePlantillaMongoRepository reactivePlantillaMongoRepository;

    @Override
    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla) {
        return reactivePlantillaMongoRepository.save(PlantillaMapper.toCollection(plantilla))
                .map(plantillaEntity -> PlantillaMapper.toModel(plantillaEntity));
    }
    
}
