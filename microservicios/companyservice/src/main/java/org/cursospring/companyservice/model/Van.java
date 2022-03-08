package org.cursospring.companyservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Van {
    private String brand;
    private String model;
    private int companyId;
}
