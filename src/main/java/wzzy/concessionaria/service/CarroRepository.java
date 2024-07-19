package wzzy.concessionaria.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wzzy.concessionaria.model.CarroModel;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<CarroModel, Integer> {
    
    List<CarroModel> findAll();
    
    CarroModel findByCodigo(int codigo);

    int countByCodigo(int codigo);
}
