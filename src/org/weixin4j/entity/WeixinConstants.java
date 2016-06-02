/**
 * <p>Copyright (c) 2014~, All rights reserved.<p>
 * <p>This java file created by chainren,you can copy or used it to anywhere after his authorization.
 * If you have any question,please contact chainren.Mail to:chainren@gmail.com.Thank's.<p>
 */
package org.weixin4j.entity;

/**
 * <p>
 * Description： weixin4j中用到的所有的常量
 * <p>
 * Company ：
 * <p>
 * Create Date： 2014年6月8日
 *
 * @author chainren
 * @version
 * @since JDK1.7
 *
 *
 */
public interface WeixinConstants {

	/**
	 * 发送请求到服务器的超时时长。如果在5s内服务器没有响应，则微信服务器会自动断开链接，并且重新发起请求，总共重试三次
	 */
	public static final int REQUEST_TIMEOUT = 5000;

	/**
	 * 所有的消息类型常量
	 */
	public static final String MSG_TYPE_TEXT = "text";
	public static final String MSG_TYPE_IMAGE = "image";
	public static final String MSG_TYPE_VOICE = "voice";
	public static final String MSG_TYPE_VIDEO = "video";
	public static final String MSG_TYPE_LOCATION = "location";
	public static final String MSG_TYPE_LINK = "link";
	public static final String MSG_TYPE_MUSIC = "music";
	/**
	 * 图文消息
	 */
	public static final String MSG_TYPE_NEWS = "news";
	/**
	 * 事件消息
	 */
	public static final String MSG_TYPE_EVENT = "event";

	/**
	 * 关注公众账号事件
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	/***
	 * 取消关注公众账号事件
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	/** 扫描二维码事件 **/
	public static final String EVENT_TYPE_SCAN = "scan";
	/** 上报地理位置事件 **/
	public static final String EVENT_TYPE_LOCATION = "location";
	/** 点击菜单拉取消息时的事件 **/
	public static final String EVENT_TYPE_CLICK = "CLICK";
	/** 点击菜单跳转链接事件 **/
	public static final String EVENT_TYPE_VIEW = "view";
	/** 扫码推事件 **/
	public static final String EVENT_TYPE_SCANCODE_PUSH = "scancode_push";
	/** 扫码推事件且弹出“消息接收中”提示框 **/
	public static final String EVENT_TYPE_SCANCODE_WAITMSG = "scancode_waitmsg";
	/** 弹出系统拍照发图 **/
	public static final String EVENT_TYPE_PIC_SYSPHOTO = "pic_sysphoto";
	/** 弹出拍照或者相册发图 **/
	public static final String EVENT_TYPE_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
	/** 弹出微信相册发图器 **/
	public static final String EVENT_TYPE_PIC_WEIXIN = "pic_weixin";
	/** 弹出地理位置选择器 **/
	public static final String EVENT_TYPE_LOCATION_SELECT = "location_select";
	/******************************************************************************/

	/**
	 * 编码方式，统一使用utf-8编码
	 */
	public static final String ENCODING = "UTF-8";

	/**
	 * POST请求方式
	 */
	public static final String REQUESTMETHOD_POST = "POST";

	/**
	 * GET请求方式
	 */
	public static final String REQUESTMETHOD_GET = "GET";

	/**
	 * access_token 有效时间，目前为7200s;
	 */
	public static final long EXPIRE_IN = 7200L;

	/**
	 * 接口替换字符 ACCESS_TOKENSS
	 */
	public static final String REPLACE_ACCESS_TOKEN = "ACCESS_TOKEN";

	/**
	 * 接口替换字符 APPID
	 */
	public static final String REPLACE_APPID = "APPID";

	/**
	 * 接口替换字符 APPSECRET
	 */
	public static final String REPLACE_APPSECRET = "APPSECRET";

	/**
	 * 接口替换字符 KFACCOUNT
	 */
	public static final String REPLACE_KFACCOUNT = "KFACCOUNT";

	/**
	 * 接口替换字符 REDIRECT_URI OAUTH2授权重定向url
	 */
	public static final String REPLACE_REDIRECT_URI = "REDIRECT_URI";

	/**
	 * 接口替换字符  SCOPE OAUTH2授权范围
	 */
	public static final String REPLACE_SCOPE = "SCOPE";

	/**
	 * 接口替换字符  STATE 重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
	 */
	public static final String REPLACE_STATE = "STATE";

	/**
	 * 接口替换字符  OAUTH2获取access_token接口中替换的CODE
	 */
	public static final String REPLACE_CODE = "CODE";

	/**
	 * 接口替换字符  OAUTH2获取access_token接口中替换的SECRET,微信接口不规范，应该提供统一的APPSECRET
	 */
	public static final String REPLACE_SECRET = "SECRET";

	/**
	 * 接口替换字符  刷新授权时替换REFRESH_TOKEN
	 */
	public static final String REPLACE_REFRESH_TOKEN = "REFRESH_TOKEN";

	/**
	 * 接口替换字符  OPENID
	 */
	public static final String REPLACE_OPENID="OPENID";

	/**
	 * 接口替换字符,二维码兑换 TICKET
	 */
	public static final String REPLACE_TICKET="TICKET";

	/**
	 * 接口替换字符 TOKEN
	 */
	public static final String REPLACE_TOKEN="TOKEN";
	/********************************************************************************/
	//全局返回码

	/**
	 * 系统繁忙
	 */
	public static final String RETURN_CODE_BUSY = "-1";
	/**
	 * 正确 OK
	 */
	public static final String RETURN_CODE_OK = "0";
	/********************************************************************************/

	//oauth2授权

	/**
	 * oauth2应用授权作用域 不弹出授权页面，直接跳转，只能获取用户openid
	 */
	public static final String OAUTH2_SCOPE_SNSAPI_BASE = "snsapi_base";

	/**
	 * oauth2应用授权作用域 弹出授权页面，可通过openid拿到昵称、性别、所在地
	 */
	public static final String OAUTH2_SCOPE_SNSAPI_USERINFO = "snsapi_userinfo";

	/********************************************************************************/

	/**
	 * 临时二维码请求 QR_SCENE
	 */
	public static final String QR_SCENE = "QR_SCENE";

	/**
	 * 永久二维码请求 QR_LIMIT_SCENE
	 */
	public static final String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";
}
