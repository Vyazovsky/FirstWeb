package com.viazovskyi.first_web.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClassUtils {

    @SuppressWarnings("unchecked")
    public static <T> T getInstance (Class<T> targetClass) {
        Constructor<?> noArgsConstructor = null;
        for (var constructor : targetClass.getDeclaredConstructors()) {
            if(constructor.getGenericParameterTypes().length == 0) {
                noArgsConstructor = constructor;
                break;
            }
        }

        if(noArgsConstructor == null) {
            throw new RuntimeException("No empty constructor found in " + targetClass.getName());
        }

        noArgsConstructor.setAccessible(true);

        try {
            return (T) noArgsConstructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }

}
