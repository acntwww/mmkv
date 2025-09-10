package me.reezy.cosmo.mmkv

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// Mock Parcelable interface for JVM-only demo
interface Parcelable

class MMKVParcelable<T : Parcelable>(private val clazz: Class<T>, private val default: T) : ReadWriteProperty<Any, T> {

    override operator fun getValue(thisRef: Any, property: KProperty<*>): T {
        // For JVM demo, just return default value
        return default
    }

    override operator fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        // For JVM demo, this is a no-op
    }
}