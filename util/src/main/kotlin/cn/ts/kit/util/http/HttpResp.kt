package cn.ts.kit.util.http

import com.alibaba.fastjson2.JSON
import java.io.InputStream
import java.net.http.HttpResponse
import java.util.function.Consumer

/**
 * HttpUtil请求的响应结果
 * @see HttpUtil
 * @author tomsean
 */
class HttpResp(private var origin: HttpResponse<*>) {

    companion object {
        const val CONTENT_TYPE = "Content-Type"
        const val JSON_CONTENT_TYPE = "application/json"
        const val STEAM_CONTENT_TYPE = "application/octet-stream"
        const val EMPTY_JSON = "{}";
    }

    private var code = 0 //http code

    init {
        this.code = origin.statusCode()
    }

    /**
     * 判断响应是application/json返回泛型对象
     * 转换过程使用fastjson2
     */
    fun <T> json(type: Class<T>, callback: Consumer<T>): HttpResp {
        if (!origin.headers().firstValue(CONTENT_TYPE).get().contains(JSON_CONTENT_TYPE)) {
            //类型不匹配
            return this;
        }
        if (origin.body()?.toString().isNullOrBlank()) {
            //返回值为空
            return this;
        }
        val respStr: String = origin.body()?.toString()?:EMPTY_JSON
        callback.accept(JSON.parseObject(respStr, type))
        return this;
    }

    /**
     * 判断响应是octet-stream返回inputStream
     */
    fun stream(callback: Consumer<InputStream>): HttpResp {
        if (!origin.headers().firstValue(CONTENT_TYPE).get().contains(STEAM_CONTENT_TYPE)) {
            //类型不匹配
            return this;
        }
        callback.accept(origin.body() as InputStream)
        return this;
    }
}