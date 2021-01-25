package ru.trinitydigital.errorhandling.ui

import android.os.Bundle
import android.widget.Toast
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.trinitydigital.errorhandling.R
import ru.trinitydigital.errorhandling.common.BaseActivity

class MainActivity : BaseActivity() {

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm.loadUser()
        setupViewModel()
    }

    private fun setupViewModel() {
        super.setupViewModel(vm)
        vm.user.observe(this, {
            Toast.makeText(this, it.getFullUserName(), Toast.LENGTH_LONG).show()
        })
    }
}