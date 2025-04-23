package com.dgoliy.android.simplelib.module1

import android.util.Log
import com.dgoliy.android.simplelib.module1.data.SimpleModule1Config
import com.dgoliy.android.simplelib.core.SimpleCore
import com.dgoliy.android.simplelib.core.data.SimpleCoreConfig

/**
 * Demonstration of a simple module.
 */
class SimpleModule1 {
    private var dummyString: String = "dummyString"
    private val simpleCore = SimpleCore()

    /**
     * Initializes the module with a dummy string.
     */
    fun init(dummyString: String, config: SimpleModule1Config) {
        Log.d("SimpleModule1", "init dummyString: $dummyString")
        Log.i("SimpleModule1", "init config: $config")
        this.dummyString = dummyString
        simpleCore.init(
            coreString = dummyString,
            config = SimpleCoreConfig(
                configCoreString = dummyString,
                configInt = config.dummyInt,
                configBoolean = config.dummyBoolean,
            ),
        )
    }

    /**
     * Returns the dummy string.
     */
    fun getDummyString(): String {
        return dummyString + "->" + simpleCore.getCoreString()
    }

    /**
     * Returns the module name.
     */
    fun getModuleName(): String {
        return "SimpleModule1->" + simpleCore.getModuleName()
    }
}
