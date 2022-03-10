package org.cursospring.companyservice.feignclients;

import java.util.List;

import org.cursospring.companyservice.model.Van;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//, url = "http://localhost:8003/van"
@FeignClient(name = "van-service", path = "/van")
public interface VanFeignClient {


        @PostMapping()
        Van save(@RequestBody Van van);

        @GetMapping("/bycompany/{companyId}")
        List<Van> getVans(@PathVariable("companyId") int companyId);

}
