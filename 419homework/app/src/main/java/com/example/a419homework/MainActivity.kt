package com.example.a419homework

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener, TextWatcher {
    private var output: TextView? = null
    private var txt: EditText? = null
    private var rg: RadioGroup? = null
    private var type: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get view objects
        output = findViewById<View>(R.id.lblOutput) as TextView
        rg = findViewById<View>(R.id.rgGender) as RadioGroup
        txt = findViewById<View>(R.id.txtName) as EditText
        type = findViewById<View>(R.id.type) as RadioGroup

        // Register listener objects
        rg!!.setOnCheckedChangeListener(this)
        type!!.setOnCheckedChangeListener(this)
        txt!!.addTextChangedListener(this)
    }

    override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

    override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
        show(type!!.checkedRadioButtonId)
    }

    override fun afterTextChanged(editable: Editable) {}

    override fun onCheckedChanged(radioGroup: RadioGroup, i: Int) {
        show(i)
    }

    fun show(i: Int) {
        // 取得選擇的票價
        var ticketPrice = 0
        when (i) {
            R.id.FFT -> ticketPrice = 500
            R.id.ST -> ticketPrice = 400
            R.id.CT -> ticketPrice = 250
        }

        // 取得購買張數，如果輸入不是數字，則預設為 0
        val numberOfTickets = txt!!.text.toString().toIntOrNull() ?: 0

        // 計算總票價
        val totalPrice = numberOfTickets * ticketPrice

        // 取得性別文字
        val genderText = when (rg!!.checkedRadioButtonId) {
            R.id.rdbBoy -> "男生"
            R.id.rdbGirl -> "女生"
            else -> ""
        }

        // 取得票種文字
        val ticketTypeText = when (i) {
            R.id.FFT -> "全票"
            R.id.ST -> "學生票"
            R.id.CT -> "兒童票"
            else -> ""
        }

        // 更新 lblOutput 顯示總金額和其他信息
        output!!.text = "$genderText\n$ticketTypeText ${txt!!.text}\n金額$totalPrice 元"
    }
}
