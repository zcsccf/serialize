package com.gabriel.core.Serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Kryo 序列化
 * 
 * @author 周承世
 *
 */
public class KryoSerialization implements Serialization {
	@Override
	public byte[] serialize(Object obj) throws Exception {
		Kryo kryo = kryoLocal.get();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		Output output = new Output(byteArrayOutputStream);
		kryo.writeObject(output, obj);
		output.close();
		return byteArrayOutputStream.toByteArray();
	}

	@Override
	public <T> T deserialize(byte[] bytes, Class<T> clz) throws Exception {
		Kryo kryo = kryoLocal.get();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		Input input = new Input(byteArrayInputStream);
		input.close();
		return (T) kryo.readObject(input, clz);
	}

	private static final ThreadLocal<Kryo> kryoLocal = new ThreadLocal<Kryo>() {
		@Override
		protected Kryo initialValue() {
			Kryo kryo = new Kryo();
			kryo.setReferences(true);
			kryo.setRegistrationRequired(false);
			return kryo;
		}
	};

}
