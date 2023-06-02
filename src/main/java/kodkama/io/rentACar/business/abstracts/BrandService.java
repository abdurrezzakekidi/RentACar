package kodkama.io.rentACar.business.abstracts;

import kodkama.io.rentACar.business.requests.CreateBrandRequest;
import kodkama.io.rentACar.business.requests.UpdateBrandRequest;
import kodkama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodkama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodkama.io.rentACar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);

    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
