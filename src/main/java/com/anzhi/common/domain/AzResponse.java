package com.anzhi.common.domain;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class AzResponse extends HashMap<String,Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AzResponse() {}
	
    public AzResponse success() {
        this.put("result", "success");
        return this;
    }

    public AzResponse fail() {
        this.put("result", "fail");
        return this;
    }
    
	public AzResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public AzResponse data(Object data) {
        this.put("data", data);
        return this;
    }
    


    @Override
    public AzResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
