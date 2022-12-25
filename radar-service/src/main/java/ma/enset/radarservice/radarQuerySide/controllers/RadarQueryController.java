package ma.enset.radarservice.radarQuerySide.controllers;

import com.example.examen_blanc.commonApi.query.GetAllRadarsQuery;
import com.example.examen_blanc.commonApi.query.GetRadarById;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.*;
import radarService.radarQuerySide.entities.Radar;
import radarService.radarQuerySide.repositories.RadarRepository;

import java.util.List;

@RestController
@RequestMapping("/radar/queries")
@AllArgsConstructor
@CrossOrigin("*")
public class RadarQueryController {
    private QueryGateway queryGateway;
    private RadarRepository radarRepository;

    @GetMapping("/getAllRadars")
    public List<Radar> getAllRadars(){
        return queryGateway.query(new GetAllRadarsQuery(),
                ResponseTypes.multipleInstancesOf(Radar.class)).join();
    }

    @QueryHandler
    public List<Radar> on(GetAllRadarsQuery query){
        return radarRepository.findAll();
    }

    @GetMapping("/getRadar/{id}")
    public Radar getRadar(@PathVariable String id){
        return queryGateway.query(new GetRadarById(id),
                ResponseTypes.instanceOf(Radar.class)).join();
    }

    @QueryHandler
    public Radar on(GetRadarById query){
        return radarRepository.findById(query
                .getId()).get();
    }
}
