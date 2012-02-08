package cn.fyg.etl.mapper;

import java.util.HashMap;
import java.util.List;

public interface CertPersonMapper {
	
	/**
	 * ����֤��ÿһ��֤��Ľ��ô���
	 * @return
	 */
	public List<HashMap<String,Object>> getCertPseron();
	
	/**
	 * ����ÿ��������֤��Ľ��ô���
	 * @param top  ����
	 * @return
	 */
	public List<HashMap<String,Object>> getCertPersonTimes(int top);

}
