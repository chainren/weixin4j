/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 *
 */
package org.weixin4j.entity;

/**
 * <p>
 * Description： 微信接口url定义
 * <p>
 * Company ：
 * <p>
 * Create Date： 2015年1月29日
 * 
 * @author chainren
 * @version
 * @since JDK1.7
 * 
 * 
 */
public interface WeixinInterface {
	/**
	 * 获取凭证接口 get
	 */
	public static final String URL_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	/**
	 * 创建菜单的接口 https post
	 */
	public static final String URL_MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	/**
	 * 获取菜单 http get
	 */
	public static final String URL_MENU_GET = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	/**
	 * 删除菜单 http get
	 */
	public static final String URL_MENU_DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	/**
	 * 获取微信服务器Ip列表 get
	 */
	public static final String URL_IP_LIST = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";

	/**
	 * 客服接口-发送消息 post
	 */
	public static final String URL_KF_SEND = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	/**
	 * 添加客服帐号 post
	 */
	public static final String URL_KFACCOUNT_ADD = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";

	/**
	 * 修改客服帐号 post
	 */
	public static final String URL_KFACCOUNT_UPDATE = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";

	/**
	 * 删除客服帐号 get
	 */
	public static final String URL_KFACCOUNT_DEL = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN";

	/**
	 * 上传客服图像 post
	 */
	public static final String URL_KFACCOUNT_UPLOAD_HEADIMG = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";

	/**
	 * 获取客服列表 get
	 */
	public static final String URL_KFLIST_GET = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";

	/**
	 * 获取在线客服接待信息 get
	 */
	public static final String URL_KFONLINELIST_GET = "https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=ACCESS_TOKEN";

	/**
	 * 发送oauth2授权请求，用户同意授权，获取code get
	 */
	public static final String URL_OAUTH2_AUTHORIZE="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

	/**
	 * 获取到code后，获取oauth2的access_token,不同于其它接口的access_token
	 */
	public static final String URL_OAUTH2_ACCESS_TOKEN="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

	/**
	 * 刷新oauth2授权的access_token
	 */
	public static final String URL_OAUTH2_RERESH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";

	/**
	 * 拉取用户信息(需scope为 snsapi_userinfo) GET
	 */
	public static final String URL_OAUTH2_USERINFO = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	/**
	 * 检验授权凭证是否有效 get
	 */
	public static final String URL_OAUTH2_CHECK_AUTH = "https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";

	/**
	 * 创建二维码ticket POST
	 */
	public static final String URL_QRCODE_CREATE="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";

	/**
	 * 通过ticket换取二维码
	 */
	public static final String URL_QRCODE_SHOW="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";

	/**
	 * jsapi ticket接口
	 */
	public static final String URL_JSAPI_TICKET="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
}
