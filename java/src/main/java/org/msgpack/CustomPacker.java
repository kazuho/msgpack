//
// MessagePack for Java
//
// Copyright (C) 2009-2010 FURUHASHI Sadayuki
//
//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at
//
//        http://www.apache.org/licenses/LICENSE-2.0
//
//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//
package org.msgpack;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomPacker {
	private static Logger LOG = LoggerFactory.getLogger(CustomPacker.class);

	private static ConcurrentHashMap<Class<?>, MessagePacker> map = new ConcurrentHashMap<Class<?>, MessagePacker>();

	public static void register(Class<?> target, MessagePacker packer) {
		LOG.debug("register a MessagePacker object for the type: "
				+ target.getName());
		map.putIfAbsent(target, packer);
	}

	public static MessagePacker get(Class<?> target) {
		return map.get(target);
	}

	public static boolean isRegistered(Class<?> target) {
		return map.containsKey(target);
	}
}
