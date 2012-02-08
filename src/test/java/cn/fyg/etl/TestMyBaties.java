package cn.fyg.etl;


import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.fyg.etl.mapper.InnerAccountMapper;


public class TestMyBaties {
	
	//指定MyBatis配置文件
	private static final String RESOURCE = "mybatis-config.xml";
	
	/**
	 * 共6步操作完成CRUD
	 * @throws IOException
	 */
	@Test
	public void testBaties() throws IOException{
		
		//1、指定MyBaties配置文件
		Reader reader = Resources.getResourceAsReader(RESOURCE);
		//2、创建SqlSessionFactory()
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession session = null;
		try {
			
			//3、获取SqlSession
			session = sessionFactory.openSession();
			
			//4、获取DAO接口对象
			InnerAccountMapper mapper = session.getMapper(InnerAccountMapper.class);
			
			List<HashMap<String,Object>> list=mapper.getList();
			System.out.println(list.size());
			for(HashMap<String,Object> map:list){
				System.out.println(map.get("fnumber"));
				System.out.println(map.get("fname_l2"));
			}
		
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			//6、关闭SqlSession
			if(session != null){
				session.close();
			}
		}
		
	}
	
}