package com.extension.demo;

import com.extension.models.Projects;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectsRepository extends MongoRepository<Projects, String> {
  Projects findBy_id(ObjectId _id);
}

