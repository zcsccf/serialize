package com.gabriel.core.Serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

/**
 * Hessian 序列化
 * 
 * 序列化对象必须实现 java.io.Serializable接口
 * 
 * @author 周承世
 *
 */
public class Hessian2Serialization implements Serialization {
	@Override
	public byte[] serialize(Object data) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Hessian2Output out = new Hessian2Output(bos);
		out.writeObject(data);
		out.flush();
		return bos.toByteArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T deserialize(byte[] bytes, Class<T> clz) throws Exception {
		Hessian2Input input = new Hessian2Input(new ByteArrayInputStream(bytes));
		return (T) input.readObject(clz);
	}
}