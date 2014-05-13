package com.personalcrm.tools;

import java.security.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class Util {

    public enum errorRequest {
        error_connex_database, error_result, error_param
    }
    public enum RequestMethod {
        GET, POST
    }

    public String md5(String in)
    {
        MessageDigest digest;
        try
        {
            digest = MessageDigest.getInstance("MD5");
            digest.reset();
            digest.update(in.getBytes());
            byte[] a = digest.digest();
            int len = a.length;
            StringBuilder sb = new StringBuilder(len << 1);
            for (int i = 0; i < len; i++)
            {
                sb.append(Character.forDigit((a[i] & 0xf0) >> 4, 16));
                sb.append(Character.forDigit(a[i] & 0x0f, 16));
            }
            return sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static String textDateNow() {
        Locale locale = Locale.FRANCE;
        Date actuelle = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMM yyyy", locale);
        String dat = dateFormat.format(actuelle);

        return dat;
    }

}
