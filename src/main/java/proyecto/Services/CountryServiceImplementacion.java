package proyecto.Services;

import java.util.List;
import java.util.Optional;

import proyecto.Entidades.Country;
import org.springframework.beans.factory.annotation.Autowired;
import proyecto.repositories.CountryRepository;

import org.springframework.stereotype.Service;

@Service
public class CountryServiceImplementacion implements CountryService {
    @Autowired
    private final CountryRepository countryRepository;

    public CountryServiceImplementacion(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Long create(Country country) {
        return countryRepository.save(country).getId();
    }

    @Override
    public List<Country> findByName(String name) {
        return List.of();
    }
}
