package com.example.segundoandroidavanzado.presentation.detail

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.segundoandroidavanzado.databinding.FragmentDetailBinding
import com.example.segundoandroidavanzado.domain.model.LocationModel
import com.google.android.gms.location.LocationServices
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModel()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDetailBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Detail", args.heroId)
        detailViewModel.getData(args.heroId)
        detailViewModel.hero.observe(viewLifecycleOwner) { hero ->
            binding.name.text = hero.name
            binding.description.text = hero.description
            //TODO binding.description =hero.description
            Glide.with(binding.root.context)
                .load(hero.photoUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.ivImagen)
        }
        detailViewModel.location.observe(viewLifecycleOwner) { location ->
            binding.tvLocation.text = "Latitud: ${location.latitud}, Longitud: ${location.longitud}"
        }
    }

    private fun hasPermissions(context: Context) = ActivityCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED


    @SuppressLint("MissingPermission")
    private fun getLocation(context: Context) {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

        fusedLocationClient.lastLocation.addOnCompleteListener { result ->
            val lat = result.result?.latitude
            val long = result.result?.longitude

            if (result.isSuccessful && lat!= null && long!= null) {
                Log.d("DetailFRagment", "Lat: $lat | Long: $long")
            }
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)

        val hasPermission = hasPermissions(context)

        if (hasPermission) {
            getLocation(context)
        } else {
            val permissionLauncher = registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted ->
                if (isGranted) {
                    getLocation(context)
                } else {
                    Toast.makeText(
                        context,
                        "No se puede acceder a la ubicacion",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }

    }
}