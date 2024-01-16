package com.ayseozcan;

import org.springframework.stereotype.Service;

@Service
public class DrugService {
    private final IDrugRepository drugRepository;

    public DrugService(IDrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    public Boolean save(Drug drug) {
        drugRepository.save(Drug.builder()
                .brand(drug.getBrand())
                .company(drug.getCompany())
                .stock(drug.getStock())
                .build());
        return true;
    }

    public Iterable<Drug> findAll() {
        return drugRepository.findAll();
    }
}
