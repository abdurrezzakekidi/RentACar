package kodkama.io.rentACar.dataAccess.abstracts;

import kodkama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository <Brand,Integer> {
    boolean existsByName(String name);

}
