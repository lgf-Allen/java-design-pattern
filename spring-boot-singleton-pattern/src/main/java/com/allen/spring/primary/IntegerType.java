/**
 * 
 */
package com.allen.spring.primary;

/**
 * @author first
 *
 */
public class IntegerType {

    
    private static class IntegerTypeCache{
        static final IntegerType cache[] ;
        static {
            cache= new IntegerType[10];
        }
    }
    
    public static IntegerType valueOf(IntegerType in) {
        return IntegerTypeCache.cache[1];
    }
}
