package com.extension.models;

import org.bson.types.ObjectId;
import java.util.List;
import org.springframework.data.annotation.Id;

public class Projects {
  @Id
  public ObjectId _id;
  
  public String name;
  public List<ComponentGroups> componentGroups;
  
  // ObjectId needs to be converted to string
  public String get_id() { return _id.toHexString(); }
  public void set_id(ObjectId _id) { this._id = _id; }
  
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public void setComponentGroups(List<ComponentGroups> componentGroups){
  	this.componentGroups = componentGroups;
  }
  
  public List<ComponentGroups> getComponentGroups(){
  	return this.componentGroups;
  }
  
  public Projects() {}
  
  public Projects(ObjectId id, String name, List<ComponentGroups> componentGroups){
  	this._id = id;
  	this.name = name;
  	this.componentGroups = componentGroups;
  }

  
}