package com.school.cbis.util;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;
import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;

/**
 * Created by lenovo on 2016-05-19.
 */
public class CaptchaServiceSingleton {

    private static ImageCaptchaService instance = new DefaultManageableImageCaptchaService(new FastHashMapCaptchaStore(), new GMailEngine(), 180, 100000,75000);

    public static ImageCaptchaService getInstance(){
        return instance;
    }
}
