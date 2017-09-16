package com.rest.api.model;

/**
 * 
 * @ClassName: SysCode   
 * @Description: 调用服务接口后返回的操作码 和 信息
 * @author yuting.li
 * @version 1.0 
 * @date 2017年9月16日 下午3:38:46
 */
public enum SysCode {
    // 成功代码：000000
    // 失败代码：111111
    
    SUCCESS("000000", "操作成功"),
    SUCCESS_WITH_WARN("000001", "操作成功，但有警告"),
    SUCCESS_BUT_FORBID("000002", "操作成功，提醒并禁止下一步操作"),
    FAIL("111111", "操作失败,请联系客服人员"),
    FAIL_WITH_TIPS("111112", "操作失败,提示具体信息"),
    SYS_PARAM_ERROR("200100", "参数错误"),
    BIS_MEMBER_LEVE_ID_NOT_FIND("100201", "没有符合条件的数据"),

	;
    
    private SysCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
    private String code;
    private String message;
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
