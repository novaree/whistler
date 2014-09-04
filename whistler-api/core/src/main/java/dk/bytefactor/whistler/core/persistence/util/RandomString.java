package dk.bytefactor.whistler.core.persistence.util;

import java.util.Random;

/**
 * Created by casper on 04/09/14.
 */
public class RandomString {
    public static String randomString( int len ) {
        Random rnd = new Random();
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890-!#€%&()=$<>;:,.";
        String out = "";
        for( int i = 0; i < len; i++ ) {
            out += chars.charAt(rnd.nextInt( chars.length() ));
        }
        return out;
    }
}
