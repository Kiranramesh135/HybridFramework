package com.hybridframework.utils;


public class ConfigProperty {
	
	public enum ConfigTimeout {
		TIMEOUT_VALUE("100");
		
		String value;
		
		ConfigTimeout(String value) {
			this.value=value;
		}
		
		public int getPropertyAsInt() {
			return Integer.parseInt(value);
		}
		
		public String getProperty() {
			return value;
		}
		
	}
}
