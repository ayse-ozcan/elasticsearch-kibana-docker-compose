package com.ayseozcan;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDrugRepository extends ElasticsearchRepository<Drug, String> {
}
