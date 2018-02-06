package pe.android.com.mvp_clean.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.CountDownTimer;
import android.os.Environment;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import pe.android.com.mvp_clean.R;
import pe.android.com.mvp_clean.view.dialog.DialogView;
import pe.android.com.mvp_clean.view.widget.ToastCustom;

/**
 * Created by jsaenz on 1/2/2018.
 */

public class CommonUtil {

    public static String[] obtenerPermisos(Context context) {
        try {
            return context
                    .getPackageManager()
                    .getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS)
                    .requestedPermissions;
        } catch (Exception e) {
            throw new RuntimeException("This should have never happened.", e);
        }
    }

    public static void mostrarToast(Context context, String mensaje) {
        final ToastCustom toastCustom = ToastCustom.makeText(context, mensaje, Toast.LENGTH_SHORT);
        toastCustom.show();

        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
                toastCustom.show();
            }

            public void onFinish() {
                toastCustom.cancel();
            }
        }.start();
    }

    /**
     *
     * @param context
     * @param mensaje
     * @param tipoMensaje ToastCustom.TYPE_CORRECTO/TYPE_ERROR/TYPE_INFO
     */

    public static void mostrarToast(Context context, String mensaje, int tipoMensaje) {
        final ToastCustom toastCustom = new ToastCustom(context, mensaje, tipoMensaje);
        toastCustom.show();

        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
                toastCustom.show();
            }

            public void onFinish() {
                toastCustom.cancel();
            }
        }.start();
    }

    public static void exportarBD(Context context) {
        try {
            configExportBD(context, context.getString(R.string.name_bd));
            CommonUtil.mostrarToast(context, "Exportacion de BD exitosa", ToastCustom.TYPE_CORRECTO);
        } catch (Exception e) {
            CommonUtil.mostrarToast(context, "Error en la aplicación" + e != null ? e.getMessage() : e + "", ToastCustom.TYPE_ERROR);
        }
    }

    public static void configExportBD(Context ioContext, String baseDatos) throws IOException {

        File dbFile = new File(Environment.getDataDirectory() + "/data/" + ioContext.getApplicationContext().getPackageName() + "/databases/" + baseDatos);
        File exportDir = new File(Environment.getExternalStorageDirectory(), "");
        if (!exportDir.exists()) {
            exportDir.mkdirs();
        }
        File file = new File(exportDir, dbFile.getName());
        file.createNewFile();

        FileChannel inChannel = new FileInputStream(dbFile).getChannel();
        FileChannel outChannel = new FileOutputStream(file).getChannel();

        inChannel.transferTo(0, inChannel.size(), outChannel);

        if (inChannel != null)
            inChannel.close();
        if (outChannel != null)
            outChannel.close();
    }

    public static String fnBattery(Context var0) {
        return fnBattery(var0, 100);
    }

    public static String fnBattery(Context var0, int var1) {
        IntentFilter var2 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent var3 = var0.registerReceiver((BroadcastReceiver)null, var2);
        float var4 = (float)var3.getIntExtra("level", 0);
        float var5 = (float)var3.getIntExtra("scale", 0);
        int var6 = Math.round((float)var1 * var4 / var5);
        return "" + var6;
    }

    public static boolean getActivadoLocalizacion(final Activity context) {
        boolean permisoLocalizacion = true;
        LocationManager lm = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);

        } catch(Exception ex) {}

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch(Exception ex) {}

        if(!gps_enabled && !network_enabled) {
            permisoLocalizacion = false;

           DialogView.create(context).showBasicDialog(
                    context.getResources().getString(R.string.msg_app_title_localizacion_required),
                    context.getResources().getString(R.string.msg_app_localizacion_required),
                    context.getString(R.string.accept), new DialogView.OnSingleButton() {
                        @Override
                        public void onClick(@NonNull MaterialDialog poDialog) {
                            Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            context.startActivity(myIntent);
                        }
                    },
                    context.getString(R.string.cancel), new DialogView.OnSingleButton() {
                        @Override
                        public void onClick(@NonNull MaterialDialog poDialog) {

                        }
                    }
            ).setCanceledOnTouchOutside(false);
        }
        return permisoLocalizacion;
    }
}
