package app.jetpack.navigation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import app.jetpack.navigation.R
import app.jetpack.navigation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setUpToolBar()
        setUpNavigation()
        setUpActionBar()
    }

    private fun setUpToolBar() {
        toolbar = binding.toolBar
        setSupportActionBar(toolbar)
        setSupportActionBarDisplayHome()
    }

    private fun setUpNavigation() {
        navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
        NavigationUI.setupWithNavController(binding.bottomNavigationBNV, navController)
    }

    private fun setUpActionBar() {
        appBarConfiguration = AppBarConfiguration.Builder().build()
        appBarConfiguration.topLevelDestinations
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == controller.graph.startDestination) {
                setSupportActionBarDisplayHome(false)
            } else {
                setSupportActionBarDisplayHome()
            }
        }

        /*navController.addOnDestinationChangedListener { controller, destination, arguments ->
            title = when (destination.id) {
                R.id.homeFragment -> "Home"
                R.id.studentFragment -> "Students"
                R.id.settingsFragment -> "Settings"
                R.id.studentDetailFragment -> "Detail"
                else -> "-"
            }
        }*/
    }

    private fun setSupportActionBarDisplayHome(status: Boolean = true) {
        supportActionBar?.setDisplayHomeAsUpEnabled(status)
        supportActionBar?.setHomeButtonEnabled(status)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}