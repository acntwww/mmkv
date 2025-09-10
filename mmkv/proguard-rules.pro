# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Keep MMKV related classes
-keep class com.tencent.mmkv.** { *; }
-keep class me.reezy.cosmo.mmkv.** { *; }