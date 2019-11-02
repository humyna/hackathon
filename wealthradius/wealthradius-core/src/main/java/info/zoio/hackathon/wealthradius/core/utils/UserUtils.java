package info.zoio.hackathon.wealthradius.core.utils;

import java.util.regex.Pattern;

/**
 *
 * 类名: UserUtils <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 */
public class UserUtils {
    private final static Pattern PATTERN_MOBILE = Pattern.compile("^((13)|(14)|(15)|(16)|(17)|(18)|(19))\\d{9}$");

    /**
     * 
     * isMobile:判断是否为手机. <br/>
     * 
     * @param mobileNo
     * @return
     * boolean
     * @exception
     * @author Finn
     */
    public static boolean isMobile(String mobileNo) {
        return (mobileNo == null ? false : PATTERN_MOBILE.matcher(mobileNo).matches());
    }
}
