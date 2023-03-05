package com.icrypt.app.tenantcontext;

import org.springframework.util.Assert;

public class CustomerContextHolder {


    private static ThreadLocal<ClientDatabase> CONTEXT
      = new ThreadLocal<>();

    public static void set(ClientDatabase clientDatabase) {
        Assert.notNull(clientDatabase, "clientDatabase cannot be null");
        CONTEXT.set(clientDatabase);
    }

    public static ClientDatabase getClientDatabase() {
    	return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
	}	