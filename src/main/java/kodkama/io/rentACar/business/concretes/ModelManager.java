package kodkama.io.rentACar.business.concretes;

import kodkama.io.rentACar.business.abstracts.ModelService;
import kodkama.io.rentACar.business.requests.CreateModelRequest;
import kodkama.io.rentACar.business.responses.GetAllModelsResponse;
import kodkama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodkama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodkama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model>models=modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponse =models.stream()

                .map(model ->this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class))
                .collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model=this.modelMapperService.forRequest().map(createModelRequest,Model.class);

        this.modelRepository.save(model);

    }


}
