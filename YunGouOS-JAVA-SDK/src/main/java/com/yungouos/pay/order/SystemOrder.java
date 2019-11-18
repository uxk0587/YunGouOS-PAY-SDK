package com.yungouos.pay.order;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.yungouos.pay.config.OrderApiConfig;
import com.yungouos.pay.entity.PayOrder;
import com.yungouos.pay.util.PaySignUtil;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;

/**
 *
 * YunGouOS订单相关API对接
 * 
 * @author YunGouOS技术部-029
 *
 *
 */
public class SystemOrder {

	/**
	 * 查询订单
	 * 
	 * @param out_trade_no
	 *            订单号
	 * @param mch_id
	 *            支付商户号
	 * @param key
	 *            商户密钥 登录YunGouOS.com-》我的账户-》账户中心 查看密钥
	 * @return WxPayOrder订单对象
	 *         参考文档：http://open.pay.yungouos.com/#/api/api/pay/wxpay/getWxPayOrderInfo
	 */
	public static PayOrder getOrderInfoByOutTradeNo(String out_trade_no, String mch_id, String key) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		PayOrder payOrder = null;
		try {
			if (StrUtil.isBlank(out_trade_no)) {
				throw new Exception("订单号不能为空！");
			}
			if (StrUtil.isBlank(mch_id)) {
				throw new Exception("商户号不能为空！");
			}
			if (StrUtil.isBlank(key)) {
				throw new Exception("商户密钥不能为空！");
			}
			params.put("out_trade_no", out_trade_no);
			params.put("mch_id", mch_id);
			// 上述必传参数签名
			String sign = PaySignUtil.createSign(params, key);
			params.put("sign", sign);
			String result = HttpRequest.get(OrderApiConfig.getOrderUrl).form(params).execute().body();
			if (StrUtil.isBlank(result)) {
				throw new Exception("API接口返回为空，请联系客服");
			}
			JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
			if (jsonObject == null) {
				throw new Exception("API结果转换错误");
			}
			Integer code = jsonObject.getInteger("code");
			if (0 != code.intValue()) {
				throw new Exception(jsonObject.getString("msg"));
			}
			JSONObject json = jsonObject.getJSONObject("data");
			if (json == null) {
				throw new Exception("API结果数据转换错误");
			}
			payOrder = JSONObject.toJavaObject(json, PayOrder.class);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return payOrder;
	}
}