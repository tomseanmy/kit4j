package cn.ts.kit.wechat.pay

/**
 *
 * @author tomsean
 */
class WechatPay {

    companion object {
        val HOST = "https://api.mch.weixin.qq.com" //支付网关
        val STANDARD_HOST = "https://api.weixin.qq.com" //灾备网关

        class Builder {
            lateinit var mchId: String //商户ID
            lateinit var mchHost: String

        }
    }



}