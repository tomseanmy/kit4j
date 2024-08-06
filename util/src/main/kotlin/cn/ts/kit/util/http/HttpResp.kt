package cn.ts.kit.util.http

import com.alibaba.fastjson2.JSON
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
        const val EMPTY_JSON = "{}";
    }

    private var code = 0 //http code

    init {
        this.code = origin.statusCode()
    }

    fun <T> json(type: Class<T>, callback: Consumer<T>): HttpResp {
        if (origin.body()?.toString().isNullOrBlank()) {
            return this;
        }
        val respStr: String = origin.body()?.toString()?:EMPTY_JSON
        callback.accept(JSON.parseObject(respStr, type))
        return this;
    }

}