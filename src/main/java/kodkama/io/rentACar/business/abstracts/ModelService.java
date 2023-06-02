package kodkama.io.rentACar.business.abstracts;

import kodkama.io.rentACar.business.requests.CreateModelRequest;
import kodkama.io.rentACar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);

}
