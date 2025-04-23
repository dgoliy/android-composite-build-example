package com.dgoliy.android.module2

import android.util.Log

/**
 * Demonstration of a simple module.
 */
class SimpleModule2 {
    private var dummyString: String = "dummyString_Module2"

    /**
     * Initializes the module with a dummy string.
     */
    fun init(dummyStringModule2: String) {
        Log.d("SimpleModule1", "init dummyString: $dummyStringModule2")
        this.dummyString = dummyStringModule2
    }

    /**
     * Returns the dummy string.
     */
    fun getDummyString(): String {
        return dummyString
    }

    /**
     * Returns the module name.
     */
    fun getModuleName(): String {
        return "SimpleModule2"
    }
}
