package com.centaury.tourismapp.maps

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.centaury.core.data.Resource
import com.centaury.core.domain.model.Tourism
import com.centaury.tourismapp.detail.DetailTourismActivity
import com.centaury.tourismapp.di.MapsModuleDependencies
import com.centaury.tourismapp.maps.databinding.ActivityMapsBinding
import com.google.gson.Gson
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.geometry.LatLngBounds
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class MapsActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val mapsViewModel: MapsViewModel by viewModels {
        factory
    }
    private lateinit var binding: ActivityMapsBinding
    private lateinit var mapBoxMap: MapboxMap

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMapsComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    MapsModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)

        Mapbox.getInstance(this, BuildConfig.MAPBOX_ACCESS_TOKEN)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Tourism App"

        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync { mapboxMap ->
            this.mapBoxMap = mapboxMap
            getTourismData()
        }
    }

    private fun getTourismData() {
        mapsViewModel.tourism.observe(this) { tourism ->
            if (tourism != null) {
                when (tourism) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        showMaker(tourism.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = tourism.message
                    }
                }
            }
        }
    }

    private fun showMaker(dataTourism: List<Tourism>?) {
        mapBoxMap.setStyle(Style.MAPBOX_STREETS) { style ->
            style.addImage(ICON_ID, BitmapFactory.decodeResource(resources, R.drawable.mapbox_marker_icon_default))
            val latLngBoundsBuilder = LatLngBounds.Builder()

            val symbolManager = SymbolManager(binding.mapView, mapBoxMap, style)
            symbolManager.iconAllowOverlap = true

            val options = ArrayList<SymbolOptions>()
            dataTourism?.forEach { data ->
                latLngBoundsBuilder.include(LatLng(data.latitude, data.longitude))
                options.add(
                        SymbolOptions()
                                .withLatLng(LatLng(data.latitude, data.longitude))
                                .withIconImage(ICON_ID)
                                .withData(Gson().toJsonTree(data))
                )
            }
            symbolManager.create(options)

            val latLngBounds = latLngBoundsBuilder.build()
            mapBoxMap.easeCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 50), 5000)

            symbolManager.addClickListener { symbol ->
                val data = Gson().fromJson(symbol.data, Tourism::class.java)
                val intent = Intent(this, DetailTourismActivity::class.java)
                intent.putExtra(DetailTourismActivity.EXTRA_DATA, data)
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    companion object {
        private const val ICON_ID = "ICON_ID"
    }
}