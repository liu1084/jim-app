package com.jim.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by jim on 2017/3/10.
 * This class is ...
 */

public class ClassUtils {

	private static final Logger logger = Logger.getLogger(ClassUtils.class);

	public static Object getInstance(String className, Class [] constructType, Object [] constructValue) {
		if (StringUtils.isEmpty(className)) {
			return null;
		}
		try {
			Class clazz = Class.forName(className);
			Constructor constructor = clazz.getConstructor(constructType);
			Object instance = constructor.newInstance(constructValue);
			return instance;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.warn("不能找到所配置的类：" + className);
		} catch (InstantiationException e) {
			e.printStackTrace();
			logger.warn("所配置类初始化失败！");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			logger.warn("所配置初始化失败！");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object getInstance(String className) {
		if (StringUtils.isEmpty(className)) {
			return null;
		}
		try {
			Class clazz = Class.forName(className);
			Object instance = clazz.newInstance();
			return instance;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.warn("不能找到所配置的类：" + className);
		} catch (InstantiationException e) {
			e.printStackTrace();
			logger.warn("所配置类初始化失败！");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			logger.warn("所配置初始化失败！");
		}
		return null;
	}
}
