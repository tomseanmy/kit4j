package cn.ts.kit.util.http

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

/**
 * Http请求工具
 * @author tomsean
 */
class HttpUtil {
    companion object {
        private fun defaultClient(): HttpClient {
            return HttpClient.newHttpClient()
        }

        fun <T> get(url: String, headers: Map<String, String> = mapOf(), query: Map<String, String> = mapOf(), client: HttpClient = defaultClient()): HttpResp {
            val uri = query2str(url, query)
            val requestBuilder = HttpRequest.newBuilder()
            headers.forEach { (key: String, value: String) -> requestBuilder.header(key, value) }
            requestBuilder.uri(uri)
            return HttpResp(client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofByteArray()))
        }

        /**
         * 请求参数转string
         */
        private fun query2str(url: String, query: Map<String, String> = mapOf()): URI {
            val builder = StringBuilder()
            query.forEach { (key, value) -> builder.append("&", key, "=", value) }
            if (url.contains("?")) {
                return URI.create(url + builder.toString())
            }
            return URI.create(url + builder.substring(1))
        }
    }
}