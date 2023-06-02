package kodkama.io.rentACar.dataAccess.abstracts;

import kodkama.io.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
