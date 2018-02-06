package pe.android.com.mvp_clean.data.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

import java.io.File;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

/**
 * Created by jsaenz on 31/1/18.
 */

public final class CommonUtil {

    /**
     * Tag used on log messages.
     */
    static final String TAG = CommonUtil.class.getSimpleName();

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static String getImeiPhone(Context poContext) {
        TelephonyManager telephonyManager = (TelephonyManager) poContext
                .getSystemService(Context.TELEPHONY_SERVICE);

        return telephonyManager.getDeviceId() != null ? telephonyManager.getDeviceId() : "";
    }

    public static String getMacAddress(Context poContext) {
        String lsDefault = "00:00:00:00:00:00";
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                List<NetworkInterface> laoNetworkInterfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
                for (NetworkInterface loNetworkInterface : laoNetworkInterfaces) {
                    if (loNetworkInterface.getName().equalsIgnoreCase("wlan0")) {
                        byte[] labyHardwareAddress = loNetworkInterface.getHardwareAddress();
                        StringBuilder loStringBuilder = new StringBuilder();
                        for (byte lbyPair : labyHardwareAddress) {
                            loStringBuilder.append(Integer.toHexString(lbyPair & 0xFF) + ":");
                        }
                        if (loStringBuilder.length() > 0) {
                            loStringBuilder.deleteCharAt(loStringBuilder.length() - 1);
                        }
                        return loStringBuilder.toString();
                    }
                }
            } catch (Exception poException) {
                return lsDefault;
            }
        } else {
            try {
                WifiManager loWifiManager = (WifiManager) poContext.getSystemService(Context.WIFI_SERVICE);
                WifiInfo loWifiInfo = loWifiManager.getConnectionInfo();
                return loWifiInfo.getMacAddress();
            } catch (Exception poException) {
                return lsDefault;
            }
        }
        return lsDefault;
    }

    public static String getSimSerialNumber(Context poContext) {
        TelephonyManager telephonyManager = (TelephonyManager) poContext
                .getSystemService(Context.TELEPHONY_SERVICE);

        return telephonyManager.getSimSerialNumber() != null ? telephonyManager.getSimSerialNumber() : "";
    }

    public static double fnGetTrafficTotalMB() {
        long ilTotalRX = TrafficStats.getTotalRxBytes();
        long ilTotalTX = TrafficStats.getTotalTxBytes();
        long ilMobileRX = TrafficStats.getMobileRxBytes();
        long ilMobileTX = TrafficStats.getMobileTxBytes();

        long ilTotal = ilTotalRX + ilTotalTX + ilMobileRX + ilMobileTX;
        double ilTotalKB = ilTotal / 1024;
        double ilTotalMB = ilTotalKB / 1024;
        return ilTotalMB;
    }

    public static double fnGetTrafficTotalGB() {
        long ilTotalRX = TrafficStats.getTotalRxBytes();
        long ilTotalTX = TrafficStats.getTotalTxBytes();
        long ilMobileRX = TrafficStats.getMobileRxBytes();
        long ilMobileTX = TrafficStats.getMobileTxBytes();

        long ilTotal = ilTotalRX + ilTotalTX + ilMobileRX + ilMobileTX;
        double ilTotalKB = ilTotal / 1024;
        double ilTotalMB = ilTotalKB / 1024;
        double ilTotalGB = ilTotalMB / 1024;
        return ilTotalGB;
    }

    public static SpannableStringBuilder getSetErrorStyle(int ecolor, String estring) {
        ForegroundColorSpan fgcspan = new ForegroundColorSpan(ecolor);
        SpannableStringBuilder ssbuilder = new SpannableStringBuilder(estring);
        ssbuilder.setSpan(fgcspan, 0, estring.length(), 0);

        return ssbuilder;
    }

    public static int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);

            return packageInfo.versionCode;
        } catch (NameNotFoundException e) {
            throw new RuntimeException("Error al obtener version: " + e);
        }
    }

    public static void createDirectory(String directory) {
        File file = new File(directory);
        if (!file.exists())
            file.mkdirs();
    }

}
