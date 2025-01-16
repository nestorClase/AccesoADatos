package proyecto.Controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proyecto.Entidades.Country;
import proyecto.Services.CountryService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class Countrycontroller {

        private CountryService countryService;

        public Countrycontroller(CountryService countryService) {
            this.countryService = countryService;
        }

    @GetMapping
    @ResponseBody
    public List<Country> getAll() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Country> getById(@PathVariable("id") Long id) {
        return countryService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        countryService.delete(id);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> add(@RequestBody Country country) {
        Long id = countryService.create(country);
        return new ResponseEntity<>(Collections.singletonMap("id", id), HttpStatus.CREATED);
    }

}
