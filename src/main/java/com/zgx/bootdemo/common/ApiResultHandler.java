package com.zgx.bootdemo.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.internal.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

/**
 * @author zhouguixing
 * @date 2019/4/24 15:10
 * @description 接口拦截器
 */
@ControllerAdvice(annotations = Controller.class)
public class ApiResultHandler implements ResponseBodyAdvice {

    private ThreadLocal<ObjectMapper>  mapperThreadLocal = ThreadLocal.withInitial(ObjectMapper::new);

    private static final Class[] annos = {
            RequestMapping.class,
            GetMapping.class,
            PostMapping.class,
            DeleteMapping.class,
            PutMapping.class
    };

    /**
     * 对所有Controller的接口方法进行拦截
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        AnnotatedElement element = returnType.getAnnotatedElement();
        return Arrays.stream(annos).anyMatch(anno -> anno.isAnnotation() && element.isAnnotationPresent(anno));
    }

    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Object out;
        ObjectMapper mapper = mapperThreadLocal.get();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        if(body instanceof ApiResult){
            out = body;
        }
        else if (body instanceof ErrorCode){
            ErrorCode errorCode = (ErrorCode) body;
            out = new ApiResult(errorCode.getCode(),errorCode.getMsg(),null);
        }
        else if (body instanceof String){
            ApiResult result = ApiResult.valueOf(body);
            try {
                out = mapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                out = ApiResult.errorOf(ErrorCode.JSON_PARSE_ERROR,e.getMessage());
            }
        }
        else{
            out = ApiResult.valueOf(body);
        }
        return out;
    }

}
