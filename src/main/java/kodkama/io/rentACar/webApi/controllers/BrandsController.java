package kodkama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodkama.io.rentACar.business.abstracts.BrandService;
import kodkama.io.rentACar.business.requests.CreateBrandRequest;
import kodkama.io.rentACar.business.requests.UpdateBrandRequest;
import kodkama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodkama.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // annatation   bilgilendirme  ifadesidir
@RequestMapping("/api/brands")  //insanların olaşması  için ör  www.kodlama.io/api/ brands
@AllArgsConstructor

public class BrandsController {
private BrandService brandService;

   /* gir  parametrelerine  bak  git uygulaamyı tara
/ kim  bu BrandService'i  implementi ediyor    işte   BrandManagere
git   onun new lenmiş halini  ver  anlamında
*/

    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add( @RequestBody() @Valid() CreateBrandRequest createBrandRequest){
     this.brandService.add(createBrandRequest);

    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getByIdBrandResponse(@PathVariable int id){

        return brandService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);

    }


}
