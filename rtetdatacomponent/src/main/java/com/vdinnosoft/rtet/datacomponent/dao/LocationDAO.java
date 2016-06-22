package com.vdinnosoft.rtet.datacomponent.dao;

import java.util.Set;
public interface LocationDAO {

	public void getLocation(Integer id);
	public void getLocation(String name); 
	public void removeLocation(Integer id);
	public void updateLocation(LocationDAOImpl location);
	public Integer addLocation(LocationDAOImpl location);
	public Set<LocationDAOImpl> getLocation(); 
	public void removeLocation(LocationDAOImpl location);
	
}
