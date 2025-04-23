package com.dgoliy.android.simplelib

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.dgoliy.android.module2.SimpleModule2
import com.dgoliy.android.simplelib.databinding.ActivityMainBinding
import com.dgoliy.android.simplelib.module1.SimpleModule1
import com.dgoliy.android.simplelib.module1.data.SimpleModule1Config

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val simpleModule1 = SimpleModule1()
    private val simpleModule2 = SimpleModule2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        simpleModule1.init(
            dummyString = "Hello from SimpleLib Sandbox Module1!",
            config = SimpleModule1Config(
                dummyInt = 123,
                dummyBoolean = true,
                dummyString = "config dummy string!!"
            ),
        )
        simpleModule2.init(
            dummyStringModule2 = "Hello from SimpleLib Sandbox Module2!"
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "What's the SimpleLib Module attached?", Snackbar.LENGTH_LONG)
                .setAction("Check") {
                    Toast.makeText(this, simpleModule1.getModuleName(), Toast.LENGTH_SHORT)
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
