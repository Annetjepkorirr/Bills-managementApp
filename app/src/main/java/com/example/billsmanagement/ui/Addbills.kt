package com.example.billsmanagement.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.CalendarView
import androidx.activity.viewModels
import com.example.billsmanagement.R
import com.example.billsmanagement.databinding.ActivityAddbillsBinding
import com.example.billsmanagement.viewModel.BillsViewModel
import java.util.Calendar

class Addbills : AppCompatActivity() {
    lateinit var binding: ActivityAddbillsBinding
     var selectedMonth = 0
    var selectedDate = 0
//    val billsViewModel:BillsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        setupFrequentSpinner()
//        setupDueDateSpinner()


    }
    private fun setupFrequentSpinner() {
        val frequencies = arrayOf("Weekly", "Monthly", "Annually")
        val freqAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, frequencies)
        freqAdapter
            .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spFrequency.adapter = freqAdapter
        binding.spFrequency.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (binding.spFrequency.selectedItem.toString()) {
                    "Weekly" -> {
                        hideDatePicker()
                        setUpDueDateSpinner(IntArray(7){it+1}.toTypedArray())

                    }

                    "Monthly" -> {
                       hideDatePicker()
                        setUpDueDateSpinner(IntArray(7){it+1}.toTypedArray())



                    }

                    "Annual" -> {
                       showDatePicker()
                        setUpDueDate()

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
    fun setUpDueDateSpinner(dates: Array<Int>){
        val duedateAdapter =ArrayAdapter(this, android.R.layout.simple_spinner_item, dates)
        duedateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spDuedate.adapter =duedateAdapter
    }

    fun showDatePicker(){
        binding.dpDuedate.show()
        binding.dpDuedate.hide()

    }

    fun hideDatePicker(){
        binding.dpDuedate.hide()
        binding.spDuedate.show()
    }

    fun setUpDueDate(){
        val calender = Calendar.getInstance()
        binding.dpDuedate.init(calender.get(Calendar.YEAR), calender.get(Calendar.MONTH),calender.get(Calendar.DAY_OF_MONTH)){
            view,year, month, date ->
            selectedMonth = month+1
            selectedDate = date

        }
    }

    fun View.show(){
       this.visibility =View.VISIBLE
    }

    fun View.hide(){
        this.visibility =View.VISIBLE
    }


}