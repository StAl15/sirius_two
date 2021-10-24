package harshbarash.github.siriustwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import harshbarash.github.siriustwo.databinding.ActivityMainBinding
import harshbarash.github.siriustwo.onboarding.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_container
        ) as NavHostFragment
        navController = navHostFragment.navController

        // Setup the bottom navigation view with navController
        val navigationView = findViewById<BottomNavigationView>(R.id.bottom_main)
        navigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.viewPagerFragment || destination.id == R.id.splashFragment || destination.id == R.id.dataFragment
                || destination.id == R.id.adressFragment || destination.id == R.id.payFragment || destination.id == R.id.roomFragment
                || destination.id == R.id.additionallyFragment || destination.id == R.id.orderFragment) {
                navigationView.visibility = View.GONE
            } else {
                navigationView.visibility = View.VISIBLE
            }
        }
    }

}