package com.gabriel.core.Serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * JDK 序列化
 * 
 * 序列化对象必须实现 java.io.Serializable接口
 * 
 * @author 周承世
 *
 */
public class JDKSerialization implements Serialization {

	@Override
	public byte[] serialize(Object obj) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		byte[] bs = baos.toByteArray();
		baos.close();
		oos.close();
		return bs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T deserialize(byte[] bytes, Class<T> clz) throws Exception {
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object obj = ois.readObject();
		bais.close();
		ois.close();
		return (T) obj;
	}

}
