package com.tencent.mmkv

// Mock MMKV class for JVM-only demo
class MMKV {
    companion object {
        fun defaultMMKV(): MMKV = MMKV()
        
        fun mmkvWithID(mmapID: String): MMKV = MMKV()
    }
    
    fun decodeInt(key: String, defaultValue: Int = 0): Int = defaultValue
    fun decodeLong(key: String, defaultValue: Long = 0L): Long = defaultValue
    fun decodeFloat(key: String, defaultValue: Float = 0f): Float = defaultValue
    fun decodeDouble(key: String, defaultValue: Double = 0.0): Double = defaultValue
    fun decodeBool(key: String, defaultValue: Boolean = false): Boolean = defaultValue
    fun decodeString(key: String, defaultValue: String? = null): String? = defaultValue
    fun decodeStringSet(key: String, defaultValue: Set<String>? = null): Set<String>? = defaultValue
    fun decodeBytes(key: String, defaultValue: ByteArray? = null): ByteArray? = defaultValue
    
    fun encode(key: String, value: Int): Boolean = true
    fun encode(key: String, value: Long): Boolean = true
    fun encode(key: String, value: Float): Boolean = true
    fun encode(key: String, value: Double): Boolean = true
    fun encode(key: String, value: Boolean): Boolean = true
    fun encode(key: String, value: String?): Boolean = true
    fun encode(key: String, value: Set<String>?): Boolean = true
    fun encode(key: String, value: ByteArray?): Boolean = true
}