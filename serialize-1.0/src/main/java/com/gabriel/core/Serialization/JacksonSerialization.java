package com.gabriel.core.Serialization;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson 序列化
 * 
 * @author 周承世
 *
 */
public class JacksonSerialization implements Serialization {

	@Override
	public byte[] serialize(Object obj) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(obj);
		return json.getBytes();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T deserialize(byte[] bytes, Class<T> clz) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Object obj = mapper.readValue(new String(bytes), clz);
		return (T) obj;
	}

}
