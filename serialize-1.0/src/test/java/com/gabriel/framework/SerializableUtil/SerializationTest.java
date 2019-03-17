package com.gabriel.framework.SerializableUtil;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.gabriel.core.Serialization.Serialization;

public class SerializationTest {

	public static void main(String[] args) throws Exception {

		ExtensionLoader<Serialization> extensionLoader = ExtensionLoader.getExtensionLoader(Serialization.class);
		Serialization fastJson = extensionLoader.getExtension("fastjson");
		TestBean bean = new TestBean();
		bean.setId("111");
		bean.setName("fsdfsfsd");

		byte[] bytes = fastJson.serialize(bean);
		System.out.println(new String(bytes));
		bean = fastJson.deserialize(bytes, TestBean.class);
		System.out.println(bean.getName());
	}

}