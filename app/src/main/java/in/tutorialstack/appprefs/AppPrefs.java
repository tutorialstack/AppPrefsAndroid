package in.tutorialstack.appprefs;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class AppPrefs {
    private static String PREFERENCE;
    private static AppPrefs appPrefs;

    private SharedPreferences appSharedPrefs;
    private SharedPreferences.Editor prefsEditor;

    Context context;

    public AppPrefs(Context context) {
        this.context = context;
        PREFERENCE = context.getString(R.string.app_name);
        this.appSharedPrefs = context.getSharedPreferences(PREFERENCE, Activity.MODE_PRIVATE);
        this.prefsEditor = appSharedPrefs.edit();
    }

    public static AppPrefs getAppPrefs(Context context) {
        if (appPrefs == null) {
            appPrefs = new AppPrefs(context);
        }

        return appPrefs;
    }

    public void clearAllData() {
        prefsEditor.clear();
        prefsEditor.commit();
    }

    public void commit() {
        prefsEditor.commit();
    }

    public void setIsLogin(boolean isLogin) {
        prefsEditor.putBoolean("IsLogin", isLogin).commit();
    }

    public boolean getIsLogin() {
        return appSharedPrefs.getBoolean("IsLogin", false);
    }

    public void setString(String key, String value) {
        prefsEditor.putString(key, value).commit();
    }

    public String getString(String key) {
        return appSharedPrefs.getString(key, "");
    }

    public void setUser(UserModel data) {
        Gson gson = new Gson();
        String json = gson.toJson(data);
        prefsEditor.putString("user_model", json).commit();
    }

    public UserModel getUser() {
        Gson gson = new Gson();
        String json = appSharedPrefs.getString("user_model", null);
        return gson.fromJson(json, UserModel.class);
    }
}