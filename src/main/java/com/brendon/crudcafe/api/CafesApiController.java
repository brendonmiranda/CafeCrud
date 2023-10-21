package com.brendon.crudcafe.api;

import com.brendon.crudcafe.model.Cafe;
import com.brendon.crudcafe.service.CafeService;
import jakarta.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Controller
@RequestMapping("${openapi.swaggerCafe.base-path:/v1}")
public class CafesApiController implements CafesApi {

    private final NativeWebRequest request;
    private final CafeService cafeService;

    @Autowired
    public CafesApiController(NativeWebRequest request, CafeService cafeService) {
        this.request = request;
        this.cafeService = cafeService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Void> createCafe() {
        final Cafe cafe = new Cafe(1L, "First Cafe");

        try {
            cafeService.createCafe(cafe);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create a cafe.", e);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
