package cn.ts.kit.wechat.pay

/**
 * 公共请求头参数
 */
class PublicHeader {

}

/**
 * 公众号
 * @author tomsean
 */
class JsapiClient {
    companion object {
        val TRADE_URL = "/v3/pay/transactions/jsapi" //下单地址
    }
    //下单请求
    class TradeReq {
        lateinit var appid: String
        lateinit var mchid: String
        lateinit var description: String

    }
}

/**
 * 移动设备
 */
class AppClient {

}

/**
 * 移动Web
 */
class H5Client {

}

/**
 * 线下/当面
 */
class NativeClient {

}

/**
 * 小程序
 */
class MiniClient {

}