package com.gabriel.core.Serialization;

import com.google.gson.Gson;

public class GsonSerialization implements Serialization {

	static Gson gson = new Gson();

	@Override
	public byte[] serialize(Object obj) throws Exception {
		String json = gson.toJson(obj);
		return json.getBytes();
	}

	@Override
	public <T> T deserialize(byte[] bytes, Class<T> clz) throws Exception {
		Object obj = gson.fromJson(new String(bytes), clz);
		return (T) obj;
	}

}
