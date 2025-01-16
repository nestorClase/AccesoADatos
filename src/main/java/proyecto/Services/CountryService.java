package proyecto.Services;

import org.springframework.data.jpa.repository.Query;
import proyecto.Entidades.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    void delete(Long id);

    Long create(Country country);


    @Query("SELECT c FROM Country c WHERE c.name = ?1")
    List<Country> findByName(String name);
}
