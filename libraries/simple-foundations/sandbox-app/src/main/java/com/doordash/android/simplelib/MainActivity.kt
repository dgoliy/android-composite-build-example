package com.dgoliy.android.simplelib

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.dgoliy.android.simplelib.databinding.ActivityMainBinding
import com.dgoliy.android.simplelib.core.SimpleCore
import com.dgoliy.android.simplelib.core.data.SimpleCoreConfig
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val simpleCore = SimpleCore()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        simpleCore.init(
            coreString = "Hello from SimpleLib Sandbox Module1!",
            config = SimpleCoreConfig(
                configInt = 123,
                configBoolean = true,
                configCoreString = "config string assigned by the app!!"
            ),
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "What's the SimpleCore Module attached?", Snackbar.LENGTH_LONG)
                .setAction("Check") {
                    Toast.makeText(this, simpleCore.getModuleName(), Toast.LENGTH_SHORT)
                        .show()
                }
                .setAnchorView(R.id.fab).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
