package com.nizk.qrcodelib

import android.view.LayoutInflater
import android.view.LayoutInflater.*
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nizk.emv_qrcode.MPMEmvQrCodeData
import com.nizk.qrcodelib.databinding.ItemListBinding


class ListItemAdapter(private val item: MPMEmvQrCodeData) : RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item)
    }

    override fun getItemCount(): Int = 1

    class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: MPMEmvQrCodeData) {
            val details = buildString {
                append("Merchant Name: ${data.merchantName ?: "N/A"}\n")
                append("Payload Format Indicator: ${data.payloadFormatIndicator ?: "N/A"}\n")
                append("Point of Initiation Method: ${data.pointOfInitiationMethod ?: "N/A"}\n")
                append("Merchant Category Code: ${data.merchantCategoryCode ?: "N/A"}\n")
                append("Transaction Currency: ${data.transactionCurrency ?: "N/A"}\n")
                append("Transaction Amount: ${data.transactionAmount ?: "N/A"}\n")
                append("Country Code: ${data.countryCode ?: "N/A"}\n")
                append("Merchant City: ${data.merchantCity ?: "N/A"}\n")
                append("Postal Code: ${data.postalCode ?: "N/A"}\n")

                data.merchantAccountInformation?.forEach { (key, value) ->
                    append("${key.name}: $value\n")
                }
                data.additionalDataFieldTemplate?.forEach { (key, value) ->
                    append("${key.name}: $value\n")
                }
                data.merchantInformationLanguage?.forEach { (key, value) ->
                    append("${key.name}: $value\n")
                }

                append("CRC: ${data.crc ?: "N/A"}")
            }

            binding.item.text = details
        }
    }
}