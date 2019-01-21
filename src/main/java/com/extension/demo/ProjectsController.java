package com.extension.demo;

import com.extension.models.Projects;
import com.extension.demo.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.bson.types.ObjectId;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectsController {
	  @Autowired
	  private ProjectsRepository repository;
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<Projects> getAllProjects() {
		  return repository.findAll();
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public Projects getProjectById(@PathVariable("id") ObjectId id) {
	    return repository.findBy_id(id);
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyProjectById(@PathVariable("id") ObjectId id, @Valid @RequestBody Projects Projects) {
	    Projects.set_id(id);
	    repository.save(Projects);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public Projects createProject(@Valid @RequestBody Projects Projects) {
	    Projects.set_id(ObjectId.get());
	    repository.save(Projects);
	    return Projects;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteProject(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	  }
	}