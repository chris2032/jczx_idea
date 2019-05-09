package com.jczx.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SqlSessionFactoryUtil {
	private static final Logger logger = Logger.getLogger(SqlSessionFactoryUtil.class);
	private static final String CONFIGURATION_PATH = "mybatis-config.xml";
	private static final Map<String, SqlSessionFactory> SQLSESSIONFACTORYS = new HashMap();

	public static SqlSessionFactory getSqlSessionFactory(String datasource) {
		SqlSessionFactory sqlSessionFactory = SQLSESSIONFACTORYS.get(datasource);
		if (sqlSessionFactory != null) {
			return sqlSessionFactory;
		} else {
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(CONFIGURATION_PATH);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, datasource);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			SQLSESSIONFACTORYS.put(datasource, sqlSessionFactory);
			return sqlSessionFactory;
		}
	}
	public static SqlSession openSession(String datasource) {
		return getSqlSessionFactory(datasource).openSession();
	}
}