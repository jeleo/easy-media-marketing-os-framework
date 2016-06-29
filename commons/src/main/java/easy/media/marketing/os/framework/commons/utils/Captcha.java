package easy.media.marketing.os.framework.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码工具类
 */
public class Captcha {

    private static final Logger logger = LoggerFactory.getLogger(Captcha.class);

    public static final String SESSION_KEY_OF_CAPTCHA_DEFAULT = "loginCaptcha";

    /**
     * 定义图形大小
     */
    private static final int width = 105;
    /**
     * 定义图形大小
     */
    private static final int height = 35;

    /**
     * 干扰线的长度=1.414*lineWidth
     */
    private static final int lineWidth = 2;

    /**
     * 干扰线数量
     */
    private static final int count = 200;

    private static final int randCodeLength = 4;

    private static final int randCodeType = RandCodeImageEnum.ALL_CHAR.number;

    public static void handle(final HttpServletRequest request, final HttpServletResponse response) {
        handle(request, response, SESSION_KEY_OF_CAPTCHA_DEFAULT);
    }

    public static void handle(final HttpServletRequest request, final HttpServletResponse response, String captchaSessionKey) {
        // 设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 在内存中创建图象
        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        final Graphics2D graphics = (Graphics2D) image.getGraphics();

        // 设定背景颜色
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        // 设定边框颜色
        graphics.drawRect(0, 0, width - 1, height - 1);

        final Random random = new Random();
        // 随机产生干扰线，使图象中的认证码不易被其它程序探测到
        for (int i = 0; i < count; i++) {
            graphics.setColor(getRandColor(150, 200));

            final int x = random.nextInt(width - lineWidth - 1) + 1; // 保证画在边框之内
            final int y = random.nextInt(height - lineWidth - 1) + 1;
            final int xl = random.nextInt(lineWidth);
            final int yl = random.nextInt(lineWidth);
            graphics.drawLine(x, y, x + xl, y + yl);
        }

        // 取随机产生的认证码(4位数字)
        final String resultCode = generateRandCode(randCodeType);
        for (int i = 0; i < resultCode.length(); i++) {
            // 设置字体颜色
            graphics.setColor(Color.BLACK);
            // 设置字体样式
            graphics.setFont(new Font("Times New Roman", Font.BOLD, 24));
            // 设置字符，字符间距，上边距
            graphics.drawString(String.valueOf(resultCode.charAt(i)), (23 * i) + 8, 26);
        }

        // 将认证码存入SESSION
        storeCaptchaToSession(request, captchaSessionKey, resultCode);
        // 图象生效
        graphics.dispose();

        // 输出图象到页面
        try {
            ImageIO.write(image, PictureUtil.PICTRUE_FORMATE_JPG, response.getOutputStream());
        } catch (IOException e) {
            logger.error("输入验证码失败", e);
        }
    }

    public static void storeCaptchaToSession(final HttpServletRequest request, String captchaSessionKey, String captcha) {
        // 将认证码存入SESSION
        request.getSession().setAttribute(captchaSessionKey, captcha);
    }

    private static Color getRandColor(int fc, int bc) {
        // 取得给定范围随机颜色
        final Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }

        final int r = fc + random.nextInt(bc - fc);
        final int g = fc + random.nextInt(bc - fc);
        final int b = fc + random.nextInt(bc - fc);

        return new Color(r, g, b);
    }

    public static String generateRandCode(Integer randCodeType) {
        if (randCodeType == null) {
            return RandCodeImageEnum.NUMBER_CHAR.generateStr(randCodeLength);
        } else {
            switch (randCodeType) {
                case 1:
                    return RandCodeImageEnum.NUMBER_CHAR.generateStr(randCodeLength);
                case 2:
                    return RandCodeImageEnum.LOWER_CHAR.generateStr(randCodeLength);
                case 3:
                    return RandCodeImageEnum.UPPER_CHAR.generateStr(randCodeLength);
                case 4:
                    return RandCodeImageEnum.LETTER_CHAR.generateStr(randCodeLength);
                case 5:
                    return RandCodeImageEnum.ALL_CHAR.generateStr(randCodeLength);

                default:
                    return RandCodeImageEnum.NUMBER_CHAR.generateStr(randCodeLength);
            }
        }
    }

    /**
     * 验证码辅助类
     */
    private enum RandCodeImageEnum {
        /**
         * 数字
         */
        NUMBER_CHAR(1, "0123456789"),
        /**
         * 小写字母
         */
        LOWER_CHAR(2, "abcdefghijklmnopqrstuvwxyz"),
        /**
         * 大写字符
         */
        UPPER_CHAR(3, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
        /**
         * 字符
         */
        LETTER_CHAR(4, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
        /**
         * 混合字符串
         */
        ALL_CHAR(5, "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");

        /**
         * 待生成的字符串
         */
        private String charStr;

        private int number;

        RandCodeImageEnum(int number, String charStr) {
            this.number = number;
            this.charStr = charStr;
        }


        /**
         * 生产随机验证码
         */
        public String generateStr(final int codeLength) {
            final StringBuilder sb = new StringBuilder();
            final Random random = new Random();
            final String sourseStr = getCharStr();

            for (int i = 0; i < codeLength; i++) {
                sb.append(sourseStr.charAt(random.nextInt(sourseStr.length())));
            }

            return sb.toString();
        }

        public String getCharStr() {
            return charStr;
        }

    }

}
