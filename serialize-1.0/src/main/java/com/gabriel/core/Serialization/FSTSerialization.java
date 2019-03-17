package com.gabriel.core.Serialization;

import org.nustaq.serialization.FSTConfiguration;

/**
 * FST序列化 序列化对象必须实现Serializable 或者 Externalizable接口
 * 
 * @author 周承世
 *
 */
public class FSTSerialization implements Serialization {
	static FSTConfiguration configuration = FSTConfiguration.createDefaultConfiguration();

	@Override
	public byte[] serialize(Object obj) throws Exception {
		return configuration.asByteArray(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T deserialize(byte[] bytes, Class<T> clz) throws Exception {
		return (T) configuration.asObject(bytes);
	}

}
