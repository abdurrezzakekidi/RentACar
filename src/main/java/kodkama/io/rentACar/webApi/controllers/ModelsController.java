package kodkama.io.rentACar.webApi.controllers;


import jakarta.validation.Valid;
import kodkama.io.rentACar.business.abstracts.ModelService;
import kodkama.io.rentACar.business.requests.CreateModelRequest;
import kodkama.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor

public class ModelsController {

    private ModelService modelService;


    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid()  CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }


}
