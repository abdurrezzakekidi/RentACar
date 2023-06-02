package kodkama.io.rentACar.business.concretes;

import kodkama.io.rentACar.business.abstracts.BrandService;
import kodkama.io.rentACar.business.requests.CreateBrandRequest;
import kodkama.io.rentACar.business.requests.UpdateBrandRequest;
import kodkama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodkama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodkama.io.rentACar.business.rules.BrandBusinessRules;
import kodkama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodkama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodkama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service  // bu sınıf bir  business nesnesidir.
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;


    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
      /*
       List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();

        for (Brand brand : brands) {
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());

            brandsResponse.add(responseItem);
            şu yukardaki kodu  100 tane  Brandimiz  olsa  çok satır yazmak zorunda  kalacağız
            ve  acaba ben bu veriyi girdim mi ditye  kafamızda  sorular oluşacak bu sebepten dolayı  alt satırda

            Mapperleri kullanarak  Clean bir  kod  yazmamıza  yardımcı olmuş

        }
*/
        List<GetAllBrandsResponse> brandsResponse =brands.stream()
                .map(brand ->this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;

    }

    @Override
    public GetByIdBrandResponse getById(int id) {
       Brand brand= this.brandRepository.findById(id).orElseThrow();

       GetByIdBrandResponse response=this.modelMapperService
               .forResponse().map(brand, GetByIdBrandResponse.class);

        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

       Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {

        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);

    }

}



