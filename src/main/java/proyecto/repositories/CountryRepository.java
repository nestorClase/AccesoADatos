package proyecto.repositories;

import org.springframework.data.jpa.repository.Query;
import proyecto.Entidades.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
