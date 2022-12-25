package ma.enset.radarservice.radarCommandSide.controllers;

import lombok.AllArgsConstructor;
import ma.enset.commonapi.commands.CreateRadarCommand;
import ma.enset.commonapi.commands.UpdateRadarCommand;
import ma.enset.commonapi.dtos.CreateRadarRequestDTO;
import ma.enset.commonapi.dtos.UpdateRadarRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/radar/commands")
@AllArgsConstructor
@CrossOrigin("*")
public class RadarCommandController {

    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/createRadar")
    public CompletableFuture<String> createRadar(@RequestBody CreateRadarRequestDTO request) {
        return commandGateway.send(new CreateRadarCommand(UUID.randomUUID().toString(),
                request.getVitesseMax(), request.getLongtitude(), request.getLatitude()));
    }

    @PutMapping("/updateRadar")
    public CompletableFuture<String> updateRadar(@RequestBody UpdateRadarRequestDTO request) {
        return commandGateway.send(new UpdateRadarCommand(request.getId(),
                request.getVitesseMax(), request.getLongtitude(), request.getLatitude()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        ResponseEntity<String> entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

    @GetMapping("/eventStore/{radarId}")
    public Stream getEventsForAccount(@PathVariable(value = "radarId") String radarId) {
        return eventStore.readEvents(radarId).asStream();
    }

}
