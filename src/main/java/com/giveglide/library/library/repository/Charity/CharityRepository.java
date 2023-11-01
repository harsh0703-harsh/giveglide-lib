package com.giveglide.library.library.repository.Charity;

import com.giveglide.library.library.models.CharityModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharityRepository extends MongoRepository<CharityModel,String> {

}
