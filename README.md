# AppPrefsAndroid
Shared Preferences In Android || Store data in Shared Preference Android

In the Android, we can be storing data of an application using Shared Preferences. Shared Preferences allow us to save and retrieve data in the form of key and value pair.

First, we need to instance SharedPreference to save and retrieve the value from Shared Preference. you can get instance using getSharedPreferences()

String PREFERENCE = context.getString(R.string.app_name);
SharedPreferences appSharedPrefs = context.getSharedPreferences(PREFERENCE, Activity.MODE_PRIVATE);
The first parameter is the key and the second is the Mode. below we are sharing mode that we can use in SharedPreferences according to application requirement.

MODE_APPEND: Append the new preferences with the existing preferences.
MODE_ENABLE_WRITE_AHEAD_LOGGING: Enable write-ahead logging by default
MODE_MULTI_PRICESS: Modification of preferences even if the Shared Preference instance has already been loaded
MODE_PRIVATE: The file can only be accessed using calling application
MODE_WORLD_READABLE: Allow the other application to read the preferences
MODE_WORLD_WRITEABLE: Allow the other application to write the preferences

We have to create an instance of the SharedPreferences.Editor for the save something in the Shared Preferences

SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
There are methods available in the editor class that allows manipulation of data inside Shared Preferences.
apply(): Commit your changes back from editor to the SharedPreference object you are calling
putString(String key, String value): Save a string value in a preference editor
putInt(String key, int value): Save an integer value in a preference editor
putFloat(String key, float value): Save a float value in a preference editor
putLong(String key, long value): Save a long value in a preference editor
remove(String key): Remove the value whose key has been passed as a parameter
clear(): Remove all values from the editor

Save string in shared preferences
prefsEditor.putString(key, value).commit();
Retrieve string from Shared Preferences
appSharedPrefs.getString(key, "");
We can also save and retrieve an object from Shared Preferences. we have to add JSON Parse Library for the converted model object to JSON and JSON to model object.

Save an object in Shared Preferences
public void setUser(UserModel data) {
    Gson gson = new Gson();
    String json = gson.toJson(data);
    prefsEditor.putString("user_model", json).commit();
}
Retrieve an object from Shared Preferences
public UserModel getUser() {
    Gson gson = new Gson();
    String json = appSharedPrefs.getString("user_model", null);
    return gson.fromJson(json, UserModel.class);
}

Android Shared Preferences Example
https://tutorialstack.in/shared-preferences-in-android/
