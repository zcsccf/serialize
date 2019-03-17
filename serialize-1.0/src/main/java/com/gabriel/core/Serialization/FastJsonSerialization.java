package com.gabriel.core.Serialization;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * FastJson 序列化
 * 
 * @author 周承世
 *
 */
public class FastJsonSerialization implements Serialization {
	static final String charsetName = "UTF-8";

	@Override
	public byte[] serialize(Object data) throws Exception {
		SerializeWriter out = new SerializeWriter();
		JSONSerializer serializer = new JSONSerializer(out);
		serializer.config(SerializerFeature.WriteEnumUsingToString, true);
		serializer.config(SerializerFeature.WriteClassName, true);
		serializer.write(data);
		return out.toBytes(charsetName);
	}

	@Override
	public <T> T deserialize(byte[] data, Class<T> clz) throws Exception {
		return JSON.parseObject(new String(data), clz);
	}
}
