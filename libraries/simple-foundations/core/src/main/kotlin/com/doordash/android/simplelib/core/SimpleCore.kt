package com.dgoliy.android.simplelib.core

import android.util.Log
import com.dgoliy.android.simplelib.core.data.SimpleCoreConfig

/**
 * Demonstration of a simple module.
 */
class SimpleCore {
    private var coreString: String = "coreStringDefault"
    /**
     * Initializes the module with a core string.
     */
    fun init(coreString: String, config: SimpleCoreConfig) {
        Log.d("SimpleCore", "init coreString: $coreString")
        Log.i("SimpleCore", "init config: $config")
        this.coreString = coreString
    }

    /**
     * Returns the core string.
     */
    fun getCoreString(): String {
        return coreString
    }

    /**
     * Returns the module name.
     */
    fun getModuleName(): String {
        return "SimpleCore"
    }
}
