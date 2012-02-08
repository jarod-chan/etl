package cn.fyg.etl.mapper;

import java.util.HashMap;
import java.util.List;

public interface InnerAccountMapper {
	
	public List<HashMap<String,Object>> getAll();
	
	public List<HashMap<String,Object>> getList();
}
