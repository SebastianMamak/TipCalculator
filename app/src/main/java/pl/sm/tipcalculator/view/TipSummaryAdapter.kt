package pl.sm.tipcalculator.view

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.sm.tipcalculator.R
import pl.sm.tipcalculator.databinding.SavedTipCalculationListItemBinding
import pl.sm.tipcalculator.viewmodel.TipCalculationSummaryItem

class TipSummaryAdapter(val onItemSelected: (item: TipCalculationSummaryItem) -> Unit) : RecyclerView.Adapter<TipSummaryAdapter.TipSummaryViewHolder>() {

    private val tipCalculationSummmaries = mutableListOf<TipCalculationSummaryItem>()

    fun updateList(updates: List<TipCalculationSummaryItem>) {
        tipCalculationSummmaries.clear()
        tipCalculationSummmaries.addAll(updates)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipSummaryViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<SavedTipCalculationListItemBinding>(
                inflater, R.layout.saved_tip_calculation_list_item, parent, false)

        return TipSummaryViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return tipCalculationSummmaries.size
    }

    override fun onBindViewHolder(holder: TipSummaryViewHolder, position: Int) {
        holder.bind(tipCalculationSummmaries[position])
    }

    inner class TipSummaryViewHolder(val binding: SavedTipCalculationListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TipCalculationSummaryItem) {
            binding.item = item
            binding.root.setOnClickListener {onItemSelected(item)}
            binding.executePendingBindings()
        }

    }

}