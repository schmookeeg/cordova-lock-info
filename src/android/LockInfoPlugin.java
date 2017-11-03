package com.vghaisas.cordova.plugin.lockinfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.KeyguardManager;
import android.os.PowerManager;
import android.content.Context;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

public class LockInfoPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("isLocked")) {
            this.isLocked(callbackContext);
            return true;
        }
        if (action.equals("isScreen")) {
            this.isScreen(callbackContext);
            return true;
        }
        return false;
    }

    public void isLocked(CallbackContext context) {
        KeyguardManager kgMgr = (KeyguardManager) this.cordova.getActivity()
            .getApplicationContext()
            .getSystemService(Context.KEYGUARD_SERVICE);
        boolean result = kgMgr.inKeyguardRestrictedInputMode();
        context.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
    }

    public void isScreen(CallbackContext context) {
        PowerManager pm = (PowerManager) this.cordova.getActivity()
            .getApplicationContext()
            .getSystemService(Context.POWER_SERVICE);
        boolean result = pm.isInteractive();

        context.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
    }
}
