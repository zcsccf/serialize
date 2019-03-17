package com.gabriel.core.Serialization;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * 序列化接口
 * 
 * @author 周承世
 *
 */
@SPI
public interface Serialization {

	/**
	 * 序列化对象
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	byte[] serialize(Object obj) throws Exception;

	/**
	 * 反序列化
	 * 
	 * @param bytes
	 * @param clz
	 * @return
	 * @throws Exception
	 */
	<T> T deserialize(byte[] bytes, Class<T> clz) throws Exception;

}
