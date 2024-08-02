package co.com.softlond.mongo.Plantilla;

import org.springframework.beans.BeanUtils;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.mongo.Collections.HistorialCollection;
import co.com.softlond.mongo.Collections.PlantillaCollections;

public class HistorialMapper {


    public static HistorialModel toModel(HistorialCollection historialCollection) {
        return HistorialModel.builder()
                .contador(historialCollection.getContador())
                .lastDescription(historialCollection.getLastDescription())
                .build();
    }
    
    public static HistorialCollection toCollection(HistorialModel historialModel) {
        HistorialCollection historialCollection = new HistorialCollection();
        historialCollection.setContador(historialModel.getContador());
        historialCollection.setLastDescription(historialModel.getLastDescription());
        return historialCollection;
    }

    // public static HistorialModel toModel(HistorialCollection historialCollection){
    //     HistorialModel historialModel = new HistorialModel();
    //     BeanUtils.copyProperties(historialCollection, historialModel);
    //     return historialModel;
    // }

    // public static HistorialCollection toCollection(HistorialModel historialModel){
    //     HistorialCollection historialCollection = new HistorialCollection();
    //     BeanUtils.copyProperties(historialModel, historialCollection);
    //     return historialCollection;
    // }

}
