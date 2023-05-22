package com.hornyun.blog.util;

import com.hornyun.blog.exception.BlogBaseException;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * uuid generate util
 *
 * @author hornyun
 * created on 2023/05/21
 */
@SuppressWarnings("unused")
@Slf4j
public class UUIDUtils {
    private static SecureRandom secureRandom = null;
    private static String netAddressHexStr = null;
    private static final String PORT_HEX = "0000";
    private static final byte[] ADDRESS_BYTES;

    static {
        try {
            ADDRESS_BYTES = InetAddress.getLocalHost().getAddress();
        } catch (UnknownHostException e) {
            throw new BlogBaseException(e);
        }
    }


    private static int nextSeq32767 = 0;
    private static int nextSeq999 = 0;
    private static final char[] RADIX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private UUIDUtils() {
    }

    public static String getStringValue() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String generate() {
        return getSystemMillisRadix32() +
                getSeqRadix32() +
                obtainNetAddressHexStr() +
                PORT_HEX +
                toHex(getRandom());
    }

    public static long getUniqueLong() {
        long longValue = System.currentTimeMillis();
        longValue *= 1000000L;
        long ipv4LastNumber = ((ADDRESS_BYTES[3] & 255) * 1000);
        longValue = longValue + ipv4LastNumber + getSeq999();
        return longValue;
    }

    private static String getSystemMillisRadix32() {
        String millisStr = Long.toString(System.currentTimeMillis(), 32).toUpperCase();
        int len = millisStr.length();
        if (len < 9) {
            StringBuilder buffer = new StringBuilder(10);
            buffer.append(millisStr);
            int offset = 9 - len;

            for (int i = 0; i < offset; ++i) {
                buffer.append("0");
            }

            millisStr = buffer.toString();
        } else if (len > 9) {
            millisStr = millisStr.substring(len - 9);
        }

        return millisStr;
    }

    private static synchronized int getRandom() {
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }

        return secureRandom.nextInt();
    }

    private static String toHex(int value) {
        StringBuilder buffer = new StringBuilder(8);
        int shift = 8 - 1 << 2;
        int kk = -1;

        while (true) {
            ++kk;
            if (kk >= 8) {
                return buffer.toString();
            }

            buffer.append(RADIX_DIGITS[value >> shift & 15]);
            value <<= 4;
        }
    }

    private static int toInt() {
        int value = 0;
        int aryLen = UUIDUtils.ADDRESS_BYTES.length;

        for (int i = aryLen - 1; i >= 0; --i) {
            value <<= 8;
            value |= UUIDUtils.ADDRESS_BYTES[i] & 255;
        }

        return value;
    }

    private static synchronized int getSeq32767() {
        int result = nextSeq32767++;
        if (nextSeq32767 >= 32768) {
            nextSeq32767 = 0;
        }

        return result;
    }

    private static String getSeqRadix32() {
        String seqStr = Long.toString(getSeq32767(), 32).toUpperCase();
        int len = seqStr.length();
        if (len < 3) {
            StringBuilder buffer = new StringBuilder(3);
            int offset = 3 - len;

            for (int i = 0; i < offset; ++i) {
                buffer.append("0");
            }

            buffer.append(seqStr);
            seqStr = buffer.toString();
        } else if (len > 3) {
            seqStr = seqStr.substring(len - 3);
        }

        return seqStr;
    }

    private static synchronized int getSeq999() {
        int retValue = nextSeq999++;
        if (nextSeq999 >= 1000) {
            nextSeq999 = 0;
        }

        return retValue;
    }

    private static String obtainNetAddressHexStr() {
        if (netAddressHexStr == null) {
            netAddressHexStr = toHex(toInt());
        }
        return netAddressHexStr;
    }
}
