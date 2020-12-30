# 快速开始

### 方式一：maven添加依赖

```java
<dependency>
    <groupId>com.yungouos.pay</groupId>
    <artifactId>yungouos-pay-sdk</artifactId>
    <version>2.0.3</version>
</dependency>

```

### 方式二：下载jar导入




# 微信支付--示例代码


## 微信扫码支付

返回二维码地址或微信支付二维码连接（需自行生成二维码）

```java
String result= WxPay.nativePay(System.currentTimeMillis() + "", "1", mchId, "测试", null, null, null, null,null,null,null,key);
```

## 微信公众号支付

返回JSSDK需要的支付jspackage

	String jspackage = WxPay.jsapiPay(System.currentTimeMillis() + "", "1", mchId, "测试", "o-_-itxeWVTRnl-iGT_JJ-t3kpxU", null, null, null,null,null,null,key);

## 收银台支付

返回收银台支付地址，跳转到该地址即可。收银台可根据用户设备自动决定扫码支付还是JSAPI支付
	
	String cashierPayUrl=WxPay.cashierPay(System.currentTimeMillis() + "", "1", mchId, "测试收银台支付", null, null, null,null,null,null, key);

## 小程序支付

返回小程序支付所需的参数，需要使用小程序段端通过携带返回的参数跳转到支付收银小程序发起支付
	
	JSONObject minAppPay = WxPay.minAppPay(System.currentTimeMillis()+"", "0.01", mchId, "小程序支付演示", "海底捞", null, null,null,null,null,key);

## 微信刷卡支付

返回刷卡支付结果

	CodePayBiz codePayBiz = WxPay.codePay(System.currentTimeMillis() + "", "0.01", mchId, "测试", "134681285892396042", null, null, null, null, null, null, key);

返回结果说明：[http://open.pay.yungouos.com/#/api/api/pay/wxpay/codePay](http://open.pay.yungouos.com/#/api/api/pay/wxpay/codePay "http://open.pay.yungouos.com/#/api/api/pay/wxpay/codePay")		

## 微信刷脸支付

返回微信刷脸支付结果

	FacePayBiz facePayBiz = WxPay.facePay(System.currentTimeMillis() + "", "0.01", mchId, "人脸支付测试", "o-_-itxeWVTRnl-iGT_JJ-t3kpxU", "人脸特征码", null, null, null, null, null, key);

返回结果说明：[http://open.pay.yungouos.com/#/api/api/pay/wxpay/facePay](http://open.pay.yungouos.com/#/api/api/pay/wxpay/facePay "http://open.pay.yungouos.com/#/api/api/pay/wxpay/facePay")	

## 微信H5支付

返回H5支付的链接地址

	String result = WxPay.H5Pay(System.currentTimeMillis() + "", "0.01", mchId, "H5支付测试", null, null, null, null, null, null, key);

## 微信APP支付

返回APP支付所需参数

	JSONObject appPayParams = WxPay.appPay(微信开放平台APPID, System.currentTimeMillis() + "", "0.01", mchId, "APP支付测试", null, null, null, null, null, key);

## 查询刷卡支付结果

用于查询刷卡支付结果

	CodePayBiz codePayBiz2 = WxPay.getCodePayResult("1556267522899", mchId, key);	

返回结果说明：[http://open.pay.yungouos.com/#/api/api/pay/wxpay/getCodePayResult](http://open.pay.yungouos.com/#/api/api/pay/wxpay/getCodePayResult "http://open.pay.yungouos.com/#/api/api/pay/wxpay/getCodePayResult")	

## 发起退款接口

	RefundOrder refundOrder = WxPay.orderRefund("1556267522899", "1529637931", "0.1", "6BA371F4CFAB4465AA04DAEADBAC4161");

返回结果说明：[http://open.pay.yungouos.com/#/api/api/pay/wxpay/refundOrder](http://open.pay.yungouos.com/#/api/api/pay/wxpay/refundOrder "http://open.pay.yungouos.com/#/api/api/pay/wxpay/refundOrder")

## 查询微信退款结果接口

	RefundSearch refundSearch = WxPay.getRefundResult("R17200911248111", mchId, key);

返回结果说明：[http://open.pay.yungouos.com/#/api/api/pay/wxpay/getRefundResult](http://open.pay.yungouos.com/#/api/api/pay/wxpay/getRefundResult "http://open.pay.yungouos.com/#/api/api/pay/wxpay/getRefundResult")

没错就是这么简单，就可以快速的接入微信官方支付。

# 支付宝--示例代码 #


## 支付宝扫码支付

返回二维码地址或微信支付二维码连接（需自行生成二维码）

    String result = AliPay.nativePay(System.currentTimeMillis() + "", "0.01", "2088802674000755", "测试", null, null, null, null, "6BA371F4CFAB4465AA04DAEADBAC4161");

## 支付宝WAP支付

返回支付宝跳转连接，手机端重定向自动打开支付宝APP付款

	String result=AliPay.wapPay(System.currentTimeMillis() + "", "0.01", "2088802674000755", "支付测试", null, null, "6BA371F4CFAB4465AA04DAEADBAC4161");


## 发起支付宝退款接口

	RefundOrder refundOrder = AliPay.orderRefund("Y194506551713811", "2088802674000755", "0.1", "测试退款","6BA371F4CFAB4465AA04DAEADBAC4161");

返回结果说明：[https://open.pay.yungouos.com/#/api/api/pay/alipay/refundOrder](https://open.pay.yungouos.com/#/api/api/pay/alipay/refundOrder "https://open.pay.yungouos.com/#/api/api/pay/alipay/refundOrder")

## 查询支付宝退款结果接口

	RefundSearch refundSearch = AliPay.getRefundResult("R17200911248111", "2088802674000755", key);

返回结果说明：[https://open.pay.yungouos.com/#/api/api/pay/alipay/getRefundResult](https://open.pay.yungouos.com/#/api/api/pay/alipay/getRefundResult "https://open.pay.yungouos.com/#/api/api/pay/alipay/getRefundResult")

没错就是这么简单，就可以快速的接入支付宝官方支付。

## 签名工具
	 //参数签名
	 PaySignUtil.createSign([类型Map]签名参数,商户密钥)；
	
	 //回调签名验证
	 PaySignUtil.checkNotifySign(回调的request对象,商户密钥)；

# 其他接口

## 订单查询接口
	PayOrder payOrder = SystemOrder.getOrderInfoByOutTradeNo("1556267522899", "1529637931", "6BA371F4CFAB4465AA04DAEADBAC4161");


返回结果说明：[http://open.pay.yungouos.com/#/api/api/pay/wxpay/getWxPayOrderInfo](http://open.pay.yungouos.com/#/api/api/pay/wxpay/getWxPayOrderInfo "http://open.pay.yungouos.com/#/api/api/pay/wxpay/getWxPayOrderInfo")



## 获取微信授权URL

	String url="http://www.yungouos.com/oauth?a=1"; 
	JSONObject paramJson=new JSONObject();
	paramJson.put("key", "123456");
	String oauthUrl = WxPay.getWxOauthUrl(paramJson.toJSONString(), url);

## 查询微信授权信息

	WxOauthInfo wxOauthInfo = WxPay.getWxOauthInfo("45AA0CEE43AE4F048384D655A77FA770");

# 方法说明

## 微信扫码支付

    WxPay.nativePay(订单号,支付金额,微信支付商户号,商品描述,返回类型，附加数据，异步回调地址,同步回调地址,分账配置单号,是否自动分账,自动分账节点,商户密钥)

## 微信公众号支付

	 WxPay.jsapi(订单号,支付金额,微信支付商户号,商品描述,用户openid，附加数据，异步回调地址,同步回调地址,分账配置单号,是否自动分账,自动分账节点,商户密钥)

## 收银台支付

	 WxPay.cashierPay(订单号,支付金额,微信支付商户号,商品描述,附加数据，异步回调地址,同步回调地址,分账配置单号,是否自动分账,自动分账节点,商户密钥)

## 小程序支付

	 WxPay.minAppPay(订单号,支付金额,微信支付商户号,商品描述,收银台标题,附加数据，异步回调地址,分账配置单号,是否自动分账,自动分账节点,商户密钥)

## H5支付

	 WxPay.H5Pay(订单号,支付金额,微信支付商户号,商品描述,附加数据，异步回调地址,同步回调地址,分账配置单号,是否自动分账,自动分账节点,商户密钥)	 

## APP支付

	 WxPay.appPay(开放平台APPID,订单号,支付金额,微信支付商户号,商品描述,附加数据，异步回调地址,分账配置单号,是否自动分账,自动分账节点,商户密钥)

## 订单查询

	WxPay.getOrderInfoByOutTradeNo(订单号, 微信支付商户号, 商户密钥);

## 发起退款

	WxPay.orderRefund(订单号, 微信支付商户号, 退款金额, 商户密钥);

## 查询微信支付退款结果

	WxPay.getRefundResult(退款单号（发起退款接口返回）,微信支付商户号, 商户密钥);

## 获取微信授权URL

	WxPay.getWxOauthUrl(额外参数json字符串,授权结束后返回地址);

## 查询微信授权信息

	WxPay.getWxOauthInfo(授权结束后返回的code);

## 支付宝扫码支付

	AliPay.nativePay(订单号,支付金额,支付宝商户号,商品描述,返回类型，附加数据，异步回调地址,同步回调地址,商户密钥);

## 支付宝WAP支付

	AliPay.wapPay(订单号,支付金额,支付宝商户号,商品描述,附加数据，异步回调地址,商户密钥);

## 发起支付宝退款

	AliPay.orderRefund(订单号, 支付宝商户号, 退款金额, 退款描述,商户密钥);

## 查询支付宝退款结果

	WxPay.getRefundResult(退款单号（发起退款接口返回）,支付宝商户号, 商户密钥);



​	
​	