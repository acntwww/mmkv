package me.reezy.cosmo.mmkv.demo

import me.reezy.cosmo.mmkv.*

// Demo class showing usage of MMKV Kotlin delegate properties
class MMKVDemo {
    
    // Basic value types with defaults
    private var isFirstLaunch by mmkvBoolean(true)
    private var userAge by mmkvInt(0)
    private var userScore by mmkvLong(0L)
    private var userRating by mmkvFloat(0.0f)
    private var userBalance by mmkvDouble(0.0)
    
    // String types
    private var userName by mmkvString("guest")
    private var userTags by mmkvStringSet(emptySet())
    private var userData by mmkvBytes(byteArrayOf())
    
    // Nullable types
    private var optionalName by mmkvNullableString()
    private var optionalTags by mmkvNullableStringSet()
    private var optionalData by mmkvNullableBytes()
    
    fun demo() {
        println("MMKV Kotlin Demo")
        
        // Demonstrate basic usage
        println("Initial isFirstLaunch: $isFirstLaunch")
        isFirstLaunch = false
        println("Updated isFirstLaunch: $isFirstLaunch")
        
        // Demonstrate other types
        userName = "John Doe"
        userAge = 25
        userScore = 1000L
        userRating = 4.5f
        userBalance = 999.99
        
        println("User: $userName, Age: $userAge, Score: $userScore")
        println("Rating: $userRating, Balance: $userBalance")
        
        // Demonstrate collections
        userTags = setOf("developer", "kotlin", "android")
        println("User tags: $userTags")
        
        // Demonstrate nullable types
        optionalName = "Optional Name"
        println("Optional name: $optionalName")
        
        optionalName = null
        println("Optional name after null: $optionalName")
    }
}

// Custom MMKV instance example
object UserPreferences : MMKVOwner {
    override val mmkv = com.tencent.mmkv.MMKV.mmkvWithID("user_prefs")
    
    var username by mmkvString("guest")
    var loginCount by mmkvInt(0)
    var isLoggedIn by mmkvBoolean(false)
}