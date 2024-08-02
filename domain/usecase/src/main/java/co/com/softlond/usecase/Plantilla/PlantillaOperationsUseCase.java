package co.com.softlond.usecase.Plantilla;

import java.sql.Date;

import org.springframework.stereotype.Service;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gateways.HistorialGateway;
import co.com.softlond.model.gateways.PlantillaGateways;
import reactor.core.publisher.Mono;

@Service
public class PlantillaOperationsUseCase  {
    
    private final PlantillaGateways plantillaGateways;
    private final HistorialGateway historialGateway;

    public PlantillaOperationsUseCase(PlantillaGateways plantillaGateways, HistorialGateway historialGateway) {
        this.plantillaGateways = plantillaGateways;
        this.historialGateway = historialGateway;
    }

    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla) {
        /* lOGICA DE NEGOCIO */
        

        plantilla.setFechaActualizacion(new Date(System.currentTimeMillis()));
        return plantillaGateways.savePlantilla(plantilla);
    }

    // public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla) {
    //     plantilla.setFechaActualizacion(new Date(System.currentTimeMillis()));
        
    //     return historialGateway.findLast()
    //         .flatMap(historial -> {
    //             // Si existe historial, actualiza el contador y la descripción
    //             historial.setContador(historial.getContador() + 1);
    //             historial.setLastDescription(plantilla.getDescripcion());
    //             return historialGateway.update(historial)
    //                 .then(plantillaGateways.savePlantilla(plantilla));
    //         })
    //         .switchIfEmpty(
    //             // Si no existe historial, crea uno nuevo
    //             historialGateway.create(new HistorialModel(1, plantilla.getDescripcion()))
    //                 .then(plantillaGateways.savePlantilla(plantilla))
    //         );
    // }

}
