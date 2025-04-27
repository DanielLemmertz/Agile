package br.com.caelum.clines.api.users;

import br.com.caelum.clines.api.aircraft.AircraftForm;
import br.com.caelum.clines.api.aircraft.AircraftView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static br.com.caelum.clines.shared.util.StringNormalizer.normalize;
import static org.springframework.http.ResponseEntity.created;

public class UsersController {
    @GetMapping("{code}")
    UserView show(@PathVariable String code) {
        return service.showAircraftBy(normalize(code));
    }

    @GetMapping
    List<Users> list() {
        return service.listAllAircraft();
    }

    @PostMapping
    ResponseEntity<?> createBy(@RequestBody @Valid AircraftForm form) {
        var code = service.createAircraftBy(form);

        var uri = URI.create("/aircraft/").resolve(code);

        return created(uri).build();
    }
}
