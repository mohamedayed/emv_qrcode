package com.nizk.qrcodelib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nizk.emv_qrcode.EmvQrCodeDecoder
import com.nizk.qrcodelib.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val decoder = EmvQrCodeDecoder(Constants.qrcode)
        val data = decoder.decode()
        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ListItemAdapter(data)
        }

        super.onCreate(savedInstanceState)


    }
}