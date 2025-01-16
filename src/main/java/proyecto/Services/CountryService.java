package proyecto.Services;

import proyecto.Entidades.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    void delete(Long id);

    Long create(Country country);
}
